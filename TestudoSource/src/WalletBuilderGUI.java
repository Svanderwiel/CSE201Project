

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class WalletBuilderGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WalletBuilderGUI frame = new WalletBuilderGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WalletBuilderGUI() {
		setTitle("Testudo Bitcoin Wallet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Key Generation", null, panel, null);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(150, 13, 288, 22);
		comboBox.addItem("Generate new private key");
		comboBox.addItem("Generate new public key");
		comboBox.addItem("View public keys");
		comboBox.addItem("View private keys");
		panel.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 92, 288, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Signing transactions", null, panel_1, null);
		
		JButton btnNewButton_1 = new JButton("Upload Transactions");
		btnNewButton_1.setBounds(223, 13, 149, 25);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.setLayout(null);
		
		JButton btnSignTransaction = new JButton("Sign Transaction");
		btnSignTransaction.setBounds(56, 13, 129, 25);
		panel_1.add(btnSignTransaction);
		panel_1.add(btnNewButton_1);
		
		JButton btnExportTransaction = new JButton("Export Transaction");
		btnExportTransaction.setBounds(410, 13, 139, 25);
		panel_1.add(btnExportTransaction);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(56, 47, 471, 130);
		panel_1.add(textArea);
		
		//Attempting to implement scroll bar
		//JScrollPane scroll = new JScrollPane(textArea);
		//scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//panel_1.add(scroll);
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Cold Storage", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnGenerateKeys = new JButton("Generate Keys");
		btnGenerateKeys.setBounds(232, 13, 115, 25);
		panel_2.add(btnGenerateKeys);
		
		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExport.setBounds(253, 51, 69, 25);
		panel_2.add(btnExport);
		
		JLabel lblPublic = new JLabel("Public :");
		lblPublic.setBounds(120, 110, 42, 16);
		panel_2.add(lblPublic);
		
		JTextArea txtrAsdfadf = new JTextArea();
		txtrAsdfadf.setBounds(173, 107, 289, 22);
		txtrAsdfadf.setText(" ");
		panel_2.add(txtrAsdfadf);
		
		JLabel lblPrivate = new JLabel("Private :");
		lblPrivate.setBounds(120, 153, 48, 16);
		panel_2.add(lblPrivate);
		
		JTextArea txtrPrivate = new JTextArea();
		txtrPrivate.setBounds(173, 150, 289, 22);
		panel_2.add(txtrPrivate);
	}
}