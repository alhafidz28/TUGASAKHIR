/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sweet.Cakee
 */
public class ContentController implements Initializable {

    @FXML
    private JFXButton asia;
    @FXML
    private JFXButton garuda;
    @FXML
    private JFXButton lion;
    @FXML
    private JFXButton avia;
    @FXML
    private JFXButton sriwijaya;
    @FXML
    private JFXButton citilink;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void asiaa(ActionEvent event) {
         try {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("asia.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("BookAnAirplane");
        stage.show();
        
        } catch (IOException e){
            System.out.println("Failed to create new Window." + e);
        }
    }

    @FXML
    private void garudaa(ActionEvent event) {
                 try {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("garuda.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("BookAnAirplane");
        stage.show();
        
        } catch (IOException e){
            System.out.println("Failed to create new Window." + e);
        }
    }

    @FXML
    private void lionn(ActionEvent event) {
                 try {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("lion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("BookAnAirplane");
        stage.show();
        
        } catch (IOException e){
            System.out.println("Failed to create new Window." + e);
        }
    }

    @FXML
    private void aviaa(ActionEvent event) {
                 try {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("avia.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("BookAnAirplane");
        stage.show();
        
        } catch (IOException e){
            System.out.println("Failed to create new Window." + e);
        }
    }

    @FXML
    private void sriwijayaa(ActionEvent event) {
                 try {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("sriwijayaair.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("BookAnAirplane");
        stage.show();
        
        } catch (IOException e){
            System.out.println("Failed to create new Window." + e);
        }
    }

    @FXML
    private void citilinkk(ActionEvent event) {
                 try {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("citilink.fxml"));
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
