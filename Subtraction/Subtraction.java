/**
 * <b>Subtraction.java</b><br>
 * @author Mohammed Nasir
 * @version 02/15/2015
 */
import java.util.*;

class Subtraction                               // Class Subtraction
	{
	
		static private int sub (int a, int b)   // Subtraction Function
		{	
			int c;
			c = a-b;
			return c;
		}

	
		
	 	static public void main(String args[])                  // Main function
		{
			int a,b,c;                                         // Integer Variables
			Scanner y = new Scanner(System.in);                // Input function

			System.out.println(" Name: Mohammed Nasir");
			System.out.println(" ");
			System.out.println("Please enter integer a:");
			a = y.nextInt();
			System.out.println("Please enter integer b:");
			b = y.nextInt();
			c=sub(a,b);                                        // Calling the function

			if(c<0)
				System.out.println("Negative Result:" + c);
			else
				System.out.println("Hello World!");
		}
			
		
 }	
		
		