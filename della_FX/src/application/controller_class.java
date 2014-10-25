package application;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ActionItem;
import model.ActionItemManager;
import model.ElementList;
import control.Controller;


public class controller_class implements Initializable
{





	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
	}



	public Button button_action;


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
		button_action.setDisable(true);
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
			//FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
			//		Parent root = (Parent) fxmlLoader.load();
			//	Scene scene=new Scene(root);
			//scene.setRoot(root);
			//			Stage primaryStage = new Stage();
			//			primaryStage.initStyle(StageStyle.UNDECORATED);
			//			primaryStage.setTitle("Dellaaaaaaaaaaaa");
			//			primaryStage.setScene(scene);
			//			primaryStage.show();
			//

			//Login_controller lc= fxmlLoader.getController();
			String username="vaibhav";
			//lc.getUsername();
			int row=stmt.executeUpdate("UPDATE enhanced_della.userlog SET lockstatus=0 WHERE lockstatus =1 and USERNAME= '"+username+"';");
			if(row!=0)
				System.out.println("Successful updation into userlog by "+username);
			Stage st= (Stage)quit.getScene().getWindow();
			st.close();
		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//console screen
	

	//---------------------------------------------------------------------------------------------------------------------
	// Console Screen attributes

	// Added for Della03 (start)
	public static final int noItemSelected = -1;
	public boolean updatingteamGUI = false;
	public Controller theController = null;
	public ActionItemManager aiM = null;
	public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	/// Added for Della03 (end)

	//---------------------------------------------------------------------------------------------------------------------
	// Console Screen GUI elements
	public Label consoleLabel = new Label();
	// Added for Della03 (start)
	public Label actionItemsLabel = new Label();
	public ListView aiSelectList=new ListView();

	//JList aiSelectList = new JList(new DefaultListModel());
	//			JScrollPane scrollableListPane = new JScrollPane(aiSelectList, 
	//					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//			ListSelectionListener listSelectionListner = new ListSelectionListener() {
	//				public void valueChanged(ListSelectionEvent listSelectionEvent) {
	//					selectActionItem();
	//				}
	//			};
	public ComboBox sortDirectionComboBox=new ComboBox();
	public ComboBox sortFactor1ComboBox=new ComboBox();
	public ComboBox sortFactor2ComboBox=new ComboBox();
	public ComboBox inclusionFactorComboBox = new ComboBox();
	ObservableList inclusionFactorlist= FXCollections.observableArrayList(ActionItemManager.inclusionFactorStrings);
	//	JComboBox sortDirectionComboBox = new JComboBox(ActionItemManager.sortDirectionStrings);
	ObservableList<String> sortDirectionList = FXCollections.observableArrayList(ActionItemManager.sortDirectionStrings);
	ObservableList<String> sortFactor1List = FXCollections.observableArrayList(ActionItemManager.sortingFactorStrings);
	ObservableList<String> sortFactor2List = FXCollections.observableArrayList(ActionItemManager.sortingFactorStrings);


	//JComboBox sortFactor1ComboBox = new JComboBox(ActionItemManager.sortingFactorStrings);
	//JComboBox sortFactor2ComboBox = new JComboBox(ActionItemManager.sortingFactorStrings);
	public Label firstSortingLabel = new Label();
	public Label secondSortingLabel = new Label();
	public Label sortDirectionLabel = new Label();
	public Label inclusionFactorLabel = new Label();

	//			ActionListener inclusionFactorActionListner = new ActionListener() {
	//				public void actionPerformed(ActionEvent ae) {
	//					listInclusionAction(ae);
	//				}
	//			};

	//			ActionListener sortDirectionActionListner = new ActionListener() {
	//				public void actionPerformed(ActionEvent ae) {
	//					sortDirection(ae);
	//				}
	//			};
	//			ActionListener sortFactor1ActionListner = new ActionListener() {
	//				public void actionPerformed(ActionEvent ae) {
	//					sortFactor1(ae);
	//				}
	//			};
	//			ActionListener sortFactor2ActionListner = new ActionListener() {
	//				public void actionPerformed(ActionEvent ae) {
	//					sortFactor2(ae);
	//				}
	//			};
	// Added for Della03 (end)

	// Added for Della10 (start)

	// Added for Della10 (end)

	// Added for Della03 (start)
	public Label selectedLabel = new Label();
	public Label nameLabel = new Label();
	public TextField nameTextField = new TextField();
	public Label descriptionLabel = new Label();
	public TextArea descriptionTextArea = new TextArea();
	//TextArea descriptionTextArea = new JTextArea();
	public Label resolutionLabel = new Label();
	//JScrollPane resolutionScrollPane = new JScrollPane();
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
	//---------------------------------------------------------------------------------------------------------------------

	/**
	 * The ConsoleScreen class constructor.
	 * @return 
	 * 
	 */
	public void ConsoleScreen() {
		// Use a modified singleton pattern to access the application's state; Added for Della03
		theController = Controller.getInstance();
		aiM = theController.getActionItemManager();
		sortDirectionComboBox.setItems(sortDirectionList);
		sortFactor1ComboBox.setItems(sortFactor1List);
		sortFactor2ComboBox.setItems(sortFactor2List);
		inclusionFactorComboBox.setItems(inclusionFactorlist);
		// Set up all of the Graphical User Interface elements and position them on the screen
		guiInit();

		// Initialize the screen with the current action item; Added for Della03
		loadScreen();
	}

	/**
	 * Initialize each graphic element, position it on the screen, and add it to the loayout.
	 * 
	 */
	//			public void guiInit() {
	//				
	//				
	//			}
	/**
	 * Based on a combobox selection, establish the screen's fields
	 * 
	 * @param evt	ActionEvent - Any event that gets here is treated as a selection event
	 * 
	 * Added for Della03
	 */
	public void selectActionItem() {
		if (updatingGUI == false){
			// The select list yields an index.  Use that to find the corresponding action item
			ActionItem selectedAI = aiM.getActionItem(aiSelectList.getSelectionModel().getSelectedIndex());

			// Establish the current action item fields
			aiM.setCurrentActionItem(selectedAI);

			// Establish the screen editing fields
			nameTextField.setText(selectedAI.getActionItemName());
			descriptionTextArea.setText(selectedAI.getDescription());
			//descriptionTextArea.setCaretPosition(0);
			resolutionTextArea.setText(selectedAI.getResolution());
			//resolutionTextArea.setCaretPosition(0);
			creationDateValueLabel.setText(dateFormat.format(selectedAI.getCreatedDate()));
			if (selectedAI.getDueDate() != null)
				dueDateTextLabel.setText(dateFormat.format(selectedAI.getDueDate()));
			else
				dueDateTextLabel.setText("");

			// Establish the status display 
			if (selectedAI.getStatus() == "Closed")
				statusValueLabel.setText("Closed");
			else
				statusValueLabel.setText("Open");

			// Establish the assigned member display - Added for Della05
			String memberName = selectedAI.getAssignedMember();
			if (memberName.length()==0) {
				selectMemberValueLabel.setText("- no member assigned -");
				aiM.getMemberList().setCurrentSelectedElementIndex(noItemSelected);
			}
			else {
				selectMemberValueLabel.setText(selectedAI.getAssignedMember());
				int memberNameIndex = aiM.getMemberList().findElement(memberName);
				aiM.getMemberList().setCurrentSelectedElementIndex(memberNameIndex);
			}

			// Establish the assigned team display - Added for Della09
			String teamName = selectedAI.getAssignedTeam();
			if (teamName.length()==0) {
				selectTeamValueLabel.setText("- no team assigned -");
				aiM.getTeamList().setCurrentSelectedElementIndex(noItemSelected);
			}
			else {
				selectTeamValueLabel.setText(teamName);
				int teamNameIndex = aiM.getTeamList().findElement(teamName);
				aiM.getTeamList().setCurrentSelectedElementIndex(teamNameIndex);
			}

			// The selected action item has changed so the state has changed
			theController.setDirtyFlag(true);
		}
	}


	/**
	 * The action item selection select list is dynamic.  What is displayed there 
	 * comes from the current names for each of the action items and since the
	 * user can change those at will, the select list must change as well
	 * 
	 * The buildingSelectList flag is used to signal the rest of this screen that
	 * the select list is in the process of being updated.  Change change to the 
	 * select list whether brought about by the user or by code, results in change
	 * events.  We do not want change events that come from defining the 
	 * select list to cause changes to the display.
	 * 
	 * This routine assumes that the order of the action items in the vector is
	 * precisely the correct order for display in the select list.  Sorting must be
	 * done elsewhere.
	 * 
	 * @param names	String[] - This is the sorted array of names for the select list
	 * 
	 * Added for Della03
	 */
	public void loadSelectListData(String[] names, int newIndex){
		// Ignore combobox change events
		updatingGUI = true;

		// Define the select list
		//(aiSelectList.getModel()).removeAllElements();
		aiSelectList.getItems().clear();
		if (names != null) // If names is null, there are no action items
			for (int i=0; i < names.length; i++){
				//	((DefaultListModel)aiSelectList.getModel()).addElement(names[i]);
				//aiSelectList.getSelectionModel().
			}

		// Set the current selected item
		aiSelectList.getSelectionModel().select(newIndex);

		// Done updating the Select List
		updatingGUI = false;
	}

	/**
	 * Based on a combobox selection, establish the sorting direction
	 * @param evt ActionEvent - Any event that get's here we process as a combo box selection
	 * 
	 * Added for Della03
	 */
	public void sortDirection(){
		if (updatingGUI == false){
			// Get the sorting direction indicator and use that to rebuild the select list
			aiM.setSortDirection(sortDirectionComboBox.getSelectionModel().getSelectedIndex());
			loadSelectListData(aiM.getActionItemNames(), aiM.getActionItemIndex(aiM.getCurrentActionItemName()));

			// The sorting direction has changed so the state has changed
			theController.setDirtyFlag(true);
		}
	}

	/**
	 * Based on a combobox selection, establish the sorting factor
	 * @param evt ActionEvent - Any event that get's here we process as a combo box selection
	 * 
	 * Added for Della03
	 */
	public void sortFactor1(){
		if (updatingGUI == false){
			// Get the sorting factor 1 indicator and use that to rebuild the select list
			aiM.setSortFactor1(sortFactor1ComboBox.getSelectionModel().getSelectedIndex());
			loadSelectListData(aiM.getActionItemNames(), aiM.getActionItemIndex(aiM.getCurrentActionItemName()));

			// A sorting factor has changed so the state has changed
			theController.setDirtyFlag(true);
		}
	}

	/**
	 * Based on a combobox selection, establish the sorting factor
	 * @param evt ActionEvent - Any event that get's here we process as a combo box selection
	 * 
	 * Added for Della03
	 */
	public void sortFactor2(){
		if (updatingGUI == false){
			// Get the sorting factor 2 indicator and use that to rebuild the select list
			aiM.setSortFactor2(sortFactor2ComboBox.getSelectionModel().getSelectedIndex());
			loadSelectListData(aiM.getActionItemNames(), aiM.getActionItemIndex(aiM.getCurrentActionItemName()));

			// A sorting factor has changed so the state has changed
			theController.setDirtyFlag(true);
		}
	} 

	/**
	 * Clear the current action item and reset the text fields on the display
	 * 
	 * Added for Della03
	 */
	public void clearAI(){
		updatingGUI = true;
		aiM.setCurrentActionItem(aiM.getActionItem(noItemSelected));
		aiM.clearCurrentActionItem();
		nameTextField.setText("");
		descriptionTextArea.setText("");
		//descriptionTextArea.setCaretPosition(0);
		resolutionTextArea.setText("");
		//resolutionTextArea.setCaretPosition(0);
		statusValueLabel.setText("Open");
		creationDateValueLabel.setText("");
		creationDateValueLabel.setText("");
		selectMemberValueLabel.setText("- no member assigned -");	// Added for Della05
		selectTeamValueLabel.setText("- no team assigned -");		// Added for Della09
		updatingGUI = false;
	}

	/**
	 * Fill the screen with the values of the current action item, if we have one
	 * 
	 * Added for Della03
	 */
	public void loadScreen() {
		updatingGUI = true;
		// Fetch the current action item.  If there isn't one, set up a blank action item
		ActionItem ai = aiM.getCurrentActionItem();
		if (ai == null) {
			clearAI();
		}
		else {
			// Define the text fields for the existing action item
			nameTextField.setText(ai.getActionItemName());
			descriptionTextArea.setText(ai.getDescription());
			//	descriptionTextArea.setCaretPosition(0);
			resolutionTextArea.setText(ai.getResolution());
			//resolutionTextArea.setCaretPosition(0);

			// Establish the status display 
			if (ai.getStatus() == "Closed")
				statusValueLabel.setText("Closed");
			else
				statusValueLabel.setText("Open");


			// Define the creation and due dates
			if (ai.getCreatedDate() != null)
				creationDateValueLabel.setText(dateFormat.format(ai.getCreatedDate()));
			else
				creationDateValueLabel.setText("");
			if (ai.getDueDate() != null)
				dueDateTextLabel.setText(dateFormat.format(ai.getDueDate()));
			else
				creationDateValueLabel.setText("");

			// Establish the assigned member display - Added for Della05
			String name = ai.getAssignedMember();
			if (name.length()==0)
				selectMemberValueLabel.setText("- no member assigned -");
			else
				selectMemberValueLabel.setText(ai.getAssignedMember());

			// Establish the assigned team display - Added for Della09
			String teamName = ai.getAssignedTeam();
			if (teamName.length()==0)
				selectTeamValueLabel.setText("- no team assigned -");
			else
				selectTeamValueLabel.setText(ai.getAssignedTeam());
		}
		// Set up the selection ComboBoxes and the select list - Modified for Della03
		sortDirectionComboBox.getSelectionModel().select(aiM.getSortDirection());
		sortFactor1ComboBox.getSelectionModel().select(aiM.getSortFactor1());
		sortFactor2ComboBox.getSelectionModel().select(aiM.getSortFactor2());
		inclusionFactorComboBox.getSelectionModel().select(aiM.getInclusionFactor());	// Added for Della10
		loadSelectListData(aiM.getActionItemNames(), aiM.getActionItemIndex(aiM.getCurrentActionItemName()));
		updatingGUI = false;
	}

	/**
	 * Process a select an inclusion factor event
	 * 
	 * @param e ActionEvent
	 * 
	 * Added for Della10
	 */
	public void listInclusionAction(){
		if (updatingGUI == false){
			aiM.setInclusionFactor(inclusionFactorComboBox.getSelectionModel().getSelectedIndex());
			loadSelectListData(aiM.getActionItemNames(), aiM.getActionItemIndex(aiM.getCurrentActionItemName()));
			if (aiSelectList.getSelectionModel().getSelectedIndex() == noItemSelected) {
				clearAI();
				loadScreen();
			}
			// A sorting factor has changed so the state has changed
			theController.setDirtyFlag(true);
		}
	}

	//console screen

	//member screen

	public static final int noItemSelectedmember = -1;	// Added for Della04

	//---------------------------------------------------------------------------------------------------------------------
	// Member Screen attributes

	// Added for Della04


	//---------------------------------------------------------------------------------------------------------------------
	// Member Screen GUI elements
	public Label memberLabel = new Label();

	// Added for Della04 (start)
	public Label membernameLabel = new Label();
	public TextField membernameTextField = new TextField();

	public Label guidanceR1Label = new Label();
	public Label guidanceR2Label = new Label();
	public Label guidanceR3Label = new Label();
	public Label guidanceR4Label = new Label();
	public Label guidanceR5Label = new Label();
	public Label guidanceR6Label = new Label();
	public Label guidanceR7Label = new Label();

	// Get current classloader 
	ClassLoader cl = this.getClass().getClassLoader(); 
	// Create icons 

	public Button addMemberButton = new Button();
	//			ActionListener addMemberButtonActionListner = new ActionListener() {
	//				public void actionPerformed(ActionEvent ae) { addMember(ae); }
	//			};
	public Button removeMemberButton = new Button();
	//			ActionListener removeMemberButtonActionListner = new ActionListener() {
	//				public void actionPerformed(ActionEvent ae) { removeMember(ae); }
	//			};

	public Label memberListLabel = new Label();
	public ListView memberSelectList ;


	//ScrollPane scrollableMemberListPane=new ScrollPane();

	//			JScrollPane scrollableMemberListPane = new JScrollPane(memberSelectList, 
	//					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//			ListSelectionListener listSelectionListner = new ListSelectionListener() {
	//				public void valueChanged(ListSelectionEvent listSelectionEvent) { selectMember(); }
	//			};
	// Added for Della04 (end)


	// Added for Della07 (start)
	public Label guidanceR8Label = new Label();
	public Label guidanceR9Label = new Label();
	public Label guidanceR10Label = new Label();
	public Label guidanceR11Label = new Label();
	public Label guidanceR12Label = new Label();
	public Label guidanceR13Label = new Label();
	public Label guidanceR14Label = new Label();
	public Label guidanceR15Label = new Label();
	public Label guidanceR16Label = new Label();
	public Label guidanceR17Label = new Label();

	public Label unaffiliatedTeamsListLabel = new Label();
	public Label unaffiliatedTeamsMemberNameLabel = new Label();
	public ListView unaffiliatedTeamsSelectList = new ListView();
	//			JScrollPane scrollableUnaffiliatedTeamsListPane = new JScrollPane(unaffiliatedTeamsSelectList, 
	//					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//			ListSelectionListener unaffiliatedTeamsListSelectionListner = new ListSelectionListener() {
	//				public void valueChanged(ListSelectionEvent listSelectionEvent) { selectUnaffiliatedTeam(); }
	//			};

	public Button addTeamAffiliationButton = new Button();
	//			ActionListener addTeamAffiliationButtonActionListner = new ActionListener() {
	//				public void actionPerformed(ActionEvent ae) { addTeamAffiliation(ae); }
	//			};
	public Button removeTeamAffiliationButton = new Button();
	//			ActionListener removeTeamAffilitationButtonActionListner = new ActionListener() {
	//				public void actionPerformed(ActionEvent ae) { removeTeamAffiliation(ae); }
	//			};

	public Label affiliatedTeamsListLabel = new Label();
	public Label affiliatedTeamsMemberNameLabel = new Label();
	public ListView affiliatedTeamsSelectList = new ListView();
	//			JScrollPane scrollableAffiliatedTeamsListPane = new JScrollPane(affiliatedTeamsSelectList, 
	//					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//			ListSelectionListener affiliatedTeamsListSelectionListner = new ListSelectionListener() {
	//				public void valueChanged(ListSelectionEvent listSelectionEvent) { selectAffiliatedTeam(); }
	//			};
	// Added for Della07 (end)
	//---------------------------------------------------------------------------------------------------------------------

	/**
	 * The MemberScreen class constructor.
	 * @return 
	 * 
	 */
	public TabPane membertab=new TabPane();
	public void MemberScreen() {
		// Use a modified singleton pattern to access the application's state; Added for Della04
		theController = Controller.getInstance();
		aiM = theController.getActionItemManager();

		// Set up all of the Graphical User Interface elements and place them on the screen
		guiInit();

		// Initialize the screen; Added for Della04
		loadmemberScreen();  
	}
	public void loadmemberScreen() {   
		ElementList memberList = aiM.getMemberList();
		loadScreenAndLists(memberList.getCurrentSelectedElementIndex());
		nameTextField.setText(memberList.getUnaddedName());
	}

	/**
	 * Initialize each graphic element, position it on the screen, and add it to the layout.
	 * 
	 */
	

	/**
	 * Process a "Add to List" button click request
	 * Add the new name, if valid, to the member list
	 * 
	 * @param e ActionEvent
	 * 
	 * Added for Della04
	 */

	ObservableList<String> listTaskItems;

	public void addMember(){

		ElementList memberList = aiM.getMemberList();




		try {
			String newName = membernameTextField.getText();
			System.out.println(newName+"...given this..");
			loadScreenAndLists(memberList.addElement(newName));
			nameTextField.setText("");		// If name was accepted, blank out the input field
			memberList.setUnaddedName("");	// and reset the persistent input field copy


			//System.out.println(listTaskItems.size());					



		}
		catch (Exception ex) {


			Stage stage = new Stage();
			Dialogs.showErrorDialog(stage,  ex.getMessage(), "I add memeber catch");
			return;
		}
		theController.setDirtyFlag(true);
	}

	/**
	 * Process a "Remove from List" button click request
	 * Remove the selected name from the member list
	 * 
	 * @param e ActionEvent
	 * 
	 * Added for Della04
	 */
	public void removeMember(){
		int selectedIndex = memberSelectList.getSelectionModel().getSelectedIndex();
		if (selectedIndex == noItemSelectedmember) {

			Stage stage = new Stage();
			Dialogs.showErrorDialog(stage,  "No member was selected!",  "Error");

			return;
		}
		else {
			String memberName = aiM.getMemberList().getName(selectedIndex);
			aiM.removeAssignedMember(memberName);
			aiM.getTeamList().removeAssociatedName(memberName);	// Added for Della07
			nameTextField.setText(memberName);
			loadScreenAndLists(noItemSelectedmember);
			theController.setDirtyFlag(true); 
		}
	}

	/**
	 * Process a member select list selection action
	 * 
	 * Added for Della04
	 */
	public void selectMember(){
		System.out.println("going here???");

		if (updatingGUI == false) {
			ElementList memberList = aiM.getMemberList();

			int selectedIndex = memberSelectList.getSelectionModel().getSelectedIndex();
			System.out.println("index  "+selectedIndex);
			memberList.setCurrentSelectedElementIndex(selectedIndex);
			establishUnaffiliatedTeamSelectList(memberList.getName(selectedIndex));	// Added for Della07
			establishAffiliatedTeamSelectList(memberList.getName(selectedIndex));	// Added for Della07
			theController.setDirtyFlag(true); 
		}
	}

	/**
	 * When a shut down occurs or transfer to some other screen occurs, this routine is called 
	 * to cause the UI state of the text input to be saved to the persistent store
	 * 
	 * Added for Della04
	 */
	public void saveScreenState() {
		ElementList memberList = aiM.getMemberList();
		memberList.setUnaddedName(nameTextField.getText());   	
	}

	/**
	 * When a navigation button click requires this screen to be activated, this routine
	 * is called to load the screen and re-establish the perishable fields
	 * 
	 * Added for Della04
	 */
	public void loeadMemberScreen() {   
		ElementList memberList = aiM.getMemberList();
		loadScreenAndLists(memberList.getCurrentSelectedElementIndex());
		nameTextField.setText(memberList.getUnaddedName());
	}

	/**
	 * This shared public routine does the heavy lifting of actually setting up the GUI for this screen
	 * 
	 * Added for Della04
	 */
	public void loadScreenAndLists(int selectedIndex) {
		System.out.println("came to fncn");
		updatingGUI = true;
		// Set the flag so that no select events are processed by these actions
		ElementList memberList = aiM.getMemberList();
		ArrayList<String> al=new ArrayList();

		for(int i=0;i<al.size();i++)
		{
			al.remove(i);
		}


		//((DefaultListModel)memberSelectList.getModel()).removeAllElements();
		//memberSelectList.getSelectionModel();
		int listSize = memberList.getListSize();

		System.out.println("before for  "+listSize );
		for (int i=0; i<listSize; i++)
		{
			//System.out.println(memberList.get(i).getName());
			al.add(memberList.getName(i));
			//listTaskItems.add(memberList.getName(i));	
			System.out.println(al.get(i));
		}
		listTaskItems = FXCollections.observableArrayList(al);

		memberSelectList.setItems(listTaskItems);
		System.out.println("added to list "+listSize);


		// Fetch the list of members to populate the select list
		////////////////////////((DefaultListModel)memberSelectList.getModel()).removeAllElements();
		// Reset the select list so it contains no elements

		// Fetch the size of the list of members and use this to iterate over all members

		//((DefaultListModel)memberSelectList.getModel()).addElement(memberList.getName(i));
		// Add each member to the select list
		if (selectedIndex == noItemSelectedmember) {	// See if a member is selected
			// If not, make sure the member list has no element selected
			System.out.println("in ifff");
			memberSelectList.getSelectionModel().clearSelection();
			// If no member is selected the unaffiliated list must be empty; Added for Della07
			establishUnaffiliatedTeamSelectList("");
			// Same thing for the affiliated list; Added for Della07
			establishAffiliatedTeamSelectList("");
		}
		else {	// A member was selected
			// Select that member
			memberSelectList.getSelectionModel().select(selectedIndex);
			// Use that member to establish the unaffiliated list of teams; Added for Della07
			establishUnaffiliatedTeamSelectList(memberList.getName(selectedIndex));
			// Same thing for the affiliated list; Added for Della07
			establishAffiliatedTeamSelectList(memberList.getName(selectedIndex));
		}
		memberList.setCurrentSelectedElementIndex(selectedIndex);			
		updatingGUI = false;

		System.out.println("came out of load");
	}

	/**
	 * When the "Add affiliation" button is clicked, this routine is called to process it
	 * 
	 * Added for Della07
	 */
	public void addTeamAffiliation(){
		if (unaffiliatedTeamsSelectList.getSelectionModel().getSelectedIndex()>noItemSelectedmember) {
			String selectedTeam = (String)unaffiliatedTeamsSelectList.getSelectionModel().getSelectedItem();
			String selectedMember = (String)memberSelectList.getSelectionModel().getSelectedItem();
			int numMemberTeams = aiM.getNumTeamAffiliations(selectedMember);
			int numTeamMembers = aiM.getNumMemberAssociations(selectedTeam);
			// Verify that there is is room for this addition!			
			if ((numMemberTeams < 10) && (numTeamMembers < 10)) {
				// Add a team affiliation to this member
				aiM.addTeamAffiliation(selectedMember,selectedTeam);
				// Add a member association to this team
				aiM.addMemberAssociation(selectedTeam,selectedMember);
				// Set the newly added member as selected in the list of members for this team
				aiM.setSelectedAssociatedMember(selectedTeam, selectedMember);
				// Have no team in the unassociated list selected
				aiM.setSelectedUnassociatedMember(selectedTeam, "");
				// Set the newly added team as selected in the list of teams for this member
				aiM.setSelectedAffiliatedTeam(selectedMember, selectedTeam);
				// Have no team in the unaffiliated list selected
				aiM.setSelectedUnaffiliatedTeam(selectedMember, "");
			}
			else {
				if (numMemberTeams>9)
				{
					Stage stage = new Stage();
					Dialogs.showErrorDialog(stage,  "A member may not be on more than 10 teams!", "Error");
				}

				else
				{
					Stage stage = new Stage();
					Dialogs.showErrorDialog(stage,  "A team may not have more than 10 members!", "Error");
				}

				return;
			}
			// Rebuild the affiliated team list for this member and display it
			establishAffiliatedTeamSelectList(selectedMember);
			// Rebuild the unaffiliated team list for this member and display it
			establishUnaffiliatedTeamSelectList(selectedMember);
			theController.setDirtyFlag(true); 
		}
		else
		{
			Stage stage = new Stage();
			Dialogs.showErrorDialog(stage,  "No team was selected!", "Error");
		}

	}

	/**
	 * When the "Remove affiliation" button is clicked, this routine is called to process it
	 * 
	 * Added for Della07
	 */
	public void removeTeamAffiliation(){
		if (affiliatedTeamsSelectList.getSelectionModel().getSelectedIndex()>noItemSelectedmember) {
			String selectedTeam = (String)affiliatedTeamsSelectList.getSelectionModel().getSelectedItem();
			String selectedMember = (String)memberSelectList.getSelectionModel().getSelectedItem();
			aiM.removeTeamAffiliation(selectedMember,selectedTeam);
			// Remove this team from this member's list of teams
			aiM.removeMemberAssociation(selectedTeam,selectedMember);
			// Remove this member from this team's list of members
			aiM.setSelectedUnassociatedMember(selectedTeam, selectedMember);
			// Have this member be selected in the list of unassociated members for this team
			aiM.setSelectedAssociatedMember(selectedTeam, "");
			// Have no member be selected in the list of associated members for this team
			aiM.setSelectedUnaffiliatedTeam(selectedMember, selectedTeam);
			// Have this team be selected in the list of unaffiliated teams for this member
			aiM.setSelectedAffiliatedTeam(selectedMember, "");
			// Have no team be selected in the list of affiliated teams for this member
			establishAffiliatedTeamSelectList(selectedMember);
			// Rebuild the list of affiliated teams for this member and display it
			establishUnaffiliatedTeamSelectList(selectedMember);
			// Rebuild the list of unaffiliated teams for this member and display it
			theController.setDirtyFlag(true); 
		}
		else
		{
			Stage stage = new Stage();
			Dialogs.showErrorDialog(stage,  "No team was selected!", "Error");
		}

	}

	/**
	 * When an affiliated team is clicked, this routine is called to process it
	 * 
	 * Added for Della07
	 */
	public void selectAffiliatedTeam(){
		if (updatingGUI != true) {
			String selectedTeam = (String)affiliatedTeamsSelectList.getSelectionModel().getSelectedItem();
			String selectedMember = (String)memberSelectList.getSelectionModel().getSelectedItem();
			aiM.setSelectedAffiliatedTeam(selectedMember, selectedTeam);
			// Select the affiliated team that was clicked
			aiM.setSelectedUnaffiliatedTeam(selectedMember, "");
			// Clear the unafffiliated team select list... both cannot have selected items
			establishUnaffiliatedTeamSelectList(selectedMember);
			// Cause the unaffiliated select list to be repainted incase a deselect has occurred
			theController.setDirtyFlag(true); 
		}
	}

	/**
	 * When an unaffiliated team is clicked, this routine is called to process it
	 * 
	 * Added for Della07
	 */
	public void selectUnaffiliatedTeam(){
		if (updatingGUI != true) {
			String selectedTeam = (String)unaffiliatedTeamsSelectList.getSelectionModel().getSelectedItem();
			String selectedMember = (String)memberSelectList.getSelectionModel().getSelectedItem();
			aiM.setSelectedUnaffiliatedTeam(selectedMember, selectedTeam);
			// Select the unaffiliated team that was clicked
			aiM.setSelectedAffiliatedTeam(selectedMember, "");
			// Clear the affiliated team select list... both cannot have a selected items
			establishAffiliatedTeamSelectList(selectedMember);
			// Cause the affiliated select list to be repainted incase a deselect has occurred
			theController.setDirtyFlag(true); 
		}
	}

	/**
	 * This routine establishes a select list of all of the unaffiliated teams for a specific member and finds the selected one
	 * 
	 * Added for Della07
	 */
	public void establishUnaffiliatedTeamSelectList(String memberName){
		updatingGUI = true;
		unaffiliatedTeamsMemberNameLabel.setText(memberName);
		/////((DefaultListModel)unaffiliatedTeamsSelectList.getModel()).removeAllElements();
		if (memberName.length()>0){	// If the member name is not empty, then use that member's unaffiliated team names
			String[] UnaffiliatedTeam = aiM.getUnaffiliatedTeams(memberName);
			int numUnaffiliatedTeams = UnaffiliatedTeam.length;
			String selectedUnaffiliatedTeam = aiM.getSelectedUnaffiliatedTeam(memberName);
			if (selectedUnaffiliatedTeam == null) selectedUnaffiliatedTeam = "";
			int selectedIndex = noItemSelectedmember;
			for (int ndx=0; ndx < numUnaffiliatedTeams; ndx++) {	// Add all the names to the select list
				////((DefaultListModel)unaffiliatedTeamsSelectList.getModel()).addElement(UnaffiliatedTeam[ndx]);
				if (selectedUnaffiliatedTeam.compareToIgnoreCase(UnaffiliatedTeam[ndx]) == 0) selectedIndex = ndx;
				// After adding each name, see if that name is the selected one.  If so, remember its index
			}
			unaffiliatedTeamsSelectList.getSelectionModel().select(selectedIndex);
			// After the select list is build, specify which one was the selected element
		}
		updatingGUI = false;
	}

	/**
	 * This routine establishes a select list of all of the affiliated teams for a specific member and finds the selected one
	 * 
	 * Added for Della07
	 */
	public void establishAffiliatedTeamSelectList(String memberName){
		updatingGUI = true;
		affiliatedTeamsMemberNameLabel.setText(memberName);
		///((DefaultListModel)affiliatedTeamsSelectList.getModel()).removeAllElements();
		if (memberName.length()>0){	// If the member name is not empty, then use that mamber's affiliated team names
			String[] AffiliatedTeam = aiM.getAffiliatedTeams(memberName);
			int numAffiliatedTeams = AffiliatedTeam.length;
			String selectedAffiliatedTeam = aiM.getSelectedAffiliatedTeam(memberName);
			if (selectedAffiliatedTeam == null) selectedAffiliatedTeam = "";
			int selectedIndex = noItemSelectedmember;
			for (int ndx=0; ndx < numAffiliatedTeams; ndx++) {	// Add all the names to the select list
				///((DefaultListModel)affiliatedTeamsSelectList.getModel()).addElement(AffiliatedTeam[ndx]);
				if (selectedAffiliatedTeam.compareToIgnoreCase(AffiliatedTeam[ndx]) == 0) selectedIndex = ndx;
				// After adding each name, see if that name is the selected one.  If so, remember its index
			}
			affiliatedTeamsSelectList.getSelectionModel().select(selectedIndex);
			// After the select list is build, specify which one was the selected element
		}
		updatingGUI = false;
	}

	//member screen
	
	//Team Screen
	
	Boolean updatingGUI = false;

	
	// Get current classloader 
	// Create icons 

	public Button addTeamButton = new Button();
//	ActionListener addTeamButtonActionListner = new ActionListener() {
//		public void actionPerformed(ActionEvent ae) { addTeam(ae); }
//	};
	public Button removeTeamButton = new Button();
//	ActionListener removeTeamButtonActionListner = new ActionListener() {
//		public void actionPerformed(ActionEvent ae) { removeTeam(ae); }
//	};

	public Label teamListLabel = new Label();
	public ListView teamSelectList = new ListView();
//	JScrollPane scrollableTeamListPane = new JScrollPane(teamSelectList, 
//			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//	ListSelectionListener listSelectionListner = new ListSelectionListener() {
//		public void valueChanged(ListSelectionEvent listSelectionEvent) { selectTeam(); }
//	};
	// Added for Della06 (end)

	// Added for Della08


	public Label unassociatedMembersListLabel = new Label();
	public Label unassociatedMembersTeamNameLabel = new Label();
	public ListView unassociatedMembersSelectList = new ListView();
//	JScrollPane scrollableUnassociatedMembersListPane = new JScrollPane(unassociatedMembersSelectList, 
//			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//	ListSelectionListener unassociatedMembersListSelectionListner = new ListSelectionListener() {
//		public void valueChanged(ListSelectionEvent listSelectionEvent) { selectUnassociatedMember(); }
//	};

	public Button addMemberAssociationButton = new Button();
//	ActionListener addMemberAssociationButtonActionListner = new ActionListener() {
//		public void actionPerformed(ActionEvent ae) { addMemberAssociation(ae); }
//	};
	public Button removeMemberAssociationButton = new Button();
//	ActionListener removeMemberAssociationButtonActionListner = new ActionListener() {
//		public void actionPerformed(ActionEvent ae) { removeMemberAssociation(ae); }
//	};

	public Label associatedMembersListLabel = new Label();
	public Label associatedMembersTeamNameLabel = new Label();
	ListView associatedMembersSelectList = new ListView();
//	JScrollPane scrollableAssociatedMembersListPane = new JScrollPane(associatedMembersSelectList, 
//			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//	ListSelectionListener associatedMembersListSelectionListner = new ListSelectionListener() {
//		public void valueChanged(ListSelectionEvent listSelectionEvent) { selectAssociatedMember(); }
//	};
	// Added for Della08 (end)
	//---------------------------------------------------------------------------------------------------------------------
	public void TeamScreen() {
		// Use a modified singleton pattern to access the application's state; Added for Della06
		theController = Controller.getInstance();
		aiM = theController.getActionItemManager();

		// Set up all of the Graphical User Interface elements and place them on the screen
		guiInit();

		// Initialize the screen; Added for Della06
		loadteamScreen();  
	}

	/**
	 * Initialize each graphic element, position it on the screen, and add it to the layout.
	 * 
	 */
	public void guiInit() {
		// Set all of the graphical elements in this screen by adding them to the layout
		
		// Added for Della08 (end)
	}

	/**
	 * Process a "Add to List" button click request
	 * Add the new name, if valid, to the team list
	 * 
	 * @param e ActionEvent
	 * 
	 * Added for Della06
	 */
	public void addTeam(){
		ElementList teamList = aiM.getTeamList();

		try {
			String newName = nameTextField.getText();
			loadScreenAndLists(teamList.addElement(newName));
			nameTextField.setText("");		// If name was accepted, blank our the input field
			teamList.setUnaddedName("");	// and reset the persistent input field copy
		}
		catch (Exception ex) {
			
			Stage stage = new Stage();
			Dialogs.showErrorDialog(stage,  ex.getMessage(),  "Error");
			return;
		}
		theController.setDirtyFlag(true);
	}

	/**
	 * Process a "Remove from List" button click request
	 * Remove the selected name from the member list
	 * 
	 * @param e ActionEvent
	 * 
	 * Added for Della06
	 */
	public void removeTeam(){
		int selectedIndex = teamSelectList.getSelectionModel().getSelectedIndex();
		if (selectedIndex == noItemSelected) {
			
			Stage stage = new Stage();
			Dialogs.showErrorDialog(stage, "No team was selected!",  "Error");
			
			return;
		}
		else {
			String teamName = aiM.getTeamList().getName(selectedIndex);
			aiM.removeAssignedTeam(teamName);
			aiM.getMemberList().removeAssociatedName(teamName);	// Added for Della08
			nameTextField.setText(teamName);
			loadScreenAndLists(noItemSelected);
			theController.setDirtyFlag(true); 
		}
	}

	/**
	 * Process a team select list selection action
	 * 
	 * Added for Della06
	 */
	public void selectTeam(){
		if (updatingGUI == false) {
			ElementList teamList = aiM.getTeamList();
			int selectedIndex = teamSelectList.getSelectionModel().getSelectedIndex();
			teamList.setCurrentSelectedElementIndex(selectedIndex);
			establishUnassociatedMemberSelectList(teamList.getName(selectedIndex));	// Added for Della08
			establishAssociatedMemberSelectList(teamList.getName(selectedIndex));	// Added for Della08
			theController.setDirtyFlag(true); 
		}
	}

	/**
	 * When a shut down occurs, this routine is called to cause the UI state of the text input box
	 * to be saved to the persistent store
	 * 
	 * Added for Della06
	 */
	public void savememberScreenState() {
		ElementList teamList = aiM.getTeamList();
		teamList.setUnaddedName(nameTextField.getText());   	
	}

	/**
	 * When a navigation button click requires this screen to be activated, this routine
	 * is called to load the screen and re-establish the perishable fields
	 * 
	 * Added for Della06
	 */
	public void loadteamScreen() {   
		ElementList teamList = aiM.getTeamList();
		loadScreenAndLists(teamList.getCurrentSelectedElementIndex());
		nameTextField.setText(teamList.getUnaddedName());
	}

	/**
	 * Shared routine to load the screen and the various select lists
	 * 
	 * Added for Della06
	 */
	public void loadmemberScreenAndLists(int selectedIndex) {
		updatingGUI = true;
		// Set the flag so that no select events are processed by these actions
		ElementList teamList = aiM.getTeamList();
		// Fetch the list of teams to populate the select list
///((DefaultListModel)teamSelectList.getModel()).removeAllElements();
		// Reset the select list so it contains no elements
		int listSize = teamList.getListSize();
		// Fetch the size of the list of teams and use this to iterate over all members
		for (int i=0; i<listSize; i++)
///((DefaultListModel)teamSelectList.getModel()).addElement(teamList.getName(i));
		// Add each team to the select list
		if (selectedIndex == noItemSelected) {	// See if a team is selected
			// If not, make sure the team list has no element selected
			teamSelectList.getSelectionModel().clearSelection();
			// If no team is selected the unassociated list must be empty; Added for Della08
			establishUnassociatedMemberSelectList("");
			// Same thing for the associated list; Added for Della08
			establishAssociatedMemberSelectList("");
		}
		else {	// A team was selected
			teamSelectList.getSelectionModel().select(selectedIndex);			// Select that team
			// Use that team to establish the unassociated list of members; Added for Della08
			establishUnassociatedMemberSelectList(teamList.getName(selectedIndex));
			// Same thing for the associated list; Added for Della08
			establishAssociatedMemberSelectList(teamList.getName(selectedIndex));
		}
		teamList.setCurrentSelectedElementIndex(selectedIndex);			
		updatingGUI = false;
	}

	/**
	 * When the "Add association" button is clicked, this routine is called to process it
	 * 
	 * Added for Della08
	 */
	public void addMemberAssociation(){
		if (unassociatedMembersSelectList.getSelectionModel().getSelectedIndex()>noItemSelected) {
			String selectedMember = (String)unassociatedMembersSelectList.getSelectionModel().getSelectedItem();
			String selectedTeam = (String)teamSelectList.getSelectionModel().getSelectedItem();
			int numMemberTeams = aiM.getNumTeamAffiliations(selectedMember);
			int numTeamMembers = aiM.getNumMemberAssociations(selectedTeam);
			// Verify that there is is room for this addition!			
			if ((numMemberTeams < 10) && (numTeamMembers < 10)) {
				// Add a team affiliation to this member
				aiM.addTeamAffiliation(selectedMember,selectedTeam);
				// Add a member association to this team
				aiM.addMemberAssociation(selectedTeam,selectedMember);
				// Set the newly added member as selected in the list of members for this team
				aiM.setSelectedAssociatedMember(selectedTeam, selectedMember);
				// Have no team in the unassociated list selected
				aiM.setSelectedUnassociatedMember(selectedTeam, "");
				// Set the newly added team as selected in the list of teams for this member
				aiM.setSelectedAffiliatedTeam(selectedMember, selectedTeam);
				// Have no team in the unaffiliated list selected
				aiM.setSelectedUnaffiliatedTeam(selectedMember, "");
			}
			else {
				if (numMemberTeams>9)
					
				{

					Stage stage = new Stage();
					Dialogs.showErrorDialog(stage,"A member may not be on more than 10 teams!",  "Error");
					
				}
				else
				{
					Stage stage = new Stage();
					Dialogs.showErrorDialog(stage,"A team may not have more than 10 members!",  "Error");
				}
									
				return;
			}
			// Rebuild the affiliated team list for this member and display it
			establishAssociatedMemberSelectList(selectedTeam);
			// Rebuild the unaffiliated team list for this member and display it
			establishUnassociatedMemberSelectList(selectedTeam);
			theController.setDirtyFlag(true); 
		}
		else
		{
			Stage stage = new Stage();
			Dialogs.showErrorDialog(stage,"No member was selected!",  "Error");
		}
			
	}

	/**
	 * When the "Remove association" button is clicked, this routine is called to process it
	 * 
	 * Added for Della08
	 */
	public void removeMemberAssociation(){
		if (associatedMembersSelectList.getSelectionModel().getSelectedIndex()>noItemSelected) {
			String selectedMember = (String)associatedMembersSelectList.getSelectionModel().getSelectedItem();
			String selectedTeam = (String)teamSelectList.getSelectionModel().getSelectedItem();
			aiM.removeMemberAssociation(selectedTeam,selectedMember);
			// Remove this member from this team's list of members
			aiM.removeTeamAffiliation(selectedMember,selectedTeam);
			// Remove this team from this member's list of teams
			aiM.setSelectedUnassociatedMember(selectedTeam, selectedMember);
			// Have this member be selected in the list of unassociated members for this team
			aiM.setSelectedAssociatedMember(selectedTeam, "");
			// Have no member be selected in the list of associated members for this team
			aiM.setSelectedUnaffiliatedTeam(selectedMember, selectedTeam);
			// Have this team be selected in the list of unaffiliated teams for this member
			aiM.setSelectedAffiliatedTeam(selectedMember, "");
			// Have no team be selected in the list of affiliated teams for this member
			establishAssociatedMemberSelectList(selectedTeam);
			// Rebuild the list of associated members for this team and display it
			establishUnassociatedMemberSelectList(selectedTeam);
			// Rebuild the list of unassociated members for this team and display it
			theController.setDirtyFlag(true); 
		}
		else
		{
			Stage stage = new Stage();
			Dialogs.showErrorDialog(stage,"No member was selected!",  "Error");
		}
			
	}

	/**
	 * When an associated member is clicked, this routine is called to process it
	 * 
	 * Added for Della08
	 */
	public void selectAssociatedMember(){
		if (updatingGUI != true) {
			String selectedMember = (String)associatedMembersSelectList.getSelectionModel().getSelectedItem();
			String selectedTeam = (String)teamSelectList.getSelectionModel().getSelectedItem();
			aiM.setSelectedAssociatedMember(selectedTeam, selectedMember);
			// Select the associated member that was clicked
			aiM.setSelectedUnassociatedMember(selectedTeam, "");
			// Clear the unassociated member select list... both cannot have selected items
			establishUnassociatedMemberSelectList(selectedTeam);
			// Cause the unassociated select list to be repainted incase a deselect has occurred
			theController.setDirtyFlag(true); 
		}
	}

	/**
	 * When an unassociated member is clicked, this routine is called to process it
	 * 
	 * Added for Della08
	 */
	public void selectUnassociatedMember(){
		if (updatingGUI != true) {
			String selectedMember = (String)unassociatedMembersSelectList.getSelectionModel().getSelectedItem();
			String selectedTeam = (String)teamSelectList.getSelectionModel().getSelectedItem();
			aiM.setSelectedUnassociatedMember(selectedTeam, selectedMember);
			// Select the unasscoaited member that was clicked
			aiM.setSelectedAssociatedMember(selectedTeam, "");
			// Clear the associated mdember select list... both cannot have a selected items
			establishAssociatedMemberSelectList(selectedTeam);
			// Cause the associated select list to be repainted incase a deselect has occurred
			theController.setDirtyFlag(true); 
		}
	}

	/**
	 * This routine establishes a select list of all of the unassocuated members for a specific team and finds the selected one
	 * 
	 * Added for Della08
	 */
	public void establishUnassociatedMemberSelectList(String teamName){
		updatingGUI = true;
		unassociatedMembersTeamNameLabel.setText(teamName);
///((DefaultListModel)unassociatedMembersSelectList.getModel()).removeAllElements();
		if (teamName.length()>0){	// If the team name is not empty, then use that team's unassociated member names
			String[] UnassociatedMember = aiM.getUnassociatedMembers(teamName);
			int numUnassociatedMembers = UnassociatedMember.length;
			String selectedUnassociatedMember = aiM.getSelectedUnassociatedMember(teamName);
			if (selectedUnassociatedMember == null) selectedUnassociatedMember = "";
			int selectedIndex = noItemSelected;
			for (int ndx=0; ndx < numUnassociatedMembers; ndx++) {	// Add all the names to the select list
///((DefaultListModel)unassociatedMembersSelectList.getModel()).addElement(UnassociatedMember[ndx]);
				if (selectedUnassociatedMember.compareToIgnoreCase(UnassociatedMember[ndx]) == 0) selectedIndex = ndx;
				// After adding each name, see if that name is the selected one.  If so, remember its index
			}
			unassociatedMembersSelectList.getSelectionModel().select(selectedIndex);
			// After the select list is build, specify which one was the selected element
		}
		updatingGUI = false;
	}

	/**
	 * This routine establishes a select list of all of the associated members for a specific team and finds the selected one
	 * 
	 * Added for Della08
	 */
	public void establishAssociatedMemberSelectList(String teamName){
		updatingGUI = true;
		associatedMembersTeamNameLabel.setText(teamName);
///((DefaultListModel)associatedMembersSelectList.getModel()).removeAllElements();
		if (teamName.length()>0){	// If the team name is not empty, then use that team's associated member names
			String[] AssociatedMember = aiM.getAssociatedMembers(teamName);
			int numAssociatedMembers = AssociatedMember.length;
			String selectedAssociatedMember = aiM.getSelectedAssociatedMember(teamName);
			if (selectedAssociatedMember == null) selectedAssociatedMember = "";
			int selectedIndex = noItemSelected;
			for (int ndx=0; ndx < numAssociatedMembers; ndx++) {	// Add all the names to the select list
///((DefaultListModel)associatedMembersSelectList.getModel()).addElement(AssociatedMember[ndx]);
				if (selectedAssociatedMember.compareToIgnoreCase(AssociatedMember[ndx]) == 0) selectedIndex = ndx;
				// After adding each name, see if that name is the selected one.  If so, remember its index
			}
			associatedMembersSelectList.getSelectionModel().select(selectedIndex);
			// After the select list is build, specify which one was the selected element
		}
		updatingGUI = false;
	}
	
	//team screen
	
	


}
