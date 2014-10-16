package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class controller implements Initializable
{

	private Button update_action;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{

	//	disable();
		
	}

	public void disable()
	{
		update_action.setVisible(false);
	}
	
}
