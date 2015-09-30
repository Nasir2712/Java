package application;
import java.io.*;
import java.util.*;

/**
 * <b>DataAccessLayer.java</b><br>
 * Generic Data Access Layer
 * To read/write from/to a binary file using an ArrayList object
 * @author Mohammed Nasir
 * @version 04/02/2015
 */
public class DataAccessLayer<T extends Serializable>
{
	private ObjectOutputStream oos;  // Object Output Stream
	private FileOutputStream fos;    // File Output Stream
	private ObjectInputStream ois;  // Object Input Stream
	private FileInputStream fis;    // File Input Stream
	private String filename;        // The name of the file
	
	
	/**
	 * <b>Data Access Layer Constructor</b><br>
	 * By calling this function the data Access Layer object 
	 * will be created and initialized
	 * @param filename the name of the file
	 */
	public DataAccessLayer(String filename) 
	{
		this.filename = filename;
	}
	
	/**
	 * <b>Reading Books from the file</b><br>
	 * By calling this function the content is read from the file
	 * @throws IOException               input output exception
	 * @throws FileNotFoundException     file not found
	 * @throws ClassNotFoundException    class not found
	 * @return books
	 */
	
	@SuppressWarnings("unchecked")
	public ArrayList<T> readBooks() throws IOException, FileNotFoundException, ClassNotFoundException
	{
		ArrayList<T> books = null;
		fis = new FileInputStream(new File(filename));
		ois = new ObjectInputStream(fis);
		books = (ArrayList<T>)ois.readObject();
		ois.close();
		return books;
	}
	
	/**
	 * <b>Writing Books to the file</b><br>
	 * By calling this function the content is written to the file
	 * @param books Array list of books
	 * @throws IOException               input output exception
	 * @throws FileNotFoundException     file not found
	 */
	
	public void writeBooks(ArrayList<T> books) throws IOException, FileNotFoundException
	{
		fos = new FileOutputStream(new File(filename));
		oos = new ObjectOutputStream(fos);
		oos.writeObject(books);
		oos.close();
	}
}
