package application;

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * <b>MainStage.java</b><br>
 * 
 * @author Fouad Banisadeghian
 * @version 03/02/2015
 */
public class MainStage extends Stage
{
	private MainBusinessLogicLayer 	bll;                            // Main Business Logic Layer
	private Scene 					scene;                          // Scene of the main application
	private BorderPane 				paneMain;                       // Border pane of the main application
	private HBox 					paneButton1;                   // HBOX of the main application
	private HBox 					paneButton2;                   
	private Button 					btnAdd;                        //Add button  of the main application
	private Button 					btnRemove;                    // Remove button of the main application
	private Button 					btnList;                      // Book List button of the main application
	private Button 					btnSearch;                    // Search button of the main application
	private Button 					btnExit;                      // Exit button of the main application
	
	
	
	/**
	 * <b>Main Stage Constructor</b><br>
	 * By calling this function a Book Store
	 * object will be created and initialized 
	 * @param bll main business Logic Layer
	 */
	MainStage(MainBusinessLogicLayer bll)
	{
		super();
		this.bll = bll;
		initComponents();
		regEventHandlers();
	}
	
	
	
	private void initComponents()
	{
		paneMain = new BorderPane();
		paneMain.setPadding(new Insets(10));                           // Padding is set
		
		paneButton1 = new HBox();                                                 
		paneButton1.setAlignment(Pos.CENTER);                          //Position of the Hbox is set to center
		paneButton1.setSpacing(5);
		
		paneButton2 = new HBox();                                       
		paneButton2.setAlignment(Pos.CENTER_RIGHT);                   //Position of the Hbox is set to center right
		
		btnAdd = new Button("Add Book");                              // Add Book Button
		btnAdd.setMinSize(100, 20);
		
		btnRemove = new Button("Remove Book");                        // Remove Book Button
		btnRemove.setMinSize(100, 20);
		
		btnList = new Button("Books List");                           // Books List Button
		btnList.setMinSize(100, 20);
		
		btnSearch = new Button("Search Book");                       // Search Book Button
		btnSearch.setMinSize(100, 20);
		
		btnExit = new Button("Exit");                                // Exit Button
		btnExit.setMinSize(100, 20);
		
		paneButton1.getChildren().add(btnAdd);
		paneButton1.getChildren().add(btnRemove);                      // Adding all the buttons to the pane
		paneButton1.getChildren().add(btnList);
		paneButton1.getChildren().add(btnSearch);
		paneButton2.getChildren().add(btnExit);
		
		paneMain.setCenter(paneButton1);
		paneMain.setBottom(paneButton2);
		
		scene = new Scene(paneMain, 600, 200);
		this.setScene(scene);                                         // setting the scene and title
		this.setTitle("Simple Bookstore");
	}
	
	
	// Event Handlers for all the stages of the buttons objects which were created and initalized
	private void regEventHandlers()                                 
	{
		btnAdd.setOnAction(e -> bll.showInsertionStage());                       // Insertion stage 
		btnRemove.setOnAction(e -> bll.showDeletionStage());                     // Deletion Stage
		btnList.setOnAction(e -> bll.showBooksListStage());                      // Books list stage
		btnSearch.setOnAction(e -> bll.showSearchStage());                       // Search stage
		btnExit.setOnAction(e -> bll.exit());
		this.setOnCloseRequest(e -> bll.exit());
	}
}
