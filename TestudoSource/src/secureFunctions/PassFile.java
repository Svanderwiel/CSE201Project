package secureFunctions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class PassFile {

	private boolean newUser = false;
	private File passFile = new File("STOREDAC.txt");
	private FileWriter write;
	private Scanner read;
	
	public PassFile() {
		if(!passFile.exists()) {
			try {
				passFile.createNewFile();
				setNewUser(true);
			} catch (IOException e) {
				System.out.println("Pwd I/O Failure");
				e.printStackTrace();
			}
		} else { setNewUser(false);}
		
		try {
			write = new FileWriter(passFile, true);
			read = new Scanner(passFile);
		} catch (IOException e) {
			System.out.println("Pwd Write/Read Fail");
			e.printStackTrace();
		}
		
		
	}
	
	public String getStoredAC() {
		String acHash = read.nextLine();
		read.reset();
		return acHash;
	}

	public boolean writeAC(String acHash){
		try {
			write.write(acHash + "\n");
			write.flush();
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
