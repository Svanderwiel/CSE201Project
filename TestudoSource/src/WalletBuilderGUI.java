

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.bitcoinj.core.ECKey;
import secureFunctions.KeyFunc;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class WalletBuilderGUI extends JPanel {

	protected JButton btnNewButton_1;
	protected JButton btnSignTransaction;
	protected JButton btnExportTransaction;
	protected JComboBox<String> comboBox;
	protected JTextArea textArea;
	protected JButton btnGenerateKeys;
	protected JButton btnExport;
	protected JTextArea txtrPublic;
	protected JTextArea txtrPrivate;
	protected JButton warn;
	
	private JPanel contentPane;
	public JPanel getContentPane() {
		return contentPane;
	}

	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public WalletBuilderGUI() {
		setBounds(100, 100, 640, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Key Management", null, panel, null);
		panel.setLayout(null);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(150, 13, 288, 22);
		comboBox.addItem("");
		comboBox.addItem("Generate new Key Pair");
		comboBox.addItem("View Public Key");
		comboBox.addItem("View Private Key");
		comboBox.setEditable(false);
	
		comboBox.addActionListener(new ComboListen());
		
		panel.add(comboBox);
		
		warn = new JButton(" ");
		warn.setBounds(185, 60, 225, 33);
		warn.addActionListener(new KeyMListener());
		panel.add(warn);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 120, 288, 44);
		textField_1.setEditable(false);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Signing transactions", null, panel_1, null);
		
		btnNewButton_1 = new JButton("Upload Transactions");
		btnNewButton_1.setBounds(223, 13, 149, 25);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.setLayout(null);
		
		btnSignTransaction = new JButton("Sign Transaction");
		btnSignTransaction.setBounds(56, 13, 129, 25);
		panel_1.add(btnSignTransaction);
		panel_1.add(btnNewButton_1);
		
		btnExportTransaction = new JButton("Export Transaction");
		btnExportTransaction.setBounds(410, 13, 139, 25);
		panel_1.add(btnExportTransaction);
		
		textArea = new JTextArea();
		textArea.setBounds(56, 47, 471, 130);
		textArea.setEditable(false);
		panel_1.add(textArea);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Cold Storage", null, panel_2, null);
		panel_2.setLayout(null);
		
		btnGenerateKeys = new JButton("Display Keys");
		btnGenerateKeys.setBounds(232, 13, 115, 25);
		btnGenerateKeys.addActionListener(new DisplayKeyListener());
		panel_2.add(btnGenerateKeys);
		
		btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { }  });
		btnExport.setBounds(253, 51, 69, 25);
		btnExport.addActionListener(new ColdStorageListener());
		panel_2.add(btnExport);
		
		JLabel lblPublic = new JLabel("Public :");
		lblPublic.setBounds(120, 110, 42, 16);
		panel_2.add(lblPublic);
		
		txtrPublic = new JTextArea();
		txtrPublic.setBounds(173, 107, 289, 22);
		txtrPublic.setText(" ");
		txtrPublic.setEditable(false);
		panel_2.add(txtrPublic);
		
		JLabel lblPrivate = new JLabel("Private :");
		lblPrivate.setBounds(120, 153, 48, 16);
		panel_2.add(lblPrivate);
		
		txtrPrivate = new JTextArea();
		txtrPrivate.setBounds(173, 150, 289, 22);
		txtrPrivate.setEditable(false);
		panel_2.add(txtrPrivate);
	}
	
	class ColdStorageListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
	              PrintWriter pw = new PrintWriter("coldStorage.txt");
	              String pubKey = txtrPublic.getText();
	              String prvKey = txtrPrivate.getText();
	             
	              pw.print("Public Key: " + pubKey);
	              pw.println();
	              pw.println("Private Key: " + prvKey);
	             
	              pw.close();
	        }  catch (FileNotFoundException f) {
	              System.out.println("CStorageExportFail");
	              f.printStackTrace();
	        }
			
		}
		
	}
	
	class DisplayKeyListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String[] keyPair = KeyFunc.toColdStorage(KeyFunc.getPrivKey());
			txtrPrivate.setText(keyPair[0]);
			txtrPublic.setText(keyPair[1]);
		}
		
	}
	class ComboListen implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String str = (String) comboBox.getSelectedItem();
			switch (str) {
			
				case "":
					warn.setText("");
					warn.setBounds(185, 60, 225, 33);
					textField_1.setBounds(150, 120, 288, 44);
					textField_1.setText("");
					break;
				case "Generate new Key Pair":
					warn.setBounds(85, 60, 415, 33);
					warn.setText("Generating new Key Pair will DESTROY PREVIOUS KEYS. Proceed?");
					break;
				case "View Public Key":
					warn.setBounds(185, 60, 225, 33);
					warn.setText("Click to view Public Key");
					break;
				case "View Private Key":
					warn.setBounds(80, 50, 420, 50);
					warn.setText("<html>WARNING: Your private key is sensitive data; mishandling<br />it can lead to complete loss of funds. Proceed?</html>");
					break;
			}
			
		}
	}
	
	class KeyMListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String str = (String) warn.getText();
			switch (str) {
				
				case "":
					textField_1.setBounds(150, 120, 288, 44);
					textField_1.setText("");
					break;
				case "Generating new Key Pair will DESTROY PREVIOUS KEYS. Proceed?":
					warn.setText("Ensure all funds associated with old key are transferred. Proceed?");
					warn.setBounds(80, 60, 425, 33);
					break;
				case "Ensure all funds associated with old key are transferred. Proceed?":
					ECKey newkey = new ECKey();
					KeyFunc.writePrivKey(newkey.getPrivKeyBytes());
					KeyFunc.writePubKey(newkey.getPubKey());
					textField_1.setBounds(150, 120, 288, 44);
					textField_1.setText("New Key Pair generated.");
					warn.setText("");
					warn.setBounds(185, 60, 225, 33);
					break;
				case "<html>WARNING: Your private key is sensitive data; mishandling<br />it can lead to complete loss of funds. Proceed?</html>":
					ECKey keypair = ECKey.fromPrivate(KeyFunc.getPrivKey());
					textField_1.setBounds(25, 120, 550, 44);
					textField_1.setText(keypair.getPrivateKeyAsHex());
					warn.setText("");
					warn.setBounds(185, 60, 225, 33);
					break;
				case "Click to view Public Key":
					ECKey keypair2 = ECKey.fromPrivate(KeyFunc.getPrivKey());
					textField_1.setBounds(25, 120, 550, 44);
					textField_1.setText(keypair2.getPublicKeyAsHex());
					warn.setText("");
					warn.setBounds(185, 60, 225, 33);
					break;
				
				
				
				
			}
			
		}
		
	}
}