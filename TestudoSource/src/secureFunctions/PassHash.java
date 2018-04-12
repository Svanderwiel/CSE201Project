package secureFunctions;

import java.util.Base64;
import java.util.Base64.Encoder;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;


public class PassHash {
	
	private static final int saltLength = 40;
	private static final int keyLength = 120;
	private static final int hashLength = 15000;
	
	private static String hash(String pwd, byte[] salt) throws Exception{
		if(pwd == null || pwd.length() < 10) {
			throw new IllegalArgumentException("Password is too short.");
		}
		
		SecretKeyFactory inst = SecretKeyFactory.getInstance("PBEWithHmacSHA1AndDESede");
		SecretKey key = inst.generateSecret(new PBEKeySpec(pwd.toCharArray(), salt, hashLength, keyLength));
		Base64.Encoder mach = Base64.getEncoder();
		return mach.encodeToString(key.getEncoded());
	}
}
