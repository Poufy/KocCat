package Edible;

import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.util.Random;
import javax.swing.ImageIcon;

public class Fruit extends Edibles {
	private int x, y;
	private double age = 1;
	private String image;
	private final String redApplePath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\red_apple.png";
	public final String greenApplePath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\green_apple.png";

	private Random rand = new Random();
	private int randomX = 50 * rand.nextInt(13);
	private int randomY = 50 * rand.nextInt(13);

	public Fruit(int x, int y, String image) {
		try {
			setImage(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setX(x);
		setY(y);
	}

	public void setImage(String image) throws Exception {
		if (image == null) {
			throw new Exception("Enter a valid path");
		} else if (image.equals("")) {
			throw new Exception("Enter the image path");
		}
		this.image = image;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getAge() {
		return age;
	}

	public void draw(Graphics g) {
		ImageIcon fruitImage = new ImageIcon(this.image);
		g.drawImage(fruitImage.getImage(), getX(), getY(), null);
	}

	// this method returns the score to the cat to obtain if it consumes it
	@Override
	public void consumed() {
		this.respawn();
		// return (int) this.age * 5;
	}

	@Override
	public void grow() {
		this.age += 0.25;
		if (this.age >= 5) {
			try {
				this.setImage(redApplePath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		respawn();
	}

	public void respawn() {
		if (this.getAge() >= 10) {
			this.setX(randomX);
			this.setY(randomY);
			try {
				this.setImage(greenApplePath);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.age = 1;
		}

	}

	public void setRandomLocation() {
		this.setX(randomX);
		this.setY(randomY);
	}
}
