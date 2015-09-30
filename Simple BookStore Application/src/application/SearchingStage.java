package application;

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * <b>DeletionStage.java</b><br>
 * 
 * @author Mohammed Nasir
 * @version 03/02/2015
 */
public class SearchingStage extends Stage
{
	private SearchingBusinessLogicLayer sbll;                                 // Searching Business Logic Layer of the stage
	private Scene 						scene;                                // Scene of the searching stage
	private BorderPane 					paneMain;                             // Border pane of the searching stage
	private GridPane 					paneCenter;                           // Grid pane of the searching stage
	private HBox 						paneBottom;                           // Hbox of the searching stage
	private Label 						lblISBN;                              // Label ISBN of the searching stage
	private TextField 					txtISBN;                              // Text Field of the searching stage
	private Button 						btnSearch;                            // Search button
	private Button 						btnBack;                              // Back button
	
	
	/**
	 * <b>Searching Stage Constructor</b><br>
	 * By calling this function a Searching Business Logic Layer
	 * object will be created and initialized 
	 * @param sbll  searching business logic layer
	 */
	public SearchingStage(SearchingBusinessLogicLayer sbll) 
	{
		super();
		this.sbll = sbll;
		initComponents();
		regEventHandlers();
	}
	
	// Event Handlers
	private void regEventHandlers() 
	{
		btnBack.setOnAction(e -> sbll.closeStage());
		btnSearch.setOnAction(e ->
		{	
			sbll.search(initBookObject());                       // Search Button event handler
			resetScene();
		});
	}

	private void initComponents()
	{
		paneMain = new BorderPane();
		paneMain.setPadding(new Insets(10));
		
		paneCenter = new GridPane();
		paneCenter.setAlignment(Pos.CENTER);
		paneCenter.setVgap(5);
		
		paneBottom = new HBox();
		paneBottom.setSpacing(5);
		paneBottom.setAlignment(Pos.CENTER_RIGHT);
		
		lblISBN 	= new Label("ISBN: ");                                     // Label and text field of the searching stage
		txtISBN 	= new TextField();
		
		btnSearch = new Button("Search Book");
		btnSearch.setMinSize(100, 25);
		btnBack = new Button("Back");
		btnBack.setMinSize(100, 25);
		
		paneCenter.add(lblISBN, 	0, 0);
		paneCenter.add(txtISBN, 	1, 0);
		
		paneBottom.getChildren().add(btnSearch);                            // Adding the search and back button
		paneBottom.getChildren().add(btnBack);
		
		paneMain.setCenter(paneCenter);
		paneMain.setBottom(paneBottom);
		
		scene = new Scene(paneMain, 400, 250); 
		this.setScene(scene);                                                // Setting the scene and the title
		this.setTitle("Search Book");
	}
	
	private String initBookObject()
	{
		String ISBN 	= txtISBN.getText();	           // Getter function
		return ISBN;
	}
	
	private void resetScene()
	{
		txtISBN.setText(null);                              // Setter function
	}
}

