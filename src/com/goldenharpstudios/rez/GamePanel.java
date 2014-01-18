package com.goldenharpstudios.rez;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import GameState.GameStateManager;

@SuppressWarnings("serial")

public class GamePanel extends JPanel implements Runnable, KeyListener{

	// Dimensions

	public static int width = 320; // Static enables "width" to be used in another class. It won't 
	public static int height = 240;
	public static int scale = 2; 

	// Game thread

	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;

	// Image
	private BufferedImage image;
	private Graphics2D g;
	
	// Game State Manager
	private GameStateManager gsm;
	

	public GamePanel() { super();
	setPreferredSize(new Dimension (width * scale, height * scale));
	setFocusable(true);
	requestFocus();

	}
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}

	// To initialise the image

	private void init () {

		image = new BufferedImage (
				width, height, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		running = true;
		
		gsm = new GameStateManager();
		
	}
	
		// Game loop

		public void run() {

			init();
			long start;
			long elapsed;
			long wait;

		while(running) {
			
			start = System.nanoTime();

			update();
			draw();
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			if(wait < 0 ) wait =5;
			
			try {
				Thread.sleep(wait);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			}

		}

		private void update() {
			gsm.update();
		}
		private void draw() {
			gsm.draw(g);
		}
		
		private void drawToScreen() {
			Graphics g2 = getGraphics();
			g2.drawImage(image, 0, 0,width* scale, height * scale, null);
			g2.dispose();
		}

		public void keyTyped(KeyEvent key) {}
		public void keyPressed(KeyEvent key) {
			gsm.keyPressed(key.getKeyCode());
		}
		public void keyReleased(KeyEvent key) {
			gsm.keyReleased(key.getKeyCode());
		}
}