package Ghosts;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import GuiAndPlayer.Drawable;

public class Casper extends Drawable {
	private Random rand = new Random();
	private boolean movingDown = true;
	private boolean movingRight = true;
	private final String casperPath = "C:\\Users\\MCE\\git\\KocCat\\KocCat\\src\\Images\\Casper.png";

	public Casper(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		ImageIcon dollyImage = new ImageIcon(casperPath);
		g.drawImage(dollyImage.getImage(), getX(), getY(), null);
	}

	// MAKE WIDTH AND HEIGHT PUBLIC
	@Override
	public void doAction() {
		// TODO Auto-generated method stub

		switch (rand.nextInt(2)) {
		case 0:
			if (this.getY() == 0) {
				movingDown = true;
				// 600 is the width of the screen -50 which is the size of Ash
			} else if (this.getY() == 600) {
				movingDown = false;
			}

			if (movingDown) {
				this.setY(this.getY() + 1);
			} else {
				this.setY(this.getY() - 1);
			}
			break;
		case 1:
			if (this.getX() == 0) {
				movingRight = true;
				// 600 is the width of the screen -50 which is the size of Ash
			} else if (this.getX() == 600) {
				movingRight = false;
			}

			if (movingRight) {
				this.setX(this.getX() + 1);
			} else {
				this.setX(this.getX() - 1);
			}
			break;
		}

	}

}
