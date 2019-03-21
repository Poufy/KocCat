package GuiAndPlayer;

import java.awt.Graphics;

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

	public abstract void draw(Graphics g);

	public abstract void doAction();

}
