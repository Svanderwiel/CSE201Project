import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PassScreen extends JPanel{

	private final int DEFAULT_WIDTH = 400;
	private final int DEFAULT_HEIGHT = 100;

	private boolean login_condition = false;

	

	JTextArea input = new JTextArea(1, 25);
	JButton login = new JButton("Login");
	JLabel label = new JLabel("Input Access Code:");
	
	public PassScreen() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		//splash.setLayout(new GridLayout(1,2));
		input.setAlignmentY(CENTER_ALIGNMENT);
		login.setAlignmentY(CENTER_ALIGNMENT);
		add(label);
		add(input);
		add(login);
		
		login.addActionListener(new Listener());
	}
	
	public void passCheck(String pwd) {
		
		login_condition = true;
	}
	
	public boolean getLoginCond() {
		return login_condition;
	}
	
	public void setLogin_condition(boolean login_condition) {
		this.login_condition = login_condition;
	}
	
	private class Listener implements ActionListener{
		
			public void actionPerformed(ActionEvent a) {
				passCheck("XXX");
			}
		
	}
	
	public int getDEFAULT_WIDTH() {
		return DEFAULT_WIDTH;
	}

	public int getDEFAULT_HEIGHT() {
		return DEFAULT_HEIGHT;
	}
	
	public boolean isLogin_condition() {
		return login_condition;
	}
}
