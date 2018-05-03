import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
							
							splash.setLogin_condition(true);
							
							if(splash.getLoginCond() == true) {
								splash.setVisible(false);
								window.setContentPane(wScreen.getContentPane());
								window.setBounds(100, 100, 640, 300);
								wScreen.setVisible(true);
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
	
	

	private boolean passCheck(String pwd) {
		
		return true;
	}
	
	
	class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent a) {
			passCheck("XXX");
		}
		
	}
	
	
	
}

