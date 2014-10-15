package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Login_controller implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public TextField username;
	public AnchorPane LoginScreen;
	public TextField password;
	public Button login;
	public void performlogin(){
		Stage primaryStage = new Stage();
		System.out.print("okkkk ");
		Stage stage = (Stage) login.getScene().getWindow();
		// do what you have to do
		stage.close();
		try {

			Parent parent = FXMLLoader.load(getClass().getResource("Della_UI.fxml"));//ur fxml file name
			Scene scene = new Scene(parent);
			primaryStage.setTitle("Dellaaa");
			primaryStage.setScene(scene);
			primaryStage.show();
			//	LoginScreen
			//parent.setVisible(false);


		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
