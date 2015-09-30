package application;
import java.util.*;

/**
 * <b>BookStore.java</b><br>
 * Book Store Model
 * @author Mohammed Nasir
 * @version 04/02/2015
 */
public class BookStore 
{
	private String bookStoreName;         // Book Store name
	private ArrayList<Book> books;        // Array list book of users
	
	/**
	 * <b>Book Store Constructor</b><br>
	 * By calling this function a Book Store
	 * object will be created and initialized 
	 * @param bookStoreName  book store name
	 * @param books Array list of books
	 */

	BookStore(String bookStoreName)
	{
		this.bookStoreName = bookStoreName;
		books = new ArrayList<Book>();
	}
	
	BookStore(String bookStoreName, ArrayList<Book> books)
	{
		this(bookStoreName);
		if (books != null)
		{
			this.books = books;
		}
	}
	
	// Accessor Functions
	public ArrayList<Book> getBooks() {
		return books;
	}
	
	/**
	 * <b>Add book function</b><br>
	 * By calling this function a Book will be added
	 * @param book book object
	 * @return books.add(book)
	 * @return false
	 */
	public boolean add(Book book)
	{
		if (search(book.getISBN()) == null)
		{
			return books.add(book);
		}
		return false;
	}
	
	/**
	 * <b>Removing book function</b><br>
	 * By calling this function a Book will be removed
	 * @param ISBN book ISBN
	 * @return books.remove(i)
	 * @return null
	 */
	
	public Book remove(String ISBN)
	{
		for (int i = 0; i < books.size(); i++)
		{
			if (ISBN.compareTo(books.get(i).getISBN()) == 0)
			{
				return books.remove(i);
			}
		}
		return null;
	}
	
	/**
	 * <b>Searching book function</b><br>
	 * By calling this function Book will be searched
	 * @param ISBN book ISBN
	 * @return books.get(i)
	 * @return null
	 */
	public Book search(String ISBN)
	{
		for (int i = 0; i < books.size(); i++)
		{
			if (ISBN.compareTo(books.get(i).getISBN()) == 0)
			{
				return books.get(i);
			}
		}
		return null;
	}
	
	@Override
	public String toString() 
	{
		StringBuilder sb = new StringBuilder(bookStoreName + " Bookstore" );
		sb.append("\n--------------\n");
		for (Book bookObj : books) 
		{
			sb.append(bookObj + "\n");
		}
		return sb.toString();
	}
}
