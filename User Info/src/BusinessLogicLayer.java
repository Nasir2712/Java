import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * <b>Business Logic Layer.java</b><br>
 * Business Logic Layer Model
 * @author Mohammed Nasir
 * @version 04/01/2015
 */


public class BusinessLogicLayer {
	private DataAccessLayer<User> DAL;                             // Data Access Layer
	private UserInterfaceLayer    UIL;                             // User Interface Layer 
	private UserList              userlist = new UserList();      // UserList layer
	private User                  currentuser = null;             // current user
	
	
	/**
	 * <b>User Controller Function</b><br>
	 * The user controller method is used to write a file 
	 * For first time Execution
	 * Read a file 
	 * For a file that does not exist
	 * @throws ClassNotFoundException class not found
	 * @throws IOException  input output exception
	 */
	public void UserController() throws IOException, ClassNotFoundException 
	{
		UIL = new UserInterfaceLayer();
		DAL = new DataAccessLayer<User>("UserInformationSystem.txt");
		ArrayList<User> users = null;
		try
		{
			users = DAL.read();
		}
		catch (FileNotFoundException e) 
		{		
			UIL.displayMessage("Welcome! First time execution");
		} 
		if (users != null)
		{
			userlist = new UserList(users);
		}
		else
		{
			userlist = new UserList();
		}
	}
	
	/**
	 * <b>Execute Function</b><br>
	 * The main function is executed here using user interface layer 
	 * Menu Options are displayed
	 * Functions are called
	 * @throws FileNotFoundException  file not found 
	 * @throws IOException            input output exception
	 * @throws NoSuchAlgorithmException No such algorithm
	 */
	public void Execute() throws FileNotFoundException, IOException, NoSuchAlgorithmException 
	{
		for (;;)
		{
			UIL = new UserInterfaceLayer();
			int opt = UIL.displayMenu();
			if (opt == 6)
			{
				break;
			}
			switch (opt)
			{
				case 1:
					adduser();
					break;
				case 2:
					removeuser();
					break;
				case 3:
					searchuser();
					break;
				case 4:
					userlist();
					break;
				case 5:
					Login();
					break;
			}
		}
		DAL.write(userlist.getUsers());
	}

	/**
	 * <b>Searching User Function</b><br>
	 * The search user function is used to search a file 
	 */
	private void searchuser() 
	{
		int id = UIL.scanUserID();
		String message = "";
		User user = userlist.findUser(id);
		
		if (user == null)
		{
			message = String.format("The user with ID: %s does not exists in the userlist", id);
		}
		else
		{
			message = user.toString();
		}
		UIL.displayMessage(message);
	}

	/**
	 * <b>Removing User Function</b><br>
	 * The search user function is for the admin to remove a user 
	 */
	 private void removeuser() 
	 {
		int id = UIL.scanUserID();
		String message = "";
		if (userlist.removeUser(id))
		{
			message = String.format("The User with ID: %s is removed Successfully", id);
		}
		else
		{
			message = String.format("ID: %s does not exist", id);
		}
		UIL.displayMessage(message);
	}
	 /**
		 * <b>Adding User Function</b><br>
		 * The search user function is for the admin to add a user 
		 * Also it checks for an existing name and username
		 */

	  private void adduser() throws NoSuchAlgorithmException 
	  {
		  String message = "";
		  User u = UIL.scanAdmin(); 
			if (userlist.findUser(u.getId()) != null)
				message = "This User Id already exists in the User List"; 
			else if(userlist.findUserName(u.getUsername()) != null) 
				message = "This Username already exists in the User List";
			else {
				userlist.add(u);
				message = String.format("The User with ID: %s is added successfully", u.getId());
			}
				UIL.displayMessage(message);
	  }
	  
	  /**
		 * <b>Displays UserList function</b><br>
		 * This function displayer user's information
		 */
	  
	  private void userlist() 
	  {
		UIL.displayMessage(userlist.toString());
	}
	  
	  /**
		 * <b>Login Function</b><br>
		 * The login function prompts the user for their username and password
		 * Calls the verify function
		 * Authenticates username and password validations
		 * @return true
		 * @throws FileNotFoundException
		 * @throws IOException
		 * @throws NoSuchAlgorithmException
		 */
	  
		private boolean Login() throws NoSuchAlgorithmException, FileNotFoundException, IOException
		{
		boolean result = false;
		String username = UIL.scanUsername();
		String password = UIL.scanPassword();
		currentuser = userlist.Login(username,password);
		System.out.println(currentuser);
		if(currentuser != null)
		{
			System.out.println("You are now logged in");
			result = true;
		}
		else
			{
				UIL.displayMessage("Username or Password is incorrect");
			}
		return result;
		}
}