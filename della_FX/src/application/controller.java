package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class controller implements Initializable
{


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
	}
	
	
	public Button update_actionItem;
	public Button quit;
	public Button clear_actionItem;
	public Button create_actionItem;
	public Button delete_actionItem;
	
	public TextField username;
	
	public Button AddToList_Members;
	public Button Remove_Members;
	public Button AddAffliation_Members;
	public Button RemoveAffliation_Members;
	
	public Button AddToList_Team;
	public Button Remove_Team;
	public Button AddAssociation_Team;
	public Button RemoveAssociation_Team;
	
	

	public  void disable()
	{
		System.out.println("in disable function");
		update_actionItem.setDisable(true);
		clear_actionItem.setDisable(true);
		create_actionItem.setDisable(true);
		delete_actionItem.setDisable(true);
		
		AddToList_Members.setDisable(true);
		Remove_Members.setDisable(true);
		AddAffliation_Members.setDisable(true);
		RemoveAffliation_Members.setDisable(true);
		
		AddToList_Team.setDisable(true);
		Remove_Team.setDisable(true);
		AddAssociation_Team.setDisable(true);
		RemoveAssociation_Team.setDisable(true);
		
	}
	public void update_actionItem(){}
	public void clearForm_actionItem()
	{}
	public void createNew_actionItem()
	{}
	public void deleteItem_actionItem()
	{}
	
	
	public void AddToList_Members()
	{}
	public void Remove_Members()
	{}
	public void AddAffliation_Members()
	{}
	public void RemoveAffliation_Members()
	{}
	
	public void AddToList_Team()
	{}
	public void Remove_Team()
	{}
	public void AddAssociation_Team()
	{}
	public void RemoveAssociation_Team()
	{}
	
	public void quitWindow()
	{
		Statement stmt= Main.getStmt();
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Scene scene=new Scene(root);
			scene.setRoot(root);
//			Stage primaryStage = new Stage();
//			primaryStage.initStyle(StageStyle.UNDECORATED);
//			primaryStage.setTitle("Dellaaaaaaaaaaaa");
//			primaryStage.setScene(scene);
//			primaryStage.show();
//
			
			Login_controller lc= fxmlLoader.getController();
			String username=lc.getUsername();
			int row=stmt.executeUpdate("UPDATE enhanced_della.userlog SET lockstatus=0 WHERE lockstatus =1 and USERNAME= '"+username+"';");
			if(row!=0)
				System.out.println("Successful updation into userlog by "+username);
			Stage st= (Stage)quit.getScene().getWindow();
			st.close();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
