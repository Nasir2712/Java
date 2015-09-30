import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * <b>Book.java</b><br>
 * UserList Model
 * @author Mohammed Nasir
 * @version 04/01/2015
 */

public class UserList
{
	private ArrayList<User> users; // Array list of users
	
	public UserList()
		{
			users = new ArrayList<User>();
		}
	
		/**
		 * <b>Users Constructor</b><br>
		 * By calling this function a User 
		 * object will be created and initialized 
		 * @param users Array list of users
		 */
	    public UserList(ArrayList<User> users)
		{
			this.users = users;
	    }

	 // Accessor functions
	 // These functions are used for the purpose of returning private data members values
		public ArrayList<User> getUsers() {return users;}
		
		/**
		 * <b>Finding user Function</b><br>
		 * By calling this function the user's name is searched inside the array list
		 * @param id User's Id
		 * @return users.get(i)
		 * @return null
		 */	
		public User findUser(int id)
		{
			for (int i = 0; i < users.size(); i++)
			{
				if (id == (users.get(i).getId()))
				{
					return users.get(i);
				}
			}
			return null;
		}
		
		/**
		 * <b>Finding username Function</b><br>
		 * By calling this function the user's username is searched inside the array list
		 * @param name User's username
		 * @return users.get(i)
		 * @return null
		 */	
		
		public User findUserName(String name)
		{
			for (int i = 0; i < users.size(); i++)
			{
				if (name.equals(users.get(i).getUsername()))
				{
					return users.get(i);
				}
			}
			return null;
		}
		
		/**
		 * <b>Removing user Function</b><br>
		 * By calling this function the user is removed from the array list
		 * @param id User's Id
		 * @return result
		 * @return false
		 */
		public boolean removeUser(int id)
		{
			for (int i = 0; i < users.size(); i++)
			{
				if (id == (users.get(i).getId()))
				{
					users.remove(i);
					return true;
				}
			}
			return false;
		}
	
		/**
		 * <b>Adding a user Function</b><br>
		 * By calling this function the user is added to the array list
		 * @param user User's Object
		 * @return users.add(user)
		 */
		public boolean add(User user)
		{
				return users.add(user);
		}
		
		 /**
    	 * <b>Login Function</b><br>
    	 * By calling this function a the username 
    	 * and password validations are passed
    	 * The password is hashed
    	 * @param username User's Username
    	 * @param password User's Password
    	 * @return user 
    	 * @return null
		 * @throws NoSuchAlgorithmException no such algorithm
    	 */	
		
		public User Login(String username, String password) throws NoSuchAlgorithmException
		{
			{
				for(User user: users)
					if(username.equals(user.getUsername()))
						if(user.verify(username, password))
							return user;
				return null;
			}
				
		}

		public String toString()
		{
			StringBuilder sb = new StringBuilder(users + "\n");
			for (User a : users) 
			{
				sb.append(a + "\n");
			}
			return sb.toString();
	}	
}

