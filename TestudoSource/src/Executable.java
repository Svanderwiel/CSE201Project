import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import secureFunctions.PassFile;
import secureFunctions.PassHash;

import javax.swing.JFrame;

public class Executable extends JFrame{

	public Executable() {
		setTitle("Testudo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Executable window = new Executable();
					WalletBuilderGUI wScreen = new WalletBuilderGUI();
					PassScreen splash = new PassScreen();
					
					window.add(splash);
					window.setContentPane(splash);
					window.add(wScreen);
					window.setSize(splash.getDEFAULT_WIDTH(), splash.getDEFAULT_HEIGHT());
					
					
					splash.login.addActionListener(new ActionListener(){
						
						public void actionPerformed(ActionEvent a) {
							
							if(splash.input.getText().length() < 12) {
								splash.label.setText("Password must be over 12 characters!");
							} else {
							
							try {
								if(passCheck(splash.input.getText())) {
									splash.setVisible(false);
									window.setContentPane(wScreen.getContentPane());
									window.setBounds(100, 100, 640, 300);
									wScreen.setVisible(true);
								} else {
									splash.label.setText("Password Incorrect!");
									splash.input.setText("");
								}
							} catch (Exception e) {
								System.out.println("ya fucked up.");
								e.printStackTrace();
							}
							}
						}
					});
					
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	private static boolean passCheck(String pwd) throws Exception {
		
		PassFile checker = new PassFile();
		if(checker.isNewUser()) {
			checker.writeAC(PassHash.saltedHash(pwd));
			return true;
		} else {
			return PassHash.pwdCheck(pwd, checker.getStoredAC());
		}
	}
}

