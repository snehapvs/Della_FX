package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class controller implements Initializable
{


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
<<<<<<< HEAD


=======
>>>>>>> 8a2dad699be68ee765492ffd3efbc3ae0aa498bd
	}
	
	
	public Button button_action;

	public  void disable()
	{
		System.out.println("in disable function");
		button_action.setDisable(true);
	}
}
