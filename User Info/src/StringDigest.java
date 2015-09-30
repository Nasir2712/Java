import java.security.*;

/**
 * <b>String Digest.java</b><br>
 * Hash Model
 * @author Mohammed Nasir
 * @version 04/01/2015
 */


public class StringDigest 
{
	
	/**
	 * <b>Hashing Function</b><br>
	 * By calling this function a message is hashed
	 * @param message a string which is hashed
	 * @throws NoSuchAlgorithmException no such algorithm exception
	 * @return sb.toString
	 */	
	public static String getDigest(String message) throws NoSuchAlgorithmException
	{
		MessageDigest md = MessageDigest.getInstance("SHA1");
		byte[] result = md.digest(message.getBytes());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) 
		{
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
	    }
		return sb.toString(); 
	}	
	
}
