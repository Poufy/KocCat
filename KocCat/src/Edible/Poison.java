package Edible;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;

public class Poison extends Edibles {
	private double age = 1;
	private String image;
	private final String redPoisonPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\red_poison.png";
	public final String greenPoisonPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\green_poison.png";
	Random rand = new Random();

	public Poison( String image) {
		
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

	@Override
	public void grow() {
		this.age += 0.1;
		if (this.age >= 10) {
			try {
				this.setImage(redPoisonPath);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void consumed() {


	}


}
