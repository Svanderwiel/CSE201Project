import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;

import javax.swing.JTextArea;


import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class WalletInterfaceVer2 extends JFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WalletInterfaceVer2 frame = new WalletInterfaceVer2();
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
	public WalletInterfaceVer2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JComboBox comboBox = new JComboBox();
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		getContentPane().add(comboBox, gbc_comboBox);
		comboBox.addItem("Option1");
		comboBox.addItem("Option2");
		comboBox.addItem("Option3");
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnUploadTransaction = new JButton("Upload Transaction");
		GridBagConstraints gbc_btnUploadTransaction = new GridBagConstraints();
		gbc_btnUploadTransaction.insets = new Insets(0, 0, 5, 5);
		gbc_btnUploadTransaction.gridx = 1;
		gbc_btnUploadTransaction.gridy = 3;
		getContentPane().add(btnUploadTransaction, gbc_btnUploadTransaction);
		
		JButton btnNewButton = new JButton("Export Signed Transaction");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 3;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnIgnTransaction = new JButton("Sign Transaction");
		btnIgnTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnIgnTransaction = new GridBagConstraints();
		gbc_btnIgnTransaction.insets = new Insets(0, 0, 5, 5);
		gbc_btnIgnTransaction.gridx = 5;
		gbc_btnIgnTransaction.gridy = 3;
		getContentPane().add(btnIgnTransaction, gbc_btnIgnTransaction);
		
		JTextArea textArea_1 = new JTextArea();
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.gridwidth = 5;
		gbc_textArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 1;
		gbc_textArea_1.gridy = 5;
		getContentPane().add(textArea_1, gbc_textArea_1);
		
		JLabel lblColdStorage = new JLabel("Cold Storage");
		GridBagConstraints gbc_lblColdStorage = new GridBagConstraints();
		gbc_lblColdStorage.insets = new Insets(0, 0, 5, 5);
		gbc_lblColdStorage.gridx = 1;
		gbc_lblColdStorage.gridy = 7;
		getContentPane().add(lblColdStorage, gbc_lblColdStorage);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 7;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Export");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 7;
		getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 5;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 9;
		getContentPane().add(textArea, gbc_textArea);

	}

}
