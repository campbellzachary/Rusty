package GameState;

public abstract class GameState { // Abstract we dont want anyone to use this class but we want to extend off it. Gamestate is a blue print

	protected GameStateManager gsm; // Every game state will reference GameStateManger to use different states
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(java.awt.Graphics2D g);
	public abstract void keyPressed (int k);
	public abstract void keyReleased (int k);
}
