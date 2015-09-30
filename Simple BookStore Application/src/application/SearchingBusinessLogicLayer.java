package application;

import javafx.stage.*;

/**
 * <b>SearchingBusinessLogicLayer.java</b><br>
 * 
 * @author Mohammed Nasir
 * @version 03/02/2015
 */
public class SearchingBusinessLogicLayer 
{
	private Stage 	        searchingStage;                          // Searching stage of the stage
	private BookStore 	    bookStore;                               // Book store  
	
	
	/**
	 * <b>Deletion Business Logic Layer Constructor</b><br>
	 * By calling this function the deletion business Logic Layer
	 * object will be created and initialized 
	 * @param bookStore      book store 
	 */
	public SearchingBusinessLogicLayer(BookStore bookStore) 
	{
		this.bookStore = bookStore;
		searchingStage = new SearchingStage(this);
	}
	
	public void showStage()
	{
		searchingStage.initModality(Modality.APPLICATION_MODAL);
		searchingStage.showAndWait();
	}
	
	/**
	 * <b>Search Function</b><br>
	 * By calling this function the ISBN of the book is searched
	 * object will be created and initialized 
	 * @param ISBN     ISBN of the book 
	 */
	public void search(String ISBN)
	{
		Book book = bookStore.search(ISBN);
		if (book == null)
		{
			MessageBox.show("The book with ISBN: %s does not exists in the bookstore" + ISBN);
		}
		else
		{
			MessageBox.show("This book exists in the bookstore:\n" + book.toString());
		}
	}
	
	public void closeStage()
	{
		searchingStage.close();
	}
}
