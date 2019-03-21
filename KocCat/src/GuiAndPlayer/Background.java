package GuiAndPlayer;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Edible.Fruit;
import Edible.Poison;

public class Background extends JPanel implements KeyListener {
	private final String catUpPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\cat_up.png";
	private final String catDownPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\cat_down.png";
	private final String catRightPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\cat_right.png";
	private final String catLeftPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\cat_left.png";
	private final String backgroundPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\background1.png";
	public final String greenApplePath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\green_apple.png";
	public final String greenPoisonPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\green_poison.png";
	private Random rand = new Random();
	private int randomX = 50 * rand.nextInt(13);
	private int randomY = 50 * rand.nextInt(13);
	private JFrame frame = new JFrame("KocCat");
	private ImageIcon background = new ImageIcon(backgroundPath);
	private Cat cat = new Cat(300, 300, catRightPath);
	private Fruit fruit = new Fruit(greenApplePath);
	// the reason I did not use RandomX and random Y in here is that I don't want
	// the fruit and the poison to have the same initial position
	private Poison poison = new Poison(greenPoisonPath);

//	public static void main(String[] args) {
//		MainMenu mm = new MainMenu();
//		Background background = new Background();
//
//	}

	public Background() {
		setFocusable(true);// adding the panel to the frame.
		frame.add(this);// setting the size of the frame to the size of the images
		// these numbers 666 and 689 make for a square frame if you call getWidth and
		// getHeight both should be 650
		frame.setSize(666, 689);
		// setting the close operation so the app stops working even in the background.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		// this line is to prevent user from changing the size as it would break the
		// design.
		frame.setResizable(false);
		addKeyListener(this);

//		Handler handler = new Handler();
//		Timer timer = new Timer(1000, handler);
//		timer.start();
		startMovingRight();
		while (cat.isAlive()) {
			// checks the edges of the cat
			cat.isOnTheEdge();
			cat.doAction();
			fruit.grow();
			poison.grow();
			if (cat.getX() == fruit.getX() && cat.getY() == fruit.getY()) {
				randomX = 50 * rand.nextInt(13);
				randomY = 50 * rand.nextInt(13);
				// we increase the score first because setRandomLocation sets age = 1
				cat.increaseScore(fruit.getAge() * 2);
				fruit.setRandomLocation(randomX, randomY);

			} else if (cat.getX() == poison.getX() && cat.getY() == poison.getY()) {
				randomX = 50 * rand.nextInt(13);
				randomY = 50 * rand.nextInt(13);
				// make cat.decreaseScore
				// set cat.isAlive false if
				cat.increaseScore(-(poison.getAge() * 2));
				poison.setRandomLocation(randomX, randomY);

			}
			// System.out.println("fruit age is: " + fruit.getAge());
			// System.out.print("catY: " + cat.getY() + " catX: " + cat.getX());
			// System.out.println("fruitY: " + fruit.getY() + " fruitX: " + fruit.getX());

			// System.out.println(cat.getScore());
			try {
				Thread.sleep(200);
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
		fruit.draw(g);
		poison.draw(g);
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
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyRelease(KeyEvent.VK_RIGHT);

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

}
