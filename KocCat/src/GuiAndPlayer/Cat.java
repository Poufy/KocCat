package GuiAndPlayer;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Ghosts.Drawable;

public class Cat extends Drawable {
	private int direction;
	private int score;
	private String image;
	private boolean isAlive = true, rightBlocked = false, leftBlocked = false, upBlocked = false, downBlocked = false;

	public Cat(int x, int y) {
		super(x, y);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void increaseScore(int score) {
		this.score += score;
	}

	public void decreaseScore(int score) {
		this.score -= score;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	// this method is for changing the image when changing directions.
	public void setImage(String image) throws Exception {

		if (image.equals("") || image == null) {
			throw new Exception("Enter the correct image path");
		}
		this.image = image;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		ImageIcon catImage = new ImageIcon(this.image);
		g.drawImage(catImage.getImage(), getX(), getY(), null);
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		switch (direction) {
		case 1:
			if (!rightBlocked)
				this.setX(this.getX() + 1);
			// System.out.println(this.getX());
			// System.out.println(rightBlocked);
			break;
		case 2:
			if (!leftBlocked)
				this.setX(this.getX() - 1);

			break;
		case 3:
			if (!upBlocked)
				this.setY(this.getY() - 1);

			break;
		case 4:
			if (!downBlocked)
				this.setY(this.getY() + 1);

			break;
		}

	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void isOnTheEdge() {
		if (this.getX() >= 600)
			rightBlocked = true;
		else
			rightBlocked = false;
		if (this.getX() <= 0)
			leftBlocked = true;
		else
			leftBlocked = false;
		if (this.getY() <= 0)
			upBlocked = true;
		else
			upBlocked = false;
		if (this.getY() >= 600)
			downBlocked = true;
		else
			downBlocked = false;
	}
	//the loop runs as long as the score is >= 0 so this stops the game
	public void die() {
		this.score = -1;
	}
}
