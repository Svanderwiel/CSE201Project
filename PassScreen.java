import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PassScreen extends JFrame{

	private final int DEFAULT_WIDTH = 400;
	private final int DEFAULT_HEIGHT = 100;
	private boolean login_condition = false;
	
	JPanel splash = new JPanel();
	JTextArea input = new JTextArea(1, 25);
	JButton login = new JButton("Login");
	JLabel label = new JLabel("Input Access Code:");
	
	public PassScreen() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Testudo Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//splash.setLayout(new GridLayout(1,2));
		input.setAlignmentY(CENTER_ALIGNMENT);
		login.setAlignmentY(CENTER_ALIGNMENT);
		splash.add(label);
		splash.add(input);
		splash.add(login);
		
		login.addActionListener(new Listener());
		
		add(splash);
		setVisible(true);
		
	}
	
	public void passCheck(String pwd) {
		
		login_condition = true;
	}
	
	public boolean getLoginCond() {
		return login_condition;
	}
	
	private class Listener implements ActionListener{
		
			public void actionPerformed(ActionEvent a) {
				input.setText("Incorrect Access Code.");
			}
		
		}
}
