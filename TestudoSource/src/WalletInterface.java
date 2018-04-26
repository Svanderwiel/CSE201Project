import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class WalletInterface extends JPanel{

	private final int DEFAULT_HEIGHT = 600;
	private final int DEFAULT_WIDTH = 700;
	
	JTextArea amountTextField = new JTextArea();

	JButton coldStorage = new JButton("Transfer Key to cold Storage");
	JButton privateKey = new JButton("Generate Private Key");
	JButton publicKey = new JButton("Generate Public Key");
	
	public WalletInterface() {
		//setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		amountTextField.setPreferredSize(new Dimension(200, 50));

		GridBagLayout layout = new GridBagLayout();
		
		setLayout(layout);
		
		add(coldStorage);
		add(privateKey);
		add(publicKey);
		add(amountTextField);
	}
	
	class PrivateKeyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		}
		
	}
	
	public static void main(String[] args) {
		WalletInterface gui = new WalletInterface();
	}
	
	public int getDEFAULT_HEIGHT() {
		return DEFAULT_HEIGHT;
	}

	public int getDEFAULT_WIDTH() {
		return DEFAULT_WIDTH;
	}

}
