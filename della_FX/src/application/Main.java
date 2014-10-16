package application;

import java.sql.Statement;

import database_connection.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	private static Statement stmt=null ;
	
	protected static Statement getStmt() {
		return stmt;
	}


	@Override
	public void start(Stage primaryStage) {
		try {

			Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));//ur fxml file name
			Scene scene = new Scene(parent);
			primaryStage.setTitle("Dellaaa");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			stmt= (Statement) DBConnection.getConnection().createStatement();
		} catch (Exception e) {
			System.err.println("problem with ");
			e.printStackTrace();
		}
		launch(args);
	}
}
