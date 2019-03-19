package GuiAndPlayer;

import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Background extends JPanel {

	private JFrame frame = new JFrame("KocCat");
	private ImageIcon background = new ImageIcon(
			"C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\GuiAndPlayer\\background1.png");

	public Background() {
		// adding the panel to the frame.
		frame.add(this);
		// setting the size of the frame to the size of the image.
		frame.setSize(1366, 768);
		//setting the close operation so the app stops working even in the background.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void paint(Graphics g) {
		//painting the background with the image we have
		g.drawImage(background.getImage(), 0, 0, null);
	}

}
