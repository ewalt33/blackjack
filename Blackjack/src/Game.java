import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1550691097823471818L;

	public static final int WIDTH = 1920, HEIGHT = 1080;

	private Thread thread;
	private boolean running = false;

	public static boolean paused = false;

	private Random r;
	private Handler handler;
	private Spawn spawn;
	private Menu menu;

	public enum STATE {
		Menu, Game, Pause, Help, Settings;
	}

	public static STATE gameState = STATE.Menu;

	public Game() {
		handler = new Handler();
		spawn = new Spawn(handler);
		menu = new Menu(handler);
		new Window(WIDTH, HEIGHT, "Blackjack", this);
		spawn.createDecks(2);
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {

	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(new Color(0, 110, 0));
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(g);
		menu.render(g);
		g.dispose();
		bs.show();
	}

	public static float clamp(float var, int min, int max) {
		if (var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else
			return var;
	}

	public static void main(String args[]) {
		new Game();
	}

}
