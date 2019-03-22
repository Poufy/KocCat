package Ghosts;

import java.awt.Graphics;

import GuiAndPlayer.Background;
import GuiAndPlayer.Cat;

public abstract class Drawable {
	private int x, y;

	public Drawable(int x, int y) {
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
		// images with a "box" with width and height 35 and if the cat comes into that
		// box a collision happens
		if ((this.getX() - 25 <= Background.cat.getX() && Background.cat.getX() <= this.getX() + 25)
				&& (this.getY() - 25 <= Background.cat.getY() && Background.cat.getY() <= this.getY() + 25)) {
			return true;
		}
		return false;
	}

	public abstract void draw(Graphics g);

	public abstract void doAction();

}
