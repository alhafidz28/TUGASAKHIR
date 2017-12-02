/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXPasswordField;
import com.mysql.jdbc.Connection;
import java.awt.Component;
import java.io.IOException;
import java.net.URL;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 *
 * @author Sweet.Cakee
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton signin;
    @FXML
    private JFXButton signup;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void usernamee(ActionEvent event) {
    }

    @FXML
    private void passwordd(ActionEvent event) {
    }

    @FXML
    private void signinn(ActionEvent event) throws IOException, SQLException {
        
        String user;
        try{
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bookanairplane", "root", "");
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `bookanairplane` WHERE `username` = ? AND `password` =?");
            ps.setString(1, username.getText());
            ps.setString(2, password.getText());
            ResultSet result = ps.executeQuery();
            if (result.next()){
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Content.fxml"));
            Scene scene = new Scene (fxmlLoader.load());
            
            Stage stage = new Stage ();
            stage.setScene(scene);
            stage.setTitle("Homepage");
            stage.show();
            }
            else{
                Component rootPane = null;
                JOptionPane.showMessageDialog(null, "Salah");
                password.setText("");
                username.requestFocus();
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Gagal");
        }
    }

    @FXML
    private void signupp(ActionEvent event) {
                try {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FXML.fxml"));
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
