package secureFunctions;

import java.math.BigInteger;
import java.util.Arrays;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.Base58;
import org.bitcoinj.core.ECKey;

public class KeyFunc {
	
	public static byte[] privateKeyGen() {
		ECKey newkey = new ECKey();
		return newkey.getPrivKeyBytes(); 
	}
	
	public static byte[] publicKeyGen(BigInteger privKey) {
		ECKey newkey = ECKey.fromPrivate(privKey);
		return newkey.getPubKey();
	}
	
	public static String[] toColdStorage(byte[] privKey, byte[] pubKey){
		String[] coldKeys = { Arrays.toString(privKey), Arrays.toString(pubKey) };
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

}
