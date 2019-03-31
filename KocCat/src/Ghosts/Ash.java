package Ghosts;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

import GuiAndPlayer.Background;

public class Ash extends Drawable {
	private boolean movingRight = true;

	public Ash(int x, int y) {
		super(x, y);
	}

	@Override
	public void draw(Graphics g) {
		ImageIcon ashImage = new ImageIcon(".\\src\\Images\\Ash.png");
		g.drawImage(ashImage.getImage(), getX(), getY(), 50, 50, null);
	}

	@Override
	public void doAction() {
		if (this.getX() == 0) {
			movingRight = true;
		} else if (this.getX() == 600) {
			movingRight = false;
		}

		if (movingRight) {
			this.setX(this.getX() + 1);
		} else {
			this.setX(this.getX() - 1);
		}
		if (checkCollision()) {
			Background.cat.die();
		}

	}

}
