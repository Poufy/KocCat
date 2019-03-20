package GuiAndPlayer;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Background extends JPanel implements KeyListener {
	private final String catUpPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\cat_up.png";
	private final String catDownPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\cat_down.png";
	private final String catRightPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\cat_right.png";
	private final String catLeftPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\cat_left.png";
	private final String backgroundPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\background1.png";
	private JFrame frame = new JFrame("KocCat");
	private ImageIcon background = new ImageIcon(backgroundPath);
	private Cat cat = new Cat(300, 300, catRightPath);

	public static void main(String[] args) {
		// MainMenu mm = new MainMenu();
		Background background = new Background();

	}

	public Background() {
		setFocusable(true);// adding the panel to the frame.
		frame.add(this);// setting the size of the frame to the size of the images
		// these numbers 666 and 689 make for a square frame if you call getWidth and
		// getHeight both should be 650
		frame.setSize(666, 689);
		// setting the close operation so the app stops working even in the background.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		addKeyListener(this);

//		Handler handler = new Handler();
//		Timer timer = new Timer(1000, handler);
//		timer.start();
		while (cat.isAlive()) {
			//checks the edges of the cat
			cat.isOnTheEdge();
			cat.doAction();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();

		}

	}

	public void paint(Graphics g) {
		// painting the background with the image we have
		g.drawImage(background.getImage(), 0, 0, null);
		// drawing the squares
		for (int i = 0; i < this.getHeight(); i += 50) {
			for (int j = 0; j < this.getWidth(); j += 50) {
				g.drawRect(j, i, 50, 50);
			}
		}
		// drawing the cat
		cat.draw(g);
	}

	@Override
	// 1 for right 2 for left 3 for up 4 for down
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			cat.setDirection(1);
			
			try {
				cat.setImage(catRightPath);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			cat.setDirection(2);
			try {
				cat.setImage(catLeftPath);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			cat.setDirection(3);
			try {
				cat.setImage(catUpPath);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			cat.setDirection(4);
			try {
				cat.setImage(catDownPath);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
