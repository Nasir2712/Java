package application;

import java.io.*;
import java.util.*;
import javafx.stage.*;

/**
 * <b>MainBusinessLogicLayer.java</b><br>
 * 
 * @author Mohammed Nasir
 * @version 04/02/2015
 */
public class MainBusinessLogicLayer 
{
	private Stage mainStage;                                  // Stage of the application
	private BookStore bookStore;                              // The book store
	private DataAccessLayer<Book> bookDAL;                    // Data Access Layer of the book
	
	
	/**
	 * <b>Main Business Logic Layer Constructor</b><br>
	 * By calling this function the main business Logic Layer
	 * object will be created and initialized 
	 */
	public MainBusinessLogicLayer() 
	{
		bookDAL =  new DataAccessLayer<Book>("output.txt");                      // The name of the data access Layer file in text format
		bookStore = null;
		this.mainStage = new MainStage(this);
	}
	
	
	// Execute function of the whole application
	public void execute() 
	{ 
		mainStage.show();                                                     // Main stage of the application
		readData();                                                           // Read data function is called from the data Access Layer
	}
	
	public void exit()
	{
		writeData();                                                        // Write data function of the application from the data access Layer
		mainStage.close();                                                  // Closing function of the main stage application is called
	}
	
	
	// show insertion Stage is the object of the Insertion Business Logic Layer which is created and initialized
	public void showInsertionStage()
	{
		InsertionBusinessLogicLayer insertionBLL = new InsertionBusinessLogicLayer(bookStore);
		insertionBLL.showStage();
	}
 
	// Show Deletion stage is the object of deletion business logic layer which is created and initialized
	public void showDeletionStage() 
	{
		DeletionBusinessLogicLayer deletionBll = new DeletionBusinessLogicLayer(bookStore);
		deletionBll.showStage();
	}

	// Show books list stage is the object of the Book list business logic layer which is created and initialized
	public void showBooksListStage() 
	{
	    BookListBusinessLogicLayer  bookll = new BookListBusinessLogicLayer(bookStore);
	    bookll.showStage();
	}

	// Show search stage is the object of the insertion business logic layer which is created and initialized
	public void showSearchStage() 
	{
	    SearchingBusinessLogicLayer SearchBll = new SearchingBusinessLogicLayer(bookStore);
	    SearchBll.showStage();
	}
	
	private void readData()
	{
		ArrayList<Book> books = null;                                           // Array list of the books is null
		try
		{
			books = bookDAL.readBooks();                                        // Read function is called
		} 
		catch (ClassNotFoundException | IOException e) 
		{
			MessageBox.show("Welcome! First time execution...");                 // If the file is not found 
		}  
		if (books != null)                                                      // If Books exist in the file
		{
			bookStore = new BookStore("ABC", books);
		}
		else
		{
			bookStore = new BookStore("ABC");
		}
		System.out.println(bookStore);
	}
	
	private void writeData()                                                 
	{
		try 
		{
			bookDAL.writeBooks(bookStore.getBooks());                                         // Write data in the file
		} 
		catch (IOException e) 
		{
			MessageBox.show(e.getMessage());
		}
	}
}
