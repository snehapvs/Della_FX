package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Dialogs.DialogOptions;
import javafx.scene.control.Dialogs.DialogResponse;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import persistence.Synchronization;


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
	public static String uname;
	public controller_class c;
	private static  FileInputStream in= null;			
	public void performlogin(){

		Stage primaryStage = new Stage();
		System.out.println("Starting login screen");
		Stage stage = (Stage) login.getScene().getWindow();
		// do what you have to do



		if(new Synchronization().isUserOnline())
		{
			flag=checkLogin(username.getText().trim(),password.getText().trim());
			if(!flag)
			{
				System.out.println("invaid username or password");
				Dialogs.showErrorDialog(stage, "invalid username or password",
						"Error!");
			}else
			{
				FXMLLoader fxmlLoader = null;
				try {
					stage.close();
					fxmlLoader = new FXMLLoader(getClass().getResource("Della_UI.fxml"));
					Parent root = (Parent) fxmlLoader.load();
					Scene scene=new Scene(root);
					scene.setRoot(root);
					primaryStage.initStyle(StageStyle.UNDECORATED);
					primaryStage.setTitle("Dellaaa");
					primaryStage.setScene(scene);
					primaryStage.show();


					c=fxmlLoader.getController();

				} catch(Exception e) {
					e.printStackTrace();
				}

				uname= username.getText().trim();
				try {
					ResultSet row=stmt.executeQuery("SELECT * FROM userlog WHERE lockstatus = 1 ;");
					if(!row.next())
					{
						//System.out.println(row.getString("username"));
						Date d= new Date();
						Timestamp stamp= new Timestamp(d.getTime());
						System.out.println(stamp.toString());
						stmt.executeUpdate("INSERT INTO USERLOG(USERNAME,LOGINTIME,LOCKSTATUS) VALUES('"+username.getText()+"','"+stamp+"', 1);");
					}
					else{
						//System.out.println("check 1");
						c.disable();
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			username.setText("");
			password.setText("");
		}
		else
		{
			Properties props=null;
			props= new Properties();
			try {

				in= new FileInputStream(new File("login.properties"));
				props.load(in);
				if(username.getText().trim().equals(props.getProperty("username"))
						&& password.getText().trim().equals(props.getProperty("password")))
				{
					FXMLLoader fxmlLoader = null;
					try {
						stage.close();
						fxmlLoader = new FXMLLoader(getClass().getResource("Della_UI.fxml"));
						Parent root = (Parent) fxmlLoader.load();
						Scene scene=new Scene(root);
						scene.setRoot(root);
						primaryStage.initStyle(StageStyle.UNDECORATED);
						primaryStage.setTitle("Dellaaa");
						primaryStage.setScene(scene);
						primaryStage.show();


						c=fxmlLoader.getController();
					}
					catch(Exception e) {
						e.printStackTrace();
					}

				}
				else
				{
					System.out.println("invalid username or password");
				}

			} catch (IOException e) {
				System.out.println("File not found properties.config");
				e.printStackTrace();
			}
			finally
			{
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public String getUsername() {

		return uname;
	}
	public void setUsername(TextField username) {
		this.username = username;
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
