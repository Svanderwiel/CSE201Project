import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class WalletInterfaceOld extends JFrame{

	private int DEFAULT_HEIGHT = 800;
	private int DEFAULT_WIDTH = 900;
	
	JPanel panel = new JPanel();
	
	JTextArea amountTextField = new JTextArea();

	JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel();
	
	JButton upload = new JButton("Upload Tx");
	JButton sign = new JButton("Sign Tx");
	JButton exportSigned = new JButton("Export Signed Tx");
	JComboBox keyOptions = new JComboBox();
	//JScrollPane pane = new JScrollPane();
	
	
	public void TabbedPane() {
		JTabbedPane jtp = new JTabbedPane();
        getContentPane().add(jtp);
        jtp.addTab("Key Gen", jp1);
        jtp.addTab("Tx Signing", jp2);
        jtp.addTab("Cold Storage", jp3);
		
	}
	
	public WalletInterfaceOld() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Testudo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		amountTextField.setPreferredSize(new Dimension(200, 50));
		
		panel.setLayout(new GridBagLayout());
		
		
		createKeyOptions();
		jp2.add(upload);
		jp2.add(sign);
		jp2.add(exportSigned);
		jp1.add(keyOptions);
		panel.add(amountTextField);
		//panel.add(pane);
		TabbedPane();
		//add(panel);
		setVisible(true);
	}
	
	void createKeyOptions() {
		keyOptions.addItem("Generate new private key");
		keyOptions.addItem("Generate new public key");
		keyOptions.addItem("View public keys");
		keyOptions.addItem("View private keys");

	}

		
				
	class PrivateKeyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		}
		
	}
	
	public static void main(String[] args) {
		WalletInterfaceOld gui = new WalletInterfaceOld();
	}

}