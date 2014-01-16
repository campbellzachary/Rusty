package GameState;

import java.awt.Graphics2D;
import TileMap.Background;

public class MenuState extends GameState {
	
	private BackGround bg;
	
	public MenuState(GameStateManager gsm) { // Every game state needs a reference to the gamestate manager
		
		this.gsm = gsm;
		

	}

	public void init() {}
	public void update() {}
	public void draw(Graphics2D g) {}
	public void keyPressed(int k) {}
	public void keyReleased(int k) {}
}
