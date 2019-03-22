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
import Ghosts.Ash;
import Ghosts.Casper;
import Ghosts.Dolly;

public class Background extends JPanel implements KeyListener {
	public final int width = 650;
	public final int height = 650;
	private final String catUpPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\cat_up.png";
	private final String catDownPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\cat_down.png";
	private final String catRightPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\cat_right.png";
	private final String catLeftPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\cat_left.png";
	private final String backgroundPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\background1.png";
	// try to make images public and delete from poison and fruit class
	private final String greenApplePath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\green_apple.png";
	private final String greenPoisonPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\green_poison.png";
	private Random rand = new Random();
	private JFrame frame = new JFrame("KocCat");
	private ImageIcon background = new ImageIcon(backgroundPath);
	private Cat cat = new Cat(300, 300);
	private Fruit fruit = new Fruit(greenApplePath);
	private Ash ash = new Ash(50 * rand.nextInt(13), 50 * rand.nextInt(13));
	private Dolly dolly = new Dolly(50 * rand.nextInt(13), 50 * rand.nextInt(13));
	private Casper casper = new Casper(50 * rand.nextInt(13), 50 * rand.nextInt(13));
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
		frame.setSize(655, 678);
		// System.out.println(frame.getWidth());
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
		while (cat.getScore() >= 0) {
			// this method only gets called if isAlive is false to stop the loop
			// checks the edges of the cat
			cat.isOnTheEdge();
			cat.doAction();
			ash.doAction();
			dolly.doAction();
			casper.doAction();
			fruit.grow();
			poison.grow();
			applyCollision();
			System.out.println(cat.getScore());

			// System.out.println("fruit age is: " + fruit.getAge());
			// System.out.print("catY: " + cat.getY() + " catX: " + cat.getX());
			// System.out.println("fruitY: " + fruit.getY() + " fruitX: " + fruit.getX());

			// System.out.println(cat.getScore());
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
		// drawing the squares
//		for (int i = 0; i < this.getHeight(); i += 50) {
//			for (int j = 0; j < this.getWidth(); j += 50) {
//				g.drawRect(j, i, 50, 50);
//			}
//		}

		fruit.draw(g);
		poison.draw(g);
		ash.draw(g);
		dolly.draw(g);
		casper.draw(g);
		cat.draw(g);
	}

	public void applyCollision() {
		// collision with fruits and poison
		// 50 is the width and height of each image
		if (checkCollision(cat.getX(), cat.getY(), fruit.getX(), fruit.getY())) {
			// we increase the score first because setRandomLocation sets age = 1
			cat.increaseScore(fruit.getAge() * 5);
			fruit.setRandomLocation(rand.nextInt(600), rand.nextInt(600));
		} else if (checkCollision(cat.getX(), cat.getY(), poison.getX(), poison.getY())) {
			// make cat.decreaseScore
			// set cat.isAlive false if
			cat.decreaseScore(poison.getAge() * 10);

		} else if (checkCollision(cat.getX(), cat.getY(), ash.getX(), ash.getY())) {
			cat.die();
		} else if (checkCollision(cat.getX(), cat.getY(), dolly.getX(), dolly.getY())) {
			cat.die();
		} else if (checkCollision(cat.getX(), cat.getY(), casper.getX(), casper.getY())) {
			cat.die();
		}
	}

	public boolean checkCollision(int xCat, int yCat, int xObject, int yObject) {
		// all my images have the size of 50 and in this line of code I surround my
		// images with a "box" with width and height 35 and if the cat comes into that
		// box a collision happens
		if ((xObject - 35 <= xCat && xCat <= xObject + 35) && (yObject - 35 <= yCat && yCat <= yObject + 35)) {
			return true;
		}
		return false;
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
