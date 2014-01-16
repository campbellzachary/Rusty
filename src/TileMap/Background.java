package TileMap;

import java.awt.image.*;
import javax.imageio.ImageIO;


public class Background {
	
	private BufferedImage image;
	
	private double x; 
	private double y;
	private double dx;
	private double dy;
	
	private double moveScale;
	
	public Background(String s, double ms) {
		
		try {
			image = ImageIO.read(
					getClass().getResourceAsStream(s)
		);
			
		}
		catch (Exception e) {
			
		}
	}

}
