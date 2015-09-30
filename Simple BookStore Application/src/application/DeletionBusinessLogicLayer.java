package application;

import javafx.stage.*;

/**
 * <b>DeletionBusinessLogicLayer.java</b><br>
 * 
 * @author Mohammed Nasir
 * @version 04/02/2015
 */


public class DeletionBusinessLogicLayer 
{
	private Stage 		deletionStage;                       // Deletion stage 
	private BookStore 	bookStore;                           // Book store

	/**
	 * <b>Deletion Business Logic Layer Constructor</b><br>
	 * By calling this function the deletion business Logic Layer
	 * object will be created and initialized 
	 * @param bookStore      book store 
	 */
	public DeletionBusinessLogicLayer(BookStore bookStore) 
	{
		this.bookStore = bookStore;
		deletionStage = new DeletionStage(this);
	}
	
	public void showStage()
	{
		deletionStage.initModality(Modality.APPLICATION_MODAL);
		deletionStage.showAndWait();
	}
	
	/**
	 * <b>Remove Function</b><br>
	 * By calling this function the book list business Logic Layer
	 * object will be created and initialized 
	 * @param ISBN     ISBN of the book 
	 */
	public void remove(String ISBN)
	{
		if (bookStore.remove(ISBN) != null)
		{
			MessageBox.show("The following book has been removed:\n" + ISBN);
		}
		else
		{
			MessageBox.show("A book with this ISBN does not exist");
		}
	}
	
	public void closeStage()
	{
		deletionStage.close();
	}
}
