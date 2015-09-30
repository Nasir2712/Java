import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * <b>User Interface layer.java</b><br>
 * Presentation Layer
 * @author Mohammed Nasir
 * @version 04/01/2015
 */

public class UserInterfaceLayer 
{
	private final String[] menuOptions = {"1) Add a new user", "2) Remove a User", "3) Search a User", "4) List of users","5) Login/Logout", "6) Exit"}; // Array List of users
	
	 /**
		 * <b>Input Function</b><br>
		 * By calling this function the username is entered
		 * @return username
		 */
	String scanUsername()                    
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("\nUsername: ");
		String username = sc.next();
		return username;
	}

	 /**
		 * <b>Input Function</b><br>
		 * By calling this function the password is entered
		 * The password is hashed
		 * @return password
		 * @throws NoSuchAlgorithmException
		 */

    String scanPassword() throws NoSuchAlgorithmException  
    {
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("\nPassword: ");
		String password = StringDigest.getDigest(sc.next());
		return password;
	}
    
    /**
	 * <b>Input Function</b><br>
	 * By calling this function the user ID is entered
	 * The password is hashed
	 * @return sc.nextInt()
	 */
    
    public int scanUserID()                                
    	{
    		@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
        	System.out.print("\n Enter your ID :");
		    return sc.nextInt();
    	}
    
    /**
	 * <b>Input Function</b><br>
	 * By calling this function the admin details are entered
	 * The password is hashed
	 * @return scanUser()
	 * @throws NoSuchAlgorithmException no such algorithm
	 */	
    public User scanAdmin() throws NoSuchAlgorithmException
    {
    	return scanUser();
    }
    	
    /**
  	 * <b>Input Function</b><br>
  	 * By calling this function the user details are entered
  	 * The password is hashed
  	 * @return admin;
  	 * @throws NoSuchAlgorithmException no such algorithm
  	 */
    
    public User scanUser() throws NoSuchAlgorithmException
    {
    	int id = scanUserID();
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
    	System.out.print("\n Enter your Name: ");
    	String name = sc.nextLine();
    	String username = scanUsername();
    	String password = scanPassword();
    	User admin = new User(id,name,username,password);
    	return admin;
    }
    
    /**
  	 * <b>Displaying the menu Function</b><br>
  	 * By calling this function the menu is displayed
  	 * @return opt;
  	 */
    public int displayMenu()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("\nMain Menu");
		System.out.println("---------");
		for (int i = 0; i < menuOptions.length; i++) 
		{
			System.out.println(menuOptions[i]);
		}
		System.out.print("Enter an option: ");
		int opt = sc.nextInt();
		if (opt >= 1 && opt <= 5)
		{
			String menuTitle = menuOptions[opt - 1];
			menuTitle = menuTitle.substring(3, menuTitle.length());
			System.out.println("\n" + menuTitle);
			System.out.println("--------------");
		}
		return opt;
	}
    
    /**
  	 * <b>Displaying the message Function</b><br>
  	 * By calling this function the message is displayed
  	 * @param message the message that wants to get displayed
  	 */
    
    public void displayMessage(String message)
	{
		System.out.println(message);
	}
    }
    
