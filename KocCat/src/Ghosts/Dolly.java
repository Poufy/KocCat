package Ghosts;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import GuiAndPlayer.Background;

public class Dolly extends Drawable {
	private boolean movingDown = true;

	public Dolly(int x, int y) {
		super(x, y);
	}

	@Override
	public void draw(Graphics g) {
		ImageIcon dollyImage = new ImageIcon(".\\src\\Images\\Dolly.png");
		g.drawImage(dollyImage.getImage(), getX(), getY(), 50, 50, null);
	}

	@Override
	public void doAction() {
		if (this.getY() == 0) {
			movingDown = true;
		} else if (this.getY() == 580) {
			movingDown = false;
		}
		if (movingDown) {
			this.setY(this.getY() + 1);
		} else {
			this.setY(this.getY() - 1);
		}
		if (checkCollision()) {
			Background.cat.die();
		}

	}

}
