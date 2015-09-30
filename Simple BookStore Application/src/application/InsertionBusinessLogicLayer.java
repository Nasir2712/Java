package application;

import javafx.stage.*;

/**
 * <b>InsertionBusinessLogicLayer.java</b><br>
 * 
 * @author Mohammed Nasir
 * @version 04/02/2015
 */
public class InsertionBusinessLogicLayer 
{
	private Stage 		insertionStage;                  // Insertion stage 
	private BookStore 	bookStore;                       // Book store
	
	/**
	 * <b>Insertion Business Logic Layer Constructor</b><br>
	 * By calling this function a insertion business Logic Layer
	 * object will be created and initialized 
	 * @param bookStore  message from the application
	 */
	
	public InsertionBusinessLogicLayer(BookStore bookStore) 
	{
		this.bookStore = bookStore;
		insertionStage = new InsertionStage(this);
	}
	
	public void showStage()
	{
		insertionStage.initModality(Modality.APPLICATION_MODAL);
		insertionStage.showAndWait();
	}
	
	/**
	 * <b>Add Book Function</b><br>
	 * By calling this function a Book is added
	 * Message box shows the condition
	 * @param newBook  a new book
	 * ISBN should be exact 5 digits
	 */
	public void addBook(Book newBook)
	{
		if(newBook.getISBN().length()==5)
		{
			if (bookStore.add(newBook))
			{
				MessageBox.show("The following book has been added:\n" + newBook);
			}
			else
			{
				MessageBox.show("A book with the same ISBN already exists");
			}
	}
			else
			MessageBox.show("ISBN should be of 5 digits");
		}
	
	
	public void closeStage()
	{
		insertionStage.close();
	}
}
