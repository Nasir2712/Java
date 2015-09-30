package application;
import javafx.stage.*;

/**
 * <b>BookListBusinessLogicLayer.java</b><br>
 * @author  Mohammed Nasir
 * @version 04/02/2015
 */

public class BookListBusinessLogicLayer 
{
	private Stage 		booklistStage;                               // Stage of the book List
	private BookStore 	bookStore;                                   // Book Store
	
	
	/**
	 * <b>Book List Business Logic Layer Constructor</b><br>
	 * By calling this function the book list business Logic Layer
	 * object will be created and initialized 
	 * @param bookStore      book store 
	 */
	public BookListBusinessLogicLayer(BookStore bookStore)             
	{
		this.bookStore = bookStore;
		booklistStage = new BookListsStage(this);
	}
	
	public void showStage()
	{
		booklistStage.initModality(Modality.APPLICATION_MODAL);
		booklistStage.showAndWait();
	}
	
	
	// Displaying the book list function
	// Main logic 
	public String displayBookList() 
	{
		return bookStore.toString();
	}
	
	// Closing function of the book list stage
	public void closeStage()
	{
		booklistStage.close();
	}
}
