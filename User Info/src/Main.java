import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * <b>Main.java</b><br>
 * Main Model
 * @author Mohammed Nasir
 * @version 04/01/2015
 */

public class Main {
	
	/**
	 * <b>Main Function</b><br>
	 * The main function is executed here using business logic layer
	 * @param  args                    Arguments   
	 * @throws ClassNotFoundException  class not found exception
	 * @throws IOException             input output exception
	 * @throws FileNotFoundException   file not found exception
	 */

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		BusinessLogicLayer BLL = new BusinessLogicLayer();
		try 
		{
			BLL.UserController();
			BLL.Execute();
		} 
		catch (NoSuchAlgorithmException | FileNotFoundException e) 
		{	
			System.out.println(e.getMessage());
		}
}
}