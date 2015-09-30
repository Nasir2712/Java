import java.io.*;
import java.util.*;

/**
 * <b>Data Access Layer.java</b><br>
 * Data Access Layer
 * @author Mohammed Nasir
 * @version 04/01/2015
 */

@SuppressWarnings("hiding")
public class DataAccessLayer<User extends Serializable> 
{
		private ObjectOutputStream oos; // Object Output Stream
		private FileOutputStream fos;   // File Output Stream
		private ObjectInputStream ois;  // Object input Stream
		private FileInputStream fis;   // File input Stream
		private String filename;       // The name of the file
		
		public DataAccessLayer(String filename) 
		{
			this.filename = filename;
		}
		
	
		@SuppressWarnings("unchecked")
		public ArrayList<User> read() throws IOException, FileNotFoundException, ClassNotFoundException
		{
			ArrayList<User> users = null;
			fis = new FileInputStream(new File(filename));
			ois = new ObjectInputStream(fis);
			users = (ArrayList<User>)ois.readObject();
			ois.close();
			return users;
		}
		
		public void write(ArrayList<User> users) throws IOException, FileNotFoundException
		{
			fos = new FileOutputStream(new File(filename));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(users);
			oos.close();
		}
	}
	

