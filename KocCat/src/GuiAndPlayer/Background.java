package GuiAndPlayer;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Edible.Edibles;
import Edible.Fruit;
import Edible.Poison;
import Ghosts.Ash;
import Ghosts.Casper;
import Ghosts.Dolly;
import Ghosts.Drawable;

public class Background extends JPanel implements KeyListener {
	public final int width = 650;
	public final int height = 650;
	private final String catUpPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\cat_up.png";
	private final String catDownPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\cat_down.png";
	private final String catRightPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\cat_right.png";
	private final String catLeftPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\cat_left.png";
	private final String backgroundPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\background1.png";
	private final String greenApplePath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\green_apple.png";
	private final String greenPoisonPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\green_poison.png";
	private Random rand = new Random();
	private JFrame frame = new JFrame("KocCat");
	private ImageIcon background = new ImageIcon(backgroundPath);
	public static Cat cat = new Cat(300, 300);
	ArrayList<Drawable> objects = new ArrayList<Drawable>();
	ArrayList<Edibles> edibleObjects = new ArrayList<Edibles>();

	public Background() {

		setFocusable(true); // adding the panel to the frame.
		frame.add(this);// setting the size of the frame to the size of the images
		// these numbers 666 and 689 make for a square frame if you call getWidth and
		frame.setSize(655, 678);
		// setting the close operation so the app stops working even in the background.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		fillArray();
		addKeyListener(this);
		startMovingRight();
		while (cat.getScore() >= 0) {
			// check if the cat has reached the edges of the square
			cat.isOnTheEdge();
			for (int i = 0; i < objects.size(); i++) {
				objects.get(i).doAction();
			}
			for (int i = 0; i < edibleObjects.size(); i++) {
				edibleObjects.get(i).grow();
			}
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}

	}

	public void paint(Graphics g) {
		// painting the background with the image we have
		g.drawImage(background.getImage(), 0, 0, null);

		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).draw(g);
		}
		for (int i = 0; i < edibleObjects.size(); i++) {
			edibleObjects.get(i).draw(g);
		}
		g.drawString("Score: " + cat.getScore(), 10, 10);
	}

	public void fillArray() {
		objects.add(cat);
		for (int i = 0; i < 8; i++) {
			switch (rand.nextInt(3)) {
			case 0:
				objects.add(new Ash(rand.nextInt(getWidth() - 50), rand.nextInt(getHeight() - 50)));
				break;
			case 1:
				objects.add(new Dolly(rand.nextInt(getWidth() - 50), rand.nextInt(getHeight() - 50)));
				break;
			case 2:
				objects.add(new Casper(rand.nextInt(getWidth() - 50), rand.nextInt(getHeight() - 50)));
				break;
			}
		}
		for (int i = 0; i < 5; i++) {
			edibleObjects.add(new Fruit(rand.nextInt(getWidth() - 50), rand.nextInt(getHeight() - 50), greenApplePath));
		}
		for (int i = 0; i < 5; i++) {
			edibleObjects
					.add(new Poison(rand.nextInt(getWidth() - 50), rand.nextInt(getHeight() - 50), greenPoisonPath));
		}
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

	/*
	 * this method is only for making the cat move to the right from the beginning.
	 * it only initializes a robot that presses the right button so the cat starts
	 * moving right away if this is a violation of the rules then please just delete
	 * this method.*
	 */
	public void startMovingRight() {
		try {
			Robot robot = new Robot();
			// Simulate a key press
			for (int i = 0; i < 3; i++) {
				robot.keyPress(KeyEvent.VK_RIGHT);
				robot.keyRelease(KeyEvent.VK_RIGHT);
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

}
