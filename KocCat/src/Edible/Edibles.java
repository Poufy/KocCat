package Edible;

import java.util.Random;

public abstract class Edibles {
	private int x, y;
	Random rand = new Random();

	public Edibles() {
		setX(50 * rand.nextInt(13));
		setY(50 * rand.nextInt(13));
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


	public abstract void consumed();

	public abstract void grow();
}
