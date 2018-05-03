package secureFunctions;

import java.math.BigInteger;

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
	
	public static String[] toColdStorage(ECKey keyPair){
		String[] coldKeys = {keyPair.getPrivateKeyAsHex(), keyPair.getPublicKeyAsHex()};
		return coldKeys;
	}
	
	
}
