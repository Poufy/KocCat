package Edible;

import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.util.Random;
import javax.swing.ImageIcon;

public class Poison extends Edibles {
	private int x, y;
	private double age = 1;
	private String image;
	private final String redPoisonPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\red_poison.png";
	public final String greenPoisonPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\green_poison.png";
	Random rand = new Random();

	public Poison(int x, int y, String image) {
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


	@Override
	public void grow() {
		this.age += 0.25;
		if (this.age >= 5) {
			try {
				this.setImage(redPoisonPath);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		consumed();
	}

	/*
	 * In this method I respawn the fruit when its age is 10 and also reinitlize the
	 * random X and Y so the fruit does not spawn in the same location
	 */
	public void consumed() {
		if (this.getAge() >= 10) {
			int randomX = 50 * rand.nextInt(13);
			int randomY = 50 * rand.nextInt(13);
			setRandomLocation(randomX, randomY);
			try {
				this.setImage(greenPoisonPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.age = 1;
		}

	}

	public void setRandomLocation(int randomX, int randomY) {

		this.setX(randomX);
		this.setY(randomY);
		try {
			this.setImage(greenPoisonPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.age = 1;
	}
}
