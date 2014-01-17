package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import TileMap.Background;

public class MenuState extends GameState {
	
	private Background bg;
	private int currentChoice = 0;
	private String[] options = {
			"Start",
			"Help",
			"Quit"
	};
	
	private Color titleColor;
	private Font titleFont;
	private Font font;
	
	public MenuState(GameStateManager gsm) { // Every game state needs a reference to the gamestate manager
		
		this.gsm = gsm;
		
		try {
			bg = new Background("/Background/menubg.gift", 1);

	}
		catch(Exception e) {
			e.printStackTrace();
		}
		}

	public void init() {}
	public void update() {}
	public void draw(Graphics2D g) {}
	public void keyPressed(int k) {}
	public void keyReleased(int k) {}
}
