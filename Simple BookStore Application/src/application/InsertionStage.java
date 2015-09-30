package application;

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * <b>InsertionStage.java</b><br>
 * 
 * @author Mohammed Nasir
 * @version 04/02/2015
 */
public class InsertionStage extends Stage
{
	private InsertionBusinessLogicLayer bll;                               // Insertion Business Logic Layer
	private Scene 						scene;                             // Scene of the insertion stage
	private BorderPane 					paneMain;                          // Border pane of the insertion stage
	private GridPane 					paneCenter;                        // Gride pane of the  insertion stage
	private HBox 						paneBottom;                        // HBox of the insertion stage
	private Label 						lblISBN;                           // ISBN label of the insertion stage
	private Label 						lblAuthor;                         // Author label
	private Label 						lblTitle;                          // Title label
	private Label 						lblEdition;                        // Edition label
	private Label 						lblPrice;                          // price label
	private TextField 					txtISBN;                          // Text field for ISBN
	private TextField 					txtAuthor;                        // Text field for author
	private TextField 					txtTitle;                         // Text field for title
	private TextField 					txtEdition;                       // Text field for edition
	private TextField 					txtPrice;                         // Text field for price
	private Button 						btnInsert;                        // Insert button
	private Button 						btnBack;                          // Back Button
	
	
	/**
	 * <b>Inserion Stage Constructor</b><br>
	 * By calling this function a Insertion Business logic Layer
	 * object will be created and initialized 
	 * @param bll  Insertion Business Logic Layer
	 */
	public InsertionStage(InsertionBusinessLogicLayer bll) 
	{
		super();
		this.bll = bll;
		initComponents();
		regEventHandlers();
	}
	
	
	private void regEventHandlers() 
	{
		btnBack.setOnAction(e -> bll.closeStage());           // Event Handler set on action for closing stage
		btnInsert.setOnAction(e ->
		{	
			bll.addBook(initBookObject());                   // Adding book event handler
			resetScene();
		});
	}

	private void initComponents()
	{
		paneMain = new BorderPane();                                         // Border pane of the add book stage
		paneMain.setPadding(new Insets(10));
		
		paneCenter = new GridPane();                                         // Grid pane of the add book stage
		paneCenter.setAlignment(Pos.CENTER);
		paneCenter.setVgap(5);
		
		paneBottom = new HBox();
		paneBottom.setSpacing(5);
		paneBottom.setAlignment(Pos.CENTER_RIGHT);
		
		lblISBN 	= new Label("ISBN: ");                                      
		lblAuthor 	= new Label("Author: ");
		lblTitle 	= new Label("Title: ");
		lblEdition 	= new Label("Edition: ");
		lblPrice 	= new Label("Price: ");
		
		txtISBN 	= new TextField();
		txtAuthor	= new TextField();
		txtTitle 	= new TextField();
		txtEdition 	= new TextField();
		txtPrice 	= new TextField();
		
		btnInsert = new Button("Add Book");
		btnInsert.setMinSize(100, 25);
		btnBack = new Button("Back");
		btnBack.setMinSize(100, 25);
		
		paneCenter.add(lblISBN, 	0, 0);                                              // Adding of labels and textfields
		paneCenter.add(lblAuthor, 	0, 1);
		paneCenter.add(lblTitle, 	0, 2);
		paneCenter.add(lblEdition, 	0, 3);
		paneCenter.add(lblPrice, 	0, 4);
		paneCenter.add(txtISBN, 	1, 0);
		paneCenter.add(txtAuthor, 	1, 1);
		paneCenter.add(txtTitle, 	1, 2);
		paneCenter.add(txtEdition, 	1, 3);
		paneCenter.add(txtPrice, 	1, 4);
		
		paneBottom.getChildren().add(btnInsert);
		paneBottom.getChildren().add(btnBack);
		
		paneMain.setCenter(paneCenter);
		paneMain.setBottom(paneBottom);
		
		scene = new Scene(paneMain, 400, 250);
		this.setScene(scene);                                                     // Setting the title of the insert book
		this.setTitle("Insert Book");
	}
	
	private Book initBookObject()
	{ 
		String ISBN 	= txtISBN.getText();                                     // Getter functions
		String title 	= txtTitle.getText();
		String author 	= txtAuthor.getText();
		int edition 	= Integer.valueOf(txtEdition.getText());	
		double price 	= Double.valueOf(txtPrice.getText());	
		return new Book(ISBN, title, author, edition, price);
	}
	
	private void resetScene()
	{
		txtISBN.setText(null);                           // Setting the values of texts to null
		txtTitle.setText(null);
		txtAuthor.setText(null);
		txtEdition.setText(null);
		txtPrice.setText(null);
	}
}
