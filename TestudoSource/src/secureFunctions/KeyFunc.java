package secureFunctions;

import java.io.IOException;
import org.bitcoinj.core.ECKey;

public class KeyFunc {
	
	public static byte[] privateKeyGen() {
		ECKey newkey = new ECKey();
		return newkey.getPrivKeyBytes(); 
	}
	
	public static byte[] publicKeyGen(byte[] privKey) {
		ECKey newkey = ECKey.fromPrivate(privKey);
		return newkey.getPubKey();
	}
	
	public static String[] toColdStorage(byte[] privKey){
		ECKey newkey = ECKey.fromPrivate(privKey);
		String[] coldKeys = { newkey.getPrivateKeyAsHex(), newkey.getPublicKeyAsHex() };
		return coldKeys;
	}
	
	public static byte[] getPrivKey() {
		KeyFile reader = new KeyFile();
		return reader.getPrivateKey();
	}
	
	public static byte[] getPubKey() {
		KeyFile reader = new KeyFile();
		return reader.getPublicKey();
	}
	
	public static boolean writePubKey(byte[] key) {
		KeyFile reader = new KeyFile();
		try {
			return reader.writePublicKey(key);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean writePrivKey(byte[] key) {
		KeyFile reader = new KeyFile();
		try {
			return reader.writePrivateKey(key);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
