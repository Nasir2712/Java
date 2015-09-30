package application;
import java.io.*;

/**
 * <b>Book.java</b><br>
 * Book Model
 * @author 	Mohammed Nasir
 * @version 03/02/2015
 */
@SuppressWarnings("serial")
public class Book implements Serializable
{
	private String ISBN;           // Book's ISBN
	private String title;          // Title of the book
	private String author;         // Author of the book
	private int edition;          // Edition of the book
	private double price;         // Price of the book
	
	// Accessor Functions                            
	public String getISBN() {
		return ISBN;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getEdition() {
		return edition;
	}
	public double getPrice() {
		return price;
	}
	
	/**
	 * <b>Book Constructor</b><br>
	 * By calling this function a Book 
	 * object will be created and initialized 
	 * @param ISBN Book ISBN
	 * @param title Book title
	 * @param author Book Author
	 * @param edition Book edition
	 * @param price   Book price
	 */
	public Book(String ISBN, String title, String author, int edition, double price)
	{
		this.ISBN = ISBN;
		this.author = author;
		this.title = title;
		this.price = price;
		this.edition = edition;
	}
	
	public String toString() {
		
		return ISBN + " " + title + " " + author + " " + edition + " " + price;
	}
}
