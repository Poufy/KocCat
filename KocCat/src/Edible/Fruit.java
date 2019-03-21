package Edible;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;

public class Fruit extends Edibles {
	private double age = 1;
	private String image;
	private final String redApplePath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\red_apple.png";
	public final String greenApplePath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\green_apple.png";
	Random rand = new Random();

	public Fruit(String image) {
		
		try {
			setImage(image);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setImage(String image) throws Exception {
		if (image == null) {
			throw new Exception("Enter a valid path");
		} else if (image.equals("")) {
			throw new Exception("Enter the image path");
		}
		this.image = image;
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
				this.setImage(greenApplePath);
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
			this.setImage(greenApplePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.age = 1;
	}
}
