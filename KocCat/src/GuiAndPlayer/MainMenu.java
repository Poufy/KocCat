package GuiAndPlayer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MainMenu extends JFrame {
	private final JTextField numGhosts;
	private final JTextField numFruits;
	private final JTextField numPoison;
	private final JLabel ghosts;
	private final JLabel fruits;
	private final JLabel poison;
	public static int[] numbers = { 0, 0, 0 };
	private final JButton start;

	public MainMenu() {
		super("KocCat Mainmenu");
		setLayout(new GridLayout(4, 3));

		poison = new JLabel("Enter the number of poison");
		add(poison);
		numPoison = new JTextField(6);

		// when at the third field press enter to start the game instead of clicking at
		// the button.
		add(numPoison);
		fruits = new JLabel("Enter the number of fruits");
		add(fruits);

		numFruits = new JTextField(6);
		add(numFruits);

		ghosts = new JLabel("Enter the number of ghosts");
		add(ghosts);

		numGhosts = new JTextField(6);
		numGhosts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start.doClick();
			}
		});
		add(numGhosts);
		start = new JButton("Start the game!");

		ButtonHandler buttonHandler = new ButtonHandler();
		start.addActionListener(buttonHandler);
		// adding the button to the JFrame
		add(start);
		this.setSize(500, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				numbers[0] = Integer.parseInt(numPoison.getText());
				numbers[1] = Integer.parseInt(numFruits.getText());
				numbers[2] = Integer.parseInt(numGhosts.getText());
				Background background = new Background();
				Thread thread = new Thread(background);
				thread.start(); // start the thread that starts the main program this calls the run() method in
								// the Background
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter an Integer");
			}

		}
	}

}
