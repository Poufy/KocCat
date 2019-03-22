package Ghosts;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import GuiAndPlayer.Background;
public class Dolly extends Drawable {
	private boolean movingDown = true;
	public Dolly(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		ImageIcon dollyImage = new ImageIcon(getClass().getResource("Dolly.png"));
		g.drawImage(dollyImage.getImage(), getX(), getY(), null);
	}

	// MAKE WIDTH AND HEIGHT PUBLIC
	@Override
	public void doAction() {
		// TODO Auto-generated method stub
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
		if (checkCollision()) {
			Background.cat.die();
		}

	}

}
