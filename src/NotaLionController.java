/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sweet.Cakee
 */
public class NotaLionController implements Initializable {

    @FXML
    private JFXButton back;
    @FXML
    private Label origin;
    @FXML
    private Label destination;
    @FXML
    private Label depart;
    @FXML
    private Label guests;
    @FXML
    private Label total;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       nota();
    }    

    @FXML
    private void backk(ActionEvent event) {
            try {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Content.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("BookAnAirplane");
        stage.show();
        
        } catch (IOException e){
            System.out.println("Failed to create new Window." + e);
        }
    }
    
    private void nota(){
        int lion = 500000;
        int guest = Integer.parseInt(LionController.guests2);
        int totall = lion * guest;
        origin.setText(LionController.origin2);
        destination.setText(LionController.destination2);
        depart.setText(LionController.depart2);
        guests.setText(LionController.guests2);
        total.setText(" "+Integer.toString(totall));
    }
    
}
