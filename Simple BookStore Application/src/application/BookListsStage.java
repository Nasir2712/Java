package application;

import java.awt.Scrollbar;

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
public class BookListsStage extends Stage
{
	private BookListBusinessLogicLayer  bkll;                                   // Book List Business Logic Layer
	private Scene 						scene;                                  // Scene of the book list stage
	private BorderPane 					paneMain;                               // Border pane of the book list stage
	private GridPane 					paneCenter;                             // Grid pane of the book list stage
	private HBox 						paneBottom;                             // HBox pane of the book list stage
	private TextArea 					txtArea;                                // Text area of the book list stage
	private Button 						btnBack;                                // Back button
//	private ScrollBar                   scbar;
	
	
	/**
	 * <b>Book Lists Stage Constructor</b><br>
	 * By calling this function a BookList Business Logic Layer
	 * object will be created and initialized 
	 * @param bkll  book list business logic layer
	 */
	public BookListsStage(BookListBusinessLogicLayer bkll) 
	{
		super();
		this.bkll = bkll;
		initComponents();
		regEventHandlers();
	}
	
	// Event Handlers
	private void regEventHandlers() 
	{
		btnBack.setOnAction(e -> bkll.closeStage());
		initBookObject();
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
		
		txtArea 	= new TextArea();
		txtArea.setEditable(false);                                     // Read only
 
		btnBack = new Button("Back");                                  // Back Button
		btnBack.setMinSize(100, 25);
		
	/*	scbar = new ScrollBar();
	//	scbar.setLayoutX(scene.getWidth()-scbar.getWidth());
        scbar.setMin(0);
        scbar.setOrientation(Orientation.VERTICAL);
        scbar.setPrefHeight(180);
        scbar.setMax(360);*/
		
		paneCenter.add(txtArea, 	1, 0);                             // Text area
		
		paneBottom.getChildren().add(btnBack);
		
		paneMain.setCenter(paneCenter);
		paneMain.setBottom(paneBottom);
		
		scene = new Scene(paneMain, 400, 250);
		this.setScene(scene);
		this.setTitle("Books List");
	}

	
	private String initBookObject()
	{
		String ISBN 	= bkll.displayBookList() ;	            // Calling the display function from the book list business logic layer
		txtArea.setText(ISBN);
		return ISBN;
	}
}
