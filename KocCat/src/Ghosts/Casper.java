package Ghosts;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import GuiAndPlayer.Background;

public class Casper extends Drawable {
	private boolean movingDown;
	private boolean movingRight;
	private int counter = 0;

	public Casper(int x, int y) {
		super(x, y);
	}

	@Override
	public void draw(Graphics g) {
		ImageIcon casperImage = new ImageIcon("./src/Images/Casper.png");
		g.drawImage(casperImage.getImage(), getX(), getY(), 50, 50, null);
	}

	/*
	 * The counter is for making Casper move in one direction for a certain amount
	 * of time
	 */
	@Override
	public void doAction() {
		if (counter < 400) {
			if (this.getY() == 0) {
				movingDown = true;

			} else if (this.getY() == 570) {
				movingDown = false;
			}
			if (movingDown) {
				this.setY(this.getY() + 1);
			} else {
				this.setY(this.getY() - 1);
			}
			counter++;
		} else if (counter >= 400) {
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
			counter++;
			if (counter == 800) {
				counter = 0;
			}
		}
		if (checkCollision()) {
			Background.cat.die();
		}
	}

}
/* uncomment this method for diagonal movement of Casper instead of Random */

//	@Override
//	public void doAction() {
//		// TODO Auto-generated method stub
//
//		if (this.getY() == 0) {
//			movingDown = true;
//			// 600 is the width of the screen -50 which is the size of Ash
//		} else if (this.getY() == 570) {
//			movingDown = false;
//		}
//		if (movingDown) {
//			this.setY(this.getY() + 1);
//		} else {
//			this.setY(this.getY() - 1);
//		}
//
//		if (this.getX() == 0) {
//			movingRight = true;
//			// 600 is the width of the screen -50 which is the size of Ash
//		} else if (this.getX() == 600) {
//			movingRight = false;
//		}
//
//		if (movingRight) {
//
//			this.setX(this.getX() + 1);
//		} else {
//
//			this.setX(this.getX() - 1);
//		}
//
//		if (checkCollision()) {
//			Background.cat.die();
//		}
//
//	}
