package secureFunctions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//import java.io.FileReader;
import java.io.File;

public class PassFile {

	private boolean newUser;
	private File passFile = new File("STOREDAC.txt");
	private FileWriter write;
	private Scanner read;
	
	public PassFile() {
		
		if(!passFile.exists()) {
			try {
				passFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Pwd I/O Failure");
				e.printStackTrace();
			}
		}
		
		try {
			write = new FileWriter(passFile);
			read = new Scanner(passFile);
		} catch (IOException e) {
			System.out.println("Pwd Write/Read Fail");
			e.printStackTrace();
		}
		
	}
	
	public String getStoredAC() {
		String acHash = read.nextLine();
		//read.reset();
		return acHash;
	}

	public boolean writeAC(String acHash){
		try {
			write.write(acHash + "\n");
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public boolean isNewUser() {
		return newUser;
	}

	public void setNewUser(boolean newUser) {
		this.newUser = newUser;
	}
}
