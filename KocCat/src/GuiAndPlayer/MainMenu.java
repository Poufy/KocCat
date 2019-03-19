package GuiAndPlayer;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MainMenu extends JFrame {

	private final JTextField numGhosts;
	private final JTextField numFruits;
	private final JTextField numPoison;

	private final JButton start;

	public MainMenu() {
		super("KocCat Mainmenu");
		setLayout(new FlowLayout());

		numGhosts = new JTextField("Number of ghosts", 9);
		add(numGhosts);

		numFruits = new JTextField("Number of fruits", 9);
		add(numFruits);

		numPoison = new JTextField("Number of Poisonous fruits", 9);
		add(numPoison);

		start = new JButton("Start the game!");

		ButtonHandler handler = new ButtonHandler();
		start.addActionListener(handler);
		//adding the button to the JFrame
		add(start);
		this.setSize(500, 300);
		this.setBackground(Color.cyan);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private class ButtonHandler implements ActionListener {
		// handle button event
		@Override
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(null, "lol");
		}
	}
}
