package GuiAndPlayer;

import java.awt.Color;
import java.awt.FlowLayout;
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
	private final JLabel Ghosts;
	private final JLabel Fruits;
	private final JLabel Poison;
	public static int[] numbers = { 0, 0, 0 };

	private final JButton start;

	public MainMenu() {
		super("KocCat Mainmenu");
		setLayout(new GridLayout(6, 3));
		Ghosts = new JLabel("Enter the number of ghosts");
		add(Ghosts);
		numGhosts = new JTextField(6);
		add(numGhosts);
		Fruits = new JLabel("Enter the number of fruits");
		add(Fruits);
		numFruits = new JTextField(6);
		add(numFruits);
		Poison = new JLabel("Enter the number of poison");
		add(Poison);
		numPoison = new JTextField(6);
		add(numPoison);

		start = new JButton("Start the game!");

		ButtonHandler buttonHandler = new ButtonHandler();
		start.addActionListener(buttonHandler);
		// adding the button to the JFrame
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
			try {

				numbers[0] = Integer.parseInt(numGhosts.getText());
				numbers[1] = Integer.parseInt(numFruits.getText());
				numbers[2] = Integer.parseInt(numPoison.getText());
				Background background = new Background();
				Thread thread = new Thread(background);
				thread.start();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter an Integer");

			}

		}
	}

//	private class TextFieldHandler implements ActionListener {
//		// process textfield events
//		@Override
//		public void actionPerformed(ActionEvent event) {
//
//			// user pressed Enter in JTextField textField1
//			if (event.getSource() == numGhosts)
//				numbers[0] = Integer.parseInt(numGhosts.getText());
//
//			// user pressed Enter in JTextField textField2
//			else if (event.getSource() == numFruits)
//				numbers[1] = Integer.parseInt(numFruits.getText());
//
//			// user pressed Enter in JTextField textField3
//			else if (event.getSource() == numPoison)
//				numbers[2] = Integer.parseInt(numPoison.getText());
//
//		}
} // end private inner class TextFieldHandler
