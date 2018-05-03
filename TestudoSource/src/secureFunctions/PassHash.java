package secureFunctions;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class PassHash {
	
	private static final int saltLength = 10;
	private static final int keyLength = 120;
	private static final int hashLength = 15000;
	
	/**
	 * Retrieves a String representation of a hashed password appended to its assigned salt. Suitable security for storing.
	 * @param pwd - password to be hashed
	 * @return - String representation of salt and password, separated by delimiter used by pwdCheck
	 * @throws Exception - if the password passed to the hash method is not long enough.
	 */
	
	public static String saltedHash(String pwd) throws Exception {
		byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLength);
		return Base64.getEncoder().encodeToString(salt) + "|" + hash(pwd, salt);
	}
	
	/**
	 * Checks an input password against a stored salted hash code value.
	 * @param pwd - input password
	 * @param str - stored hash code value of access code
	 * @return - Input password == stored access code
	 * @throws Exception - if a salt is not stored with a access code, or vice versa
	 */
	public static boolean pwdCheck(String pwd, String str) throws Exception{
		
		//Checks password length to ensure hash method requirements are met.
		if(pwd == null || pwd.length() < 12) throw new IllegalArgumentException("checkMethodFailPwdLen");
		
		//Splits salt and stored password, hashes them, and checks the stored salted hash code.
		String[] separate = str.split("\\|");
		if (separate.length != 2) throw new IllegalArgumentException("checkMethodFail");
		return hash(pwd, Base64.getDecoder().decode(separate[0])).equals(separate[1]);
	}
	
	
	/**
	 * Generates a hash code value with a salt attached.
	 * @param pwd - password string to be hashed
	 * @param salt - a randomly generated sequence of characters to be used to uniquely identify passwords in the case of duplication. 
	 * @return - a salted hash code representation of a password 
	 * @throws Exception - if the input password does not meet the length requirements for password hashing.
	 */
	private static String hash(String pwd, byte[] salt) throws Exception{
		//Checks for correct password length.
		if(pwd == null || pwd.length() < 12) { throw new IllegalArgumentException("hashMethodFailLen");}
		
		//Generates a key factory, a key generated from the parameters, and returns a string representation of said key.
		SecretKeyFactory inst = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		SecretKey key = inst.generateSecret(new PBEKeySpec(pwd.toCharArray(), salt, hashLength, keyLength));
		return Base64.getEncoder().encodeToString(key.getEncoded());
	}
}
