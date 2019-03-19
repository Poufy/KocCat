package GuiAndPlayer;

import javax.swing.JOptionPane;

public class Cat extends Drawable {
	private int score, x, y;
	private String image;
	private boolean isAlive = true;

	public Cat(int x, int y, String image) {
		setImage(image);
		setX(x);
		setY(y);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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

	public void setImage(String image) {
		if (image == null) {
			JOptionPane.showMessageDialog(null, "Please enter a valid String");
		}
		this.image = image;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
