import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PassScreen extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int DEFAULT_WIDTH = 400;
	private final int DEFAULT_HEIGHT = 100;

	private boolean login_condition = false;

	

	protected JTextArea input = new JTextArea(1, 25);
	protected JButton login = new JButton("Login");
	protected JLabel label = new JLabel("Input Access Code:");
	
	public PassScreen() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		input.setAlignmentY(CENTER_ALIGNMENT);
		login.setAlignmentY(CENTER_ALIGNMENT);
		add(label);
		add(input);
		add(login);

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
