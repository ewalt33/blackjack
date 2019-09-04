import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Menu extends MouseAdapter {

	private Handler handler;
	BufferedImage img = null;
	BufferedImage img2 = null;

	public Menu(Handler handler) {
		this.handler = handler;
		try {
			img = ImageIO.read(new File("res/Joker1.png"));
			img2 = ImageIO.read(new File("res/Joker2.png"));
		} catch (IOException e) {
			System.out.println("Error");
		}

	}

	public void mousePressed(MouseEvent e) {
		int mX = e.getX();
		int mY = e.getY();

		if (Game.gameState == Game.STATE.Menu) {

		}
	}

	public void mouseReleased(MouseEvent e) {

	}

	private boolean mouseOver(int mX, int mY, int x, int y, int width, int height) {
		if (mX > x && mX < x + width) {
			if (mY > y && mY < y + height)
				return true;
			else
				return false;
		} else {
			return false;
		}
	}

	public void tick() {

	}

	public void render(Graphics g) {
		if (Game.gameState == Game.STATE.Menu) {
			int width = 0;
			g.setColor(new Color(110, 0, 0));
			g.setFont(new Font("Helvetica", 1, 200));
			width = g.getFontMetrics().stringWidth("Blackjack");
			g.drawString("Blackjack", (Game.WIDTH - width) / 2, 250);
			rotateCw(img,g,45,300,10);
			rotateCw(img2,g,-45,1450,188);

		}
	}


	public static void rotateCw(BufferedImage img,Graphics g, int d, int x, int y)
	{
		AffineTransform at = AffineTransform.getTranslateInstance(x, y);
		at.rotate(Math.toRadians(d));
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.drawImage(img,at,null);
	}

	
}
