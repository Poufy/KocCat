package Edible;

import java.awt.Graphics;
import java.util.Random;

import GuiAndPlayer.Background;

public abstract class Edibles {
	private int x, y;
	Random rand = new Random();

	public Edibles(int x, int y) {
		setX(x);
		setY(y);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean checkCollision() {
		// all my images have the size of 50 and in this line of code I surround my
		// images with a "box" with width and height 25 and if the cat comes into that
		// box a collision happens
		if ((this.getX() - 20 <= Background.cat.getX() && Background.cat.getX() <= this.getX() + 20)
				&& (this.getY() - 20 <= Background.cat.getY() && Background.cat.getY() <= this.getY() + 20)) {
			return true;
		}
		return false;
	}

	public abstract void draw(Graphics g);

	public abstract void consumed();

	public abstract void grow();
}
