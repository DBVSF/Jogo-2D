package game2dteste;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	public static BufferedImage spritesheet;
	
	public static BufferedImage jogador_front;
	
	public Spritesheet() {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		jogador_front= Spritesheet.getSprite(0, 11, 16, 16);
	}
	
	
	public static BufferedImage getSprite(int x,int y, int width, int height) {
		return spritesheet.getSubimage(x,y,width,height);
	}
	
	
	
}