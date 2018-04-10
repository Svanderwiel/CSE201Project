

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class WalletInterface extends JFrame{

	private int DEFAULT_HEIGHT = 600;
	private int DEFAULT_WIDTH = 700;
	
	JPanel panel = new JPanel();
	
	JTextArea amountTextField = new JTextArea();

	JButton coldStorage = new JButton("Transfer Key to cold Storage");
	JButton privateKey = new JButton("Generate Private Key");
	JButton publicKey = new JButton("Generate Public Key");
	
	public WalletInterface() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Testudo Bitcoin Wallet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		amountTextField.setPreferredSize(new Dimension(200, 50));
		
		panel.add(coldStorage);
		panel.add(privateKey);
		panel.add(publicKey);
		panel.add(amountTextField);
		
		add(panel);
		setVisible(true);
	}
	
	class PrivateKeyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		}
		
	}
	
	public static void main(String[] args) {
		WalletInterface gui = new WalletInterface();
	}

}
