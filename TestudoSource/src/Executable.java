import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Executable extends JFrame{

	public Executable() {
		setTitle("Testudo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Executable window = new Executable();
		WalletInterface wScreen = new WalletInterface();
		PassScreen splash = new PassScreen();
		
		splash.login.addActionListener(new ButtonListener());
		window.add(splash);
		window.setSize(splash.getDEFAULT_WIDTH(), splash.getDEFAULT_HEIGHT());
		window.setVisible(true);
			
	}
	
	private boolean passCheck(String pwd) {
		
		return true;
	}
	
	
	class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent a) {
			passCheck("XXX");
		}
		
	}
	
	
	
}

