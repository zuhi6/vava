package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import models.User;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Button createUserButton;

    @FXML
    private Label emailLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField emailTextField;


    public void initialize(URL fxmlFileLocation, ResourceBundle resources){
    	
    	loginButton.setOnAction(event->{
    		boolean found = false;
    		if(passwordTextField.getText().equals("") || emailTextField.getText().equals("")){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Required fields are not filled");
                alert.showAndWait();
            }else{
            	found = Main.remoteUser.checkCredentials(emailTextField.getText(), passwordTextField.getText());
                

            }
            if(found) {
            	User user = User.getInstance();
            	user = Main.remoteUser.getUserInfo(emailTextField.getText(),passwordTextField.getText());
            	
                Stage stage=(Stage) loginButton.getScene().getWindow();
                try {
                    Parent root;
                    root = FXMLLoader.load(getClass().getResource("/view/ProfileFXML.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Email/Password is incorrect");
                alert.showAndWait();

            }



    		
    	});
    		


    }
}