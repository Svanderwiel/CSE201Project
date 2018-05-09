package secureFunctions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class KeyFile {

	private File privFile = new File ("STOREDPRIV.txt");
	private File pubFile = new File ("STOREDPUB.txt");
	private FileWriter write;
	private Scanner read;
	
	protected KeyFile() {
		try {
			privFile.createNewFile();
			pubFile.createNewFile();
		} catch (IOException e) {
			System.out.println("KeyFileCreateFail");
			e.printStackTrace();
		}
		
	}
	
	public byte[] getPrivateKey() {
		try {
			read = new Scanner(privFile);
		} catch (FileNotFoundException e) {
			System.out.println("PrivKeyScanFail");
			e.printStackTrace();
		}
		String privEnc = read.nextLine();
		read.close();
		return Base64.getDecoder().decode(privEnc);
	}
	
	public boolean writePrivateKey(byte[] privKey) throws IOException {
		try {
			write = new FileWriter(privFile);
		} catch (IOException e) {
			System.out.println("KeyFileWriteFail");
			return false;
		}
		write.write(Base64.getEncoder().encodeToString(privKey) + "\n");
		write.close();
		return true;
	}
	
	public byte[] getPublicKey() {
		try {
			read = new Scanner(pubFile);
		} catch (FileNotFoundException e) {
			System.out.println("PubKeyScanFail");
			e.printStackTrace();
		}
		String pubEnc = read.nextLine();
		read.close();
		return Base64.getDecoder().decode(pubEnc);
	}
	
}











