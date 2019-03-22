package Ghosts;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

import GuiAndPlayer.Background;
import GuiAndPlayer.Drawable;

public class Ash extends Drawable {
	private Random rand = new Random();
	private boolean movingRight = true;
	private final String ashPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\Ash.png";

	public Ash(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		ImageIcon ashImage = new ImageIcon(ashPath);
		g.drawImage(ashImage.getImage(), getX(), getY(), null);
	}

	// MAKE WIDTH AND HEIGHT PUBLIC
	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		if (this.getX() == 0) {
			movingRight = true;
			//600 is the width of the screen -50 which is the size of Ash
		} else if (this.getX() == 600) {
			movingRight = false;
		}

		if (movingRight) {
			this.setX(this.getX() + 1);
		} else {
			this.setX(this.getX() - 1);
		}

	}

}
