/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtt;

import conexion.Conexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 *
 * @author Alex Clemente < DAW >
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ComboBox<String> tablas;

    ObservableList<String> listaTablas = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Extrae todas las tablas existentes en video
        try {
            Connection con = Conexion.conectar("videop", "video_user", "0");
            PreparedStatement stmt = con.prepareStatement("SHOW FULL TABLES");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listaTablas.add(rs.getString("Tables_in_videop"));
            }
            tablas.getItems().addAll(listaTablas);
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta a la base de datos.");
        }

    }

}
