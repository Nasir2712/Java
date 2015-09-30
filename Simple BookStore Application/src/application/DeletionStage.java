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
public class DeletionStage extends Stage
{
	private DeletionBusinessLogicLayer  dll;                                                    // Deletion business logic layer
	private Scene 						scene;                                                  // Scene of the deletion stage
	private BorderPane 					paneMain;                                               // Border pane of the deletion stage
	private GridPane 					paneCenter;                                             // Grid pane of the deletion stage
	private HBox 						paneBottom;                                             // HBOX of the deletion stage
	private Label 						lblISBN;                                                // LABEL of the deletion stage
	private TextField 					txtISBN;                                                // Text Field of the deletion stage
	private Button 						btnRemove;                                              // Remove Button of the deletion stage
	private Button 						btnBack;                                                // Back button of the deletion stage
	
	
	/**
	 * <b>Deletion Stage Constructor</b><br>
	 * By calling this function a Deletion Business Logic Layer
	 * object will be created and initialized 
	 * @param dll  Deletion business logic layer
	 */
	public DeletionStage(DeletionBusinessLogicLayer dll) 
	{
		super();
		this.dll = dll;
		initComponents();
		regEventHandlers();
	}
	
	// Event handlers
	private void regEventHandlers() 
	{
		btnBack.setOnAction(e -> dll.closeStage());
		btnRemove.setOnAction(e ->                                          
		{	
			dll.remove(initBookObject());
			resetScene();
		});                                                            // Remove button event handler 
	}

	private void initComponents()
	{
		paneMain = new BorderPane();
		paneMain.setPadding(new Insets(10));                         // padding
		
		paneCenter = new GridPane();
		paneCenter.setAlignment(Pos.CENTER);
		paneCenter.setVgap(5);
		
		paneBottom = new HBox();
		paneBottom.setSpacing(5);
		paneBottom.setAlignment(Pos.CENTER_RIGHT);
		
		lblISBN 	= new Label("ISBN: ");
		txtISBN 	= new TextField();
		
		
		btnRemove = new Button("Remove Book");
		btnRemove.setMinSize(100, 25);
		btnBack = new Button("Back");
		btnBack.setMinSize(100, 25);
		
		paneCenter.add(lblISBN, 	0, 0);
		paneCenter.add(txtISBN, 	1, 0);                                               // Adding of labels and text ISBN's
		
		paneBottom.getChildren().add(btnRemove);
		paneBottom.getChildren().add(btnBack);
		
		paneMain.setCenter(paneCenter);
		paneMain.setBottom(paneBottom);
		
		scene = new Scene(paneMain, 400, 250);
		this.setScene(scene);                                                            // Setting of scenes and titles
		this.setTitle("Remove Book");
	}
	
	private String initBookObject()
	{
		String ISBN 	= txtISBN.getText();	                                       // Getting function
		return ISBN;
	}
	
	private void resetScene()
	{
		txtISBN.setText(null);                                                       // Setting function
	}
}
