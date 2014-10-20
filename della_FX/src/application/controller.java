package application;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
	
	public  void disable()
	{
		System.out.println("in disable function");
		update_actionItem.setDisable(true);
		clear_actionItem.setDisable(true);
		create_actionItem.setDisable(true);
		delete_actionItem.setDisable(true);
	}
	public void update_actionItem(){}
	public void clearForm_actionItem()
	{}
	public void createNew_actionItem()
	{}
	public void deleteItem_actionItem()
	{}
	public void quitWindow()
	{
		Statement stmt= Main.getStmt();
		try {
			int row=stmt.executeUpdate("UPDATE enhanced_della.userlog SET lockstatus=0 WHERE lockstatus =1;");
			if(row!=0)
				System.out.println("Successful updation into userlog");
			Stage st= (Stage)quit.getScene().getWindow();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
