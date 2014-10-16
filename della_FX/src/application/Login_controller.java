package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Login_controller implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	private boolean flag=false;
	public TextField username;
	public AnchorPane LoginScreen;
	public TextField password;
	public Button login;
	private Button update_action;

	public void disable()
	{
		update_action.setVisible(false);
	}

	
	public void performlogin(){
		Stage primaryStage = new Stage();
		System.out.println("Starting login screen");
		Stage stage = (Stage) login.getScene().getWindow();
		// do what you have to do
		stage.close();

		while(!flag)
		{
			flag=checkLogin(username.getText(),password.getText());
			if(!flag)
			{
				System.out.println("invaid username or password");
			}else
			{
				try {
					Date d= new Date();
					Timestamp stamp= new Timestamp(d.getTime());
					System.out.println(stamp.toString());
					stmt.executeUpdate("INSERT INTO USERLOG(USERNAME,LOGINTIME,LOCKSTATUS) VALUES('"+username.getText()+"','"+stamp+"', 1);");
					disable();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			password.setText("");
		}

		try {
			Parent parent = FXMLLoader.load(getClass().getResource("Della_UI.fxml"));//ur fxml file name
			Scene scene = new Scene(parent);
			primaryStage.setTitle("Dellaaa");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private Statement stmt=null;
	private boolean checkLogin(String text, String text2) {
		 stmt=Main.getStmt();
		try {
			ResultSet rs;
			rs=stmt.executeQuery("select * from registeredUser where username= '" +text+"' ;");
			if(rs.next() && rs.getString(2).equals(text2))
			{
				System.out.println("login succesfully");
				return true;
			}
		} catch (SQLException e) {
			System.err.println("problem in query with the database");
			e.printStackTrace();
		}

		return false;
	}

}
