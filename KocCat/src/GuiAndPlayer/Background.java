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
import javax.swing.WindowConstants;

import Edible.Edibles;
import Edible.Fruit;
import Edible.Poison;
import Ghosts.Ash;
import Ghosts.Casper;
import Ghosts.Dolly;
import Ghosts.Drawable;

public class Background extends JPanel implements KeyListener, Runnable {
	public static final int width = 650;
	public static final int height = 650;
	private final String catUpPath = ".\\src\\Images\\cat_up.png";
	private final String catDownPath = ".\\src\\Images\\cat_down.png";
	private final String catRightPath = ".\\src\\Images\\cat_right.png";
	private final String catLeftPath = ".\\src\\Images\\cat_left.png";
	private final String greenApplePath = ".\\src\\Images\\green_apple.png";
	private final String greenPoisonPath = ".\\src\\Images\\green_poison.png";
	private Random rand = new Random();
	private JFrame frame = new JFrame("KocCat");
	private ImageIcon background = new ImageIcon(".\\src\\Images\\background1.png");
	private ImageIcon gameOver = new ImageIcon(".\\src\\Images\\Game over.jpg");
	public static Cat cat = new Cat(300, 300);
	ArrayList<Drawable> objects = new ArrayList<Drawable>();
	ArrayList<Edibles> edibleObjects = new ArrayList<Edibles>();

	public Background() {

		setFocusable(true);
		frame.add(this);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		// check if the numbers of ghosts is divisible by 3 so if we have 15 as input, for example, we
		// spawn 5 of each type
		if (MainMenu.numbers[2] % 3 == 0) {
			fillArrayEvenly(MainMenu.numbers[2]);
		} else {
			fillArrayRandomly();
		}
		addKeyListener(this);
		startMovingRight();
	}

	/*
	 * This is the main running method for the program from the interface runnable
	 * to run the GUI on a separate thread.
	 */
	@Override
	public void run() {
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
				Thread.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
		background.setImage(gameOver.getImage());
	}

	/*
	 * This method first draws the background and then draws every object on the
	 * screen
	 */
	public void paint(Graphics g) {
		// painting the background with the image we have
		g.drawImage(background.getImage(), 0, 0, 650, 650, null);
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).draw(g);
		}
		for (int i = 0; i < edibleObjects.size(); i++) {
			edibleObjects.get(i).draw(g);
		}
		g.drawString("Score: " + cat.getScore(), 15, 15);
	}

	/*
	 * In this method we fill the array of objects we have with random objects
	 * within random bounds(from 0 to getWidth()-50) for the x Axis and from 0 to
	 * getHeight()-50 for the Y axis
	 */
	private void fillArrayRandomly() {
		objects.add(cat);
		for (int i = 0; i < MainMenu.numbers[0]; i++) {
			edibleObjects
					.add(new Poison(rand.nextInt(getWidth() - 50), rand.nextInt(getHeight() - 50), greenPoisonPath));
		}
		for (int i = 0; i < MainMenu.numbers[1]; i++) {
			edibleObjects.add(new Fruit(rand.nextInt(getWidth() - 50), rand.nextInt(getHeight() - 50), greenApplePath));
		}
		for (int i = 0; i < MainMenu.numbers[2]; i++) {
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

	}

	private void fillArrayEvenly(int numberOfEachGhost) {
		objects.add(cat);
		for (int i = 0; i < MainMenu.numbers[2] / 3; i++) {
			objects.add(new Ash(rand.nextInt(getWidth() - 50), rand.nextInt(getHeight() - 50)));
			objects.add(new Dolly(rand.nextInt(getWidth() - 50), rand.nextInt(getHeight() - 50)));
			objects.add(new Casper(rand.nextInt(getWidth() - 50), rand.nextInt(getHeight() - 50)));
		}
		for (int i = 0; i < MainMenu.numbers[1]; i++) {
			edibleObjects.add(new Fruit(rand.nextInt(getWidth() - 50), rand.nextInt(getHeight() - 50), greenApplePath));
		}
		for (int i = 0; i < MainMenu.numbers[0]; i++) {
			edibleObjects
					.add(new Poison(rand.nextInt(getWidth() - 50), rand.nextInt(getHeight() - 50), greenPoisonPath));
		}
	}

	@Override
	/*
	 * I used an Enum class to manage some variables (RIGHT, LEFT, UP, DOWN) to
	 * change the movement of the cat
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			cat.setDirection(Directions.RIGHT);
			try {
				cat.setImage(catRightPath);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			cat.setDirection(Directions.LEFT);
			try {
				cat.setImage(catLeftPath);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			cat.setDirection(Directions.UP);
			try {
				cat.setImage(catUpPath);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			cat.setDirection(Directions.DOWN);
			try {
				cat.setImage(catDownPath);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		// this line is for exiting the game with only the escape button
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
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
	 * moving right away
	 */
	private void startMovingRight() {
		try {
			Robot robot = new Robot();
			// Simulate a key press
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyRelease(KeyEvent.VK_RIGHT);

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

//	private void endGame(Graphics g) {
//		g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
//	}

}
