package application;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.stage.StageStyle;

import model.ActionItem;
import model.ActionItemManager;
import control.Controller;




public class controller implements Initializable
{
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public Button button_action;

	//public Button button_action;
	public Button quit;
	
	@FXML
	public Button update_actionItem;
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

	public void disable() {
		System.out.println("in disable function");
		//button_action.setDisable(true);
		update_actionItem.setDisable(true);
//		update_actionItem.cancelButtonProperty()
	//	System.out.println("--->"+update_actionItem.cancelButtonProperty().get());
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

	public void update_actionItem() {
	}

	public void clearForm_actionItem() {
	}

	public void createNew_actionItem() {
	}

	public void deleteItem_actionItem() {
	}

	public void AddToList_Members() {
	}

	public void Remove_Members() {
	}

	public void AddAffliation_Members() {
	}

	public void RemoveAffliation_Members() {
	}

	public void AddToList_Team() {
	}

	public void Remove_Team() {
	}

	public void AddAssociation_Team() {
	}

	public void RemoveAssociation_Team() {
	}

	public void quitWindow() {
		Statement stmt = Main.getStmt();
		try {
			// FXMLLoader fxmlLoader = new
			// FXMLLoader(getClass().getResource("Login.fxml"));
			// Parent root = (Parent) fxmlLoader.load();
			// Scene scene=new Scene(root);
			// scene.setRoot(root);
			// Stage primaryStage = new Stage();
			// primaryStage.initStyle(StageStyle.UNDECORATED);
			// primaryStage.setTitle("Dellaaaaaaaaaaaa");
			// primaryStage.setScene(scene);
			// primaryStage.show();
			//

			// Login_controller lc= fxmlLoader.getController();
			String username="";
			username=new Login_controller().getUsername();
			int row=stmt.executeUpdate("UPDATE enhanced_della.userlog SET lockstatus=0 WHERE lockstatus =1 and USERNAME= '"+username+"';");
			if(row!=0)
				System.out.println("Successful updation into userlog by "+username);
			Stage st= (Stage)quit.getScene().getWindow();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// console screen
	/**
	 * 
	 * List<String> list = new ArrayList<String>();
	 * 
	 * obList = FXCollections.observableList(list);
	 * jcbcountry.getItems().clear(); jcbcountry.setItems(obList);
	 */
	public static final int noItemSelected = -1; // Added for Della03

	// ---------------------------------------------------------------------------------------------------------------------
	// Console Screen attributes

	// Added for Della03 (start)
	private boolean updatingGUI = false;
	private Controller theController = null;
	private ActionItemManager aiM = null;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	// / Added for Della03 (end)

	// ---------------------------------------------------------------------------------------------------------------------
	// Console Screen GUI elements
	public Label consoleLabel = new Label();

	// Added for Della03 (start)
	public Label actionItemsLabel = new Label();

	public ListView aiSelectList = new ListView();

	// JList aiSelectList = new JList(new DefaultListModel());
	// JScrollPane scrollableListPane = new JScrollPane(aiSelectList,
	// JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	// JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	// ListSelectionListener listSelectionListner = new ListSelectionListener()
	// {
	// public void valueChanged(ListSelectionEvent listSelectionEvent) {
	// selectActionItem();
	// }
	// };
	public ComboBox sortDirectionComboBox = new ComboBox();
	public ComboBox sortFactor1ComboBox = new ComboBox();
	public ComboBox sortFactor2ComboBox = new ComboBox();
	public ComboBox inclusionFactorComboBox = new ComboBox();
	ObservableList inclusionFactorlist = FXCollections
			.observableArrayList(ActionItemManager.inclusionFactorStrings);
	// JComboBox sortDirectionComboBox = new
	// JComboBox(ActionItemManager.sortDirectionStrings);
	ObservableList<String> sortDirectionList = FXCollections
			.observableArrayList(ActionItemManager.sortDirectionStrings);
	ObservableList<String> sortFactor1List = FXCollections
			.observableArrayList(ActionItemManager.sortingFactorStrings);
	ObservableList<String> sortFactor2List = FXCollections
			.observableArrayList(ActionItemManager.sortingFactorStrings);

	// JComboBox sortFactor1ComboBox = new
	// JComboBox(ActionItemManager.sortingFactorStrings);
	// JComboBox sortFactor2ComboBox = new
	// JComboBox(ActionItemManager.sortingFactorStrings);
	public Label firstSortingLabel = new Label();
	public Label secondSortingLabel = new Label();
	public Label sortDirectionLabel = new Label();
	public Label inclusionFactorLabel = new Label();

	// ActionListener inclusionFactorActionListner = new ActionListener() {
	// public void actionPerformed(ActionEvent ae) {
	// listInclusionAction(ae);
	// }
	// };

	// ActionListener sortDirectionActionListner = new ActionListener() {
	// public void actionPerformed(ActionEvent ae) {
	// sortDirection(ae);
	// }
	// };
	// ActionListener sortFactor1ActionListner = new ActionListener() {
	// public void actionPerformed(ActionEvent ae) {
	// sortFactor1(ae);
	// }
	// };
	// ActionListener sortFactor2ActionListner = new ActionListener() {
	// public void actionPerformed(ActionEvent ae) {
	// sortFactor2(ae);
	// }
	// };
	// Added for Della03 (end)

	// Added for Della10 (start)

	// Added for Della10 (end)

	// Added for Della03 (start)
	public Label selectedLabel = new Label();
	public Label nameLabel = new Label();
	public TextField nameTextField = new TextField();
	public Label descriptionLabel = new Label();
	public TextArea descriptionTextArea = new TextArea();
	// TextArea descriptionTextArea = new JTextArea();
	public Label resolutionLabel = new Label();
	// JScrollPane resolutionScrollPane = new JScrollPane();
	public TextArea resolutionTextArea = new TextArea();

	public Label datesLabel = new Label();
	public Label creationDateLabel = new Label();
	public Label creationDateValueLabel = new Label();
	public Label dueLabel = new Label();
	public Label dueDateTextLabel = new Label();
	public Label actionItemLabel2 = new Label();
	public Label statusLabel = new Label();
	public Label statusValueLabel = new Label();
	// Added for Della03 (end)

	// Added for Della05 (start)
	public Label selectMemberLabel = new Label();
	public Label selectMemberValueLabel = new Label();
	// Added for Della05 (end)

	// Added for Della09 (start)
	public Label selectTeamLabel = new Label();
	public Label selectTeamValueLabel = new Label();
	// Added for Della09 (end)

	public Label copyrightLabel = new Label();

	// ---------------------------------------------------------------------------------------------------------------------

	/**
	 * The ConsoleScreen class constructor.
	 * 
	 * @return
	 * 
	 */
	public void ConsoleScreen() {
		// Use a modified singleton pattern to access the application's state;
		// Added for Della03
		theController = Controller.getInstance();
		aiM = theController.getActionItemManager();
		sortDirectionComboBox.setItems(sortDirectionList);
		sortFactor1ComboBox.setItems(sortFactor1List);
		sortFactor2ComboBox.setItems(sortFactor2List);
		inclusionFactorComboBox.setItems(inclusionFactorlist);
		// Set up all of the Graphical User Interface elements and position them
		// on the screen
		guiInit();

		// Initialize the screen with the current action item; Added for Della03
		loadScreen();
	}

	/**
	 * Initialize each graphic element, position it on the screen, and add it to
	 * the loayout.
	 * 
	 */
	public void guiInit() {

	}

	/**
	 * Based on a combobox selection, establish the screen's fields
	 * 
	 * @param evt
	 *            ActionEvent - Any event that gets here is treated as a
	 *            selection event
	 * 
	 *            Added for Della03
	 */
	public void selectActionItem() {
		if (updatingGUI == false) {
			// The select list yields an index. Use that to find the
			// corresponding action item
			ActionItem selectedAI = aiM.getActionItem(aiSelectList
					.getSelectionModel().getSelectedIndex());

			// Establish the current action item fields
			aiM.setCurrentActionItem(selectedAI);

			// Establish the screen editing fields
			nameTextField.setText(selectedAI.getActionItemName());
			descriptionTextArea.setText(selectedAI.getDescription());
			// descriptionTextArea.setCaretPosition(0);
			resolutionTextArea.setText(selectedAI.getResolution());
			// resolutionTextArea.setCaretPosition(0);
			creationDateValueLabel.setText(dateFormat.format(selectedAI
					.getCreatedDate()));
			if (selectedAI.getDueDate() != null)
				dueDateTextLabel.setText(dateFormat.format(selectedAI
						.getDueDate()));
			else
				dueDateTextLabel.setText("");

			// Establish the status display
			if (selectedAI.getStatus() == "Closed")
				statusValueLabel.setText("Closed");
			else
				statusValueLabel.setText("Open");

			// Establish the assigned member display - Added for Della05
			String memberName = selectedAI.getAssignedMember();
			if (memberName.length() == 0) {
				selectMemberValueLabel.setText("- no member assigned -");
				aiM.getMemberList().setCurrentSelectedElementIndex(
						noItemSelected);
			} else {
				selectMemberValueLabel.setText(selectedAI.getAssignedMember());
				int memberNameIndex = aiM.getMemberList().findElement(
						memberName);
				aiM.getMemberList().setCurrentSelectedElementIndex(
						memberNameIndex);
			}

			// Establish the assigned team display - Added for Della09
			String teamName = selectedAI.getAssignedTeam();
			if (teamName.length() == 0) {
				selectTeamValueLabel.setText("- no team assigned -");
				aiM.getTeamList()
						.setCurrentSelectedElementIndex(noItemSelected);
			} else {
				selectTeamValueLabel.setText(teamName);
				int teamNameIndex = aiM.getTeamList().findElement(teamName);
				aiM.getTeamList().setCurrentSelectedElementIndex(teamNameIndex);
			}

			// The selected action item has changed so the state has changed
			theController.setDirtyFlag(true);
		}
	}

	/**
	 * The action item selection select list is dynamic. What is displayed there
	 * comes from the current names for each of the action items and since the
	 * user can change those at will, the select list must change as well
	 * 
	 * The buildingSelectList flag is used to signal the rest of this screen
	 * that the select list is in the process of being updated. Change change to
	 * the select list whether brought about by the user or by code, results in
	 * change events. We do not want change events that come from defining the
	 * select list to cause changes to the display.
	 * 
	 * This routine assumes that the order of the action items in the vector is
	 * precisely the correct order for display in the select list. Sorting must
	 * be done elsewhere.
	 * 
	 * @param names
	 *            String[] - This is the sorted array of names for the select
	 *            list
	 * 
	 *            Added for Della03
	 */
	public void loadSelectListData(String[] names, int newIndex) {
		// Ignore combobox change events
		updatingGUI = true;

		// Define the select list
		// (aiSelectList.getModel()).removeAllElements();
		aiSelectList.getItems().clear();
		if (names != null) // If names is null, there are no action items
			for (int i = 0; i < names.length; i++) {
				// ((DefaultListModel)aiSelectList.getModel()).addElement(names[i]);
				// aiSelectList.getSelectionModel().
			}

		// Set the current selected item
		aiSelectList.getSelectionModel().select(newIndex);

		// Done updating the Select List
		updatingGUI = false;
	}

	/**
	 * Based on a combobox selection, establish the sorting direction
	 * 
	 * @param evt
	 *            ActionEvent - Any event that get's here we process as a combo
	 *            box selection
	 * 
	 *            Added for Della03
	 */
	public void sortDirection() {
		if (updatingGUI == false) {
			// Get the sorting direction indicator and use that to rebuild the
			// select list
			aiM.setSortDirection(sortDirectionComboBox.getSelectionModel()
					.getSelectedIndex());
			loadSelectListData(aiM.getActionItemNames(),
					aiM.getActionItemIndex(aiM.getCurrentActionItemName()));

			// The sorting direction has changed so the state has changed
			theController.setDirtyFlag(true);
		}
	}

	/**
	 * Based on a combobox selection, establish the sorting factor
	 * 
	 * @param evt
	 *            ActionEvent - Any event that get's here we process as a combo
	 *            box selection
	 * 
	 *            Added for Della03
	 */
	public void sortFactor1() {
		if (updatingGUI == false) {
			// Get the sorting factor 1 indicator and use that to rebuild the
			// select list
			aiM.setSortFactor1(sortFactor1ComboBox.getSelectionModel()
					.getSelectedIndex());
			loadSelectListData(aiM.getActionItemNames(),
					aiM.getActionItemIndex(aiM.getCurrentActionItemName()));

			// A sorting factor has changed so the state has changed
			theController.setDirtyFlag(true);
		}
	}

	/**
	 * Based on a combobox selection, establish the sorting factor
	 * 
	 * @param evt
	 *            ActionEvent - Any event that get's here we process as a combo
	 *            box selection
	 * 
	 *            Added for Della03
	 */
	public void sortFactor2() {
		if (updatingGUI == false) {
			// Get the sorting factor 2 indicator and use that to rebuild the
			// select list
			aiM.setSortFactor2(sortFactor2ComboBox.getSelectionModel()
					.getSelectedIndex());
			loadSelectListData(aiM.getActionItemNames(),
					aiM.getActionItemIndex(aiM.getCurrentActionItemName()));

			// A sorting factor has changed so the state has changed
			theController.setDirtyFlag(true);
		}
	}

	/**
	 * Clear the current action item and reset the text fields on the display
	 * 
	 * Added for Della03
	 */
	public void clearAI() {
		updatingGUI = true;
		aiM.setCurrentActionItem(aiM.getActionItem(noItemSelected));
		aiM.clearCurrentActionItem();
		nameTextField.setText("");
		descriptionTextArea.setText("");
		// descriptionTextArea.setCaretPosition(0);
		resolutionTextArea.setText("");
		// resolutionTextArea.setCaretPosition(0);
		statusValueLabel.setText("Open");
		creationDateValueLabel.setText("");
		creationDateValueLabel.setText("");
		selectMemberValueLabel.setText("- no member assigned -"); // Added for
																	// Della05
		selectTeamValueLabel.setText("- no team assigned -"); // Added for
																// Della09
		updatingGUI = false;
	}

	/**
	 * Fill the screen with the values of the current action item, if we have
	 * one
	 * 
	 * Added for Della03
	 */
	public void loadScreen() {
		updatingGUI = true;
		// Fetch the current action item. If there isn't one, set up a blank
		// action item
		ActionItem ai = aiM.getCurrentActionItem();
		if (ai == null) {
			clearAI();
		} else {
			// Define the text fields for the existing action item
			nameTextField.setText(ai.getActionItemName());
			descriptionTextArea.setText(ai.getDescription());
			// descriptionTextArea.setCaretPosition(0);
			resolutionTextArea.setText(ai.getResolution());
			// resolutionTextArea.setCaretPosition(0);

			// Establish the status display
			if (ai.getStatus() == "Closed")
				statusValueLabel.setText("Closed");
			else
				statusValueLabel.setText("Open");

			// Define the creation and due dates
			if (ai.getCreatedDate() != null)
				creationDateValueLabel.setText(dateFormat.format(ai
						.getCreatedDate()));
			else
				creationDateValueLabel.setText("");
			if (ai.getDueDate() != null)
				dueDateTextLabel.setText(dateFormat.format(ai.getDueDate()));
			else
				creationDateValueLabel.setText("");

			// Establish the assigned member display - Added for Della05
			String name = ai.getAssignedMember();
			if (name.length() == 0)
				selectMemberValueLabel.setText("- no member assigned -");
			else
				selectMemberValueLabel.setText(ai.getAssignedMember());

			// Establish the assigned team display - Added for Della09
			String teamName = ai.getAssignedTeam();
			if (teamName.length() == 0)
				selectTeamValueLabel.setText("- no team assigned -");
			else
				selectTeamValueLabel.setText(ai.getAssignedTeam());
		}
		// Set up the selection ComboBoxes and the select list - Modified for
		// Della03
		sortDirectionComboBox.getSelectionModel()
				.select(aiM.getSortDirection());
		sortFactor1ComboBox.getSelectionModel().select(aiM.getSortFactor1());
		sortFactor2ComboBox.getSelectionModel().select(aiM.getSortFactor2());
		inclusionFactorComboBox.getSelectionModel().select(
				aiM.getInclusionFactor()); // Added for Della10
		loadSelectListData(aiM.getActionItemNames(),
				aiM.getActionItemIndex(aiM.getCurrentActionItemName()));
		updatingGUI = false;
	}

	/**
	 * Process a select an inclusion factor event
	 * 
	 * @param e
	 *            ActionEvent
	 * 
	 *            Added for Della10
	 */
	public void listInclusionAction() {
		if (updatingGUI == false) {
			aiM.setInclusionFactor(inclusionFactorComboBox.getSelectionModel()
					.getSelectedIndex());
			loadSelectListData(aiM.getActionItemNames(),
					aiM.getActionItemIndex(aiM.getCurrentActionItemName()));
			if (aiSelectList.getSelectionModel().getSelectedIndex() == noItemSelected) {
				clearAI();
				loadScreen();
			}
			// A sorting factor has changed so the state has changed
			theController.setDirtyFlag(true);
		}
	}

	// console screen

}
