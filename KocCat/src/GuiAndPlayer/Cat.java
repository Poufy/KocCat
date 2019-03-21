package GuiAndPlayer;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Cat extends Drawable {
	private int  x, y, direction;
	private double score;
	private String image;
	private boolean isAlive = true, rightBlocked = false, leftBlocked = false, upBlocked = false, downBlocked = false;

	public Cat(int x, int y, String image) {
		try {
			setImage(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setX(x);
		setY(y);
	}

	public double getScore() {
		return score;
	}

	public void increaseScore(double score) {
		this.score += score;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
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

	public void setImage(String image) throws Exception {
		if (image == null) {
			throw new Exception("Enter a valid String");
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
				this.setX(this.getX() + 50);
			//System.out.println(this.getX());
			//System.out.println(rightBlocked);
			break;
		case 2:
			if (!leftBlocked)
				this.setX(this.getX() - 50);

			break;
		case 3:
			if (!upBlocked)
			this.setY(this.getY() - 50);

			break;
		case 4:
			if (!downBlocked)
			this.setY(this.getY() + 50);

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
		if (this.getX() == 600)
			rightBlocked = true;
		else
			rightBlocked = false;
		if (this.getX() == 0)
			leftBlocked = true;
		else
			leftBlocked = false;
		if (this.getY() == 0)
			upBlocked = true;
		else
			upBlocked = false;
		if (this.getY() == 600)
			downBlocked = true;
		else
			downBlocked = false;
	}

}
