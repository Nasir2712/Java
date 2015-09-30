package application;

import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;

/**
 * <b>MessageBox.java</b><br>
 * 
 * @author Mohammed Nasir
 * @version 04/02/2015
 */
public class MessageBox 
{
	private Stage stage;                // Stage of the application
	private Scene scene;                // Scene of the application
 	private BorderPane pane;           // Border Pane of the application
	private Pane paneCenter;           // Pane of the application
	private HBox paneBottom;           // HBOX of the application
	private Button btnOK;              // OK Button of the application
	private Text textMessage;          // Text Message for the application
	private String message;            // Message from the application
	private Line separator;            // A line that seperated some parts of the application
	private DialogResult result;       // Dialog result of the application
	
	
	
	/**
	 * <b>Message Box Constructor</b><br>
	 * By calling this function a Book Store
	 * object will be created and initialized 
	 * @param message  message from the application
	 */
	MessageBox(String message)
	{
		this.message = message;
		initComponents();
		regEventHandlers();
	}
	
	/**
	 * <b>Event Handlers function</b><br>
	 * By calling this function a object event will
	 * will be created and initialized and handled
	 */
	
	private void regEventHandlers() 
	{
		btnOK.setOnAction(e -> setResult(e));	
	}

	private void initComponents()
	{
		stage = new Stage();                                       
		
		pane = new BorderPane();
		pane.setPadding(new Insets(20));                                   // Padding space is set
		
		paneBottom = new HBox();
		paneBottom.setAlignment(Pos.CENTER_RIGHT);                         // Position of the Hbox is set to center right
		paneBottom.setPadding(new Insets(0, 10, 0, 0));
		
		paneCenter = new Pane();
		
		btnOK = new Button("OK");
		btnOK.setMinWidth(100);                                           // Width property of the button OK is set to 100
		
		textMessage = new Text(10, 10, message);
		textMessage.setWrappingWidth(300);                                                       // Wrapping width of the message is set to 300
		textMessage.wrappingWidthProperty().bind(paneCenter.widthProperty().subtract(25));       // Wrapping width of the message is binded to pane center
		textMessage.setFill(Color.BLACK);                                                        // Color of the message is set to Black
		
		separator = new Line(10, 10, 10, 10);
		separator.setFill(Color.DARKGRAY);                                                        // Color of the message is set to Dark gray
		separator.startYProperty().bind(paneCenter.heightProperty().subtract(15));                // Start Y co-ordinate  of the line is binded to pane center
		separator.endYProperty().bind(paneCenter.heightProperty().subtract(15));                  // End Y co-ordinate  of the line is binded to pane center 
		separator.endXProperty().bind(paneCenter.widthProperty().subtract(10));                  // End X co-ordinate  of the line is binded to pane center
		
		paneBottom.getChildren().add(btnOK);
		
		paneCenter.getChildren().add(separator);
		paneCenter.getChildren().add(textMessage);                                                // Adding the buttons to the pane
		     
		pane.setCenter(paneCenter);
		pane.setBottom(paneBottom);
		
		scene = new Scene(pane, 500, 150);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);                                                                       // Setting scenes and titles
		stage.setTitle("Message");
	}
	
	// Show function
	private void show()
	{
		stage.showAndWait();
	}
	
	// OK Button action
	private void setResult(ActionEvent e)
	{
		if (e.getSource() == btnOK)
		{
			result = DialogResult.OK;
		}
		stage.close();
	}
	
	/**
	 * <b>Dialog Result function</b><br>
	 * The dialog result is called here
	 * @param message    the message of the application
	 * @return mBox.result
	 */
	public static DialogResult show(String message)
	{
		MessageBox mBox = new MessageBox(message);
		mBox.show();
		return mBox.result;
	}
}
