/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Sweet.Cakee
 */
public class FXMLController implements Initializable {

    @FXML
    private JFXButton signin;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField fullname;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXButton back;
    @FXML
    private JFXButton signin1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void signinn(ActionEvent event) {
        Connection connection;
        PreparedStatement ps;
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Apakah anda akan menyimpan data");
        alert.setHeaderText(null);
        alert.setContentText("Tekan OK untuk menyimpan data, Cencel untuk batal.");
        Optional result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookanairplane", "root","");
                String query = "INSERT INTO `bookanairplane`(`username`, `password`, `name`, `email`) VALUES (?,?,?,?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, username.getText());
                ps.setString(2, password.getText());
                ps.setString(3, fullname.getText());
                ps.setString(4, email.getText());
                
                ps.execute();
                Alert berhasil = new Alert(AlertType.INFORMATION);
                berhasil.setTitle("Informasi Database");
                berhasil.setHeaderText(null);
                berhasil.setContentText("Data "+username.getText()+" Telah Berhasil Disimpan\n\nTerima Kasih.");   
                berhasil.showAndWait();
                ps.close();
            } catch (SQLException e) {
                Alert gagal = new Alert(AlertType.ERROR);
                gagal.setTitle("Informasi Database");
                gagal.setHeaderText(null);
                gagal.setContentText("Data "+username.getText()+" Tidak Dapat Disimpan\n\nSilahkan Di Ulang.\n"
                        + "Error = "+e);
                gagal.showAndWait();
            }
        } else {
            alert.close();
        }
    }

    @FXML
    private void usernamee(ActionEvent event) {
    }

    @FXML
    private void passwordd(ActionEvent event) {
    }

    @FXML
    private void fullnamee(ActionEvent event) {
    }

    @FXML
    private void emaill(ActionEvent event) {
    }

    @FXML
    private void backk(ActionEvent event) {
        try {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("BookAnAirplane");
        stage.show();
        
        } catch (IOException e){
            System.out.println("Failed to create new Window." + e);
        }
    }
    
}
