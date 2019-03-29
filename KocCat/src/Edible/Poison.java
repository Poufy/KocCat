package Edible;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;

import GuiAndPlayer.Background;

public class Poison extends Edibles {
	private double age = 1;
	private String image;
	private final String redPoisonPath = ".\\src\\Images\\red_poison.png";
	public final String greenPoisonPath = ".\\src\\Images\\green_poison.png";
	Random rand = new Random();

	public Poison(int x, int y, String image) {
		super(x, y);
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
		int width = 35 + (int) this.age * 2;
		if(width > 50) 
			width = 50;
		g.drawImage(fruitImage.getImage(), getX(), getY(),width , width, null);
	}

	@Override
	public void grow() {
		this.age += 0.005;
		if (this.age >= 10) {
			try {
				this.setImage(redPoisonPath);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		consumed();
	}

	public void consumed() {
		if (checkCollision()) {
			Background.cat.decreaseScore((int)this.age * 10);
		}
	}

}
