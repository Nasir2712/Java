import java.io.*;
import java.security.NoSuchAlgorithmException;

/**
 * <b>User.java</b><br>
 * User Model
 * @author Mohammed Nasir
 * @version 04/01/2015
 */


@SuppressWarnings("serial")
public class User implements Serializable 
{
		private int id;              // User's ID
		private String name;         //  User's name
		private String username;    //  User's username
		private String password;   //  User's password
		
		/**
		 * <b>User Constructor</b><br>
		 * By calling this function a User 
		 * object will be created and initialized 
		 * @param id User's ID
		 * @param name User's name
		 * @param username User's username
		 * @param password User's password
		 * @throws NoSuchAlgorithmException no such algorithm
		 */

		public User(int id, String name, String username ,String password) throws NoSuchAlgorithmException
		{
				this.id = id;
				this.name = name;
				this.username = username;
				this.password =StringDigest.getDigest(password);
			   
		}
		
		// Accessor functions
		// These functions are used for the purpose of returning private 
		// data members values.
		public int getId() {return id;}
        public String getName() {return name;}
        public String getUsername() {return username;}
        public String getPassword() {return password;}
        
        
        /**
    	 * <b>Verify Function</b><br>
    	 * By calling this function the username 
    	 * and password validations are passed
    	 * The password is hashed
    	 * @param username User's Username
    	 * @param password User's Password
    	 * @return result
         * @throws NoSuchAlgorithmException no such algorithm
    	 */	
         public boolean verify (String username, String password) throws NoSuchAlgorithmException 
        {
        	 {
        			if((this.username).equals(username) && (this.password).equals(StringDigest.getDigest(password)))
        				return true;
        			else
        				return false;
        		}
    	}
               
        public String toString()
        {
        	
         return id + " " + name + " ";
}
}