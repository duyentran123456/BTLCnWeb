package cnweb.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityHelper {
		
	public static String hashed(String password) {		
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(password.getBytes());
			String passwordHashed = new String(messageDigest.digest());
			
			return passwordHashed;
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return password;
		}
		
	}
	
}
