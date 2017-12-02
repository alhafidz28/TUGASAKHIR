

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Sweet.Cakee
 */
public class AviaController implements Initializable {

    @FXML
    private JFXTextField depart;
    @FXML
    private JFXComboBox origin;
    ObservableList<String> originlist = FXCollections.observableArrayList("Malang","Surabaya","Semarang","Jogjakarta","Jakarta");
    @FXML
    private JFXComboBox destination;
    ObservableList<String> destinationlist = FXCollections.observableArrayList("Malang","Surabaya","Semarang","Jogjakarta","Jakarta");
    @FXML
    private JFXTextField guests;
    @FXML
    private JFXButton back;
    @FXML
    private JFXButton submit;
    
    public static String origin2;
    public static String destination2;
    public static String depart2;
    public static String guests2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        origin.setItems(originlist);
        destination.setItems(destinationlist);
        origin2= (String)origin.getValue();
        destination2= (String)destination.getValue();
        depart2= depart.getText();
        guests2= guests.getText();
    }    

    @FXML
    private void departt(ActionEvent event) {
    }

    @FXML
    private void originn(ActionEvent event) {
    }

    @FXML
    private void destinationn(ActionEvent event) {
    }

    @FXML
    private void guestss(ActionEvent event) {
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
    @FXML
    private void submitt(ActionEvent event) throws IOException {
        
        
            try {
                
                origin.setItems(originlist);
                destination.setItems(destinationlist);
                origin2= (String)origin.getValue();
                destination2= (String)destination.getValue();
                depart2= depart.getText();
                guests2= guests.getText();
                Connection connection;
                PreparedStatement ps;
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookanairplane", "root","");
                String query = "INSERT INTO `datapelanggan`(`origin`, `destination`, `date`, `guests`) VALUES (?,?,?,?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, (String) origin.getValue());
                ps.setString(2, (String) destination.getValue());
                ps.setString(3, depart.getText());
                ps.setString(4, guests.getText());
                ps.execute();
                
                JOptionPane.showMessageDialog(null, "Tersimpan");
                
                
                ((Node) (event.getSource())).getScene().getWindow().hide();
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("notaavia.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("BookAnAirplane");
        stage.show();
        
            } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Masukkan Data dengan Lengkap");
            }
        }
    
}
