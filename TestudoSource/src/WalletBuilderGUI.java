

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
		tabbedPane.addTab("Key Generation", null, panel, null);
		panel.setLayout(null);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(150, 13, 288, 22);
		comboBox.addItem("Generate new private key");
		comboBox.addItem("Generate new public key");
		comboBox.addItem("View public keys");
		comboBox.addItem("View private keys");
		panel.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 92, 288, 22);
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
		
		//Attempting to implement scroll bar
		//JScrollPane scroll = new JScrollPane(textArea);
		//scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//panel_1.add(scroll);
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Cold Storage", null, panel_2, null);
		panel_2.setLayout(null);
		
		btnGenerateKeys = new JButton("Display Keys");
		btnGenerateKeys.setBounds(232, 13, 115, 25);
		panel_2.add(btnGenerateKeys);
		
		btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { }  });
		btnExport.setBounds(253, 51, 69, 25);
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
}