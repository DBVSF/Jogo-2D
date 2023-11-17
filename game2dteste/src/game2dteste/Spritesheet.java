package game2dteste;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	public static BufferedImage spritesheet;
	
	public static BufferedImage[] jogador_front;
	
	public static BufferedImage parede_bloco;
	
	public static BufferedImage chao;
	
	public static BufferedImage[] inimigo_front;
	
	
	
	public Spritesheet() {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		jogador_front = new BufferedImage[2];
		jogador_front[0] = Spritesheet.getSprite(0, 11, 16, 16); 
		jogador_front[1] = Spritesheet.getSprite(18, 11, 16, 16); 
		
		
		inimigo_front = new BufferedImage[2];
		inimigo_front[0] = Spritesheet.getSprite(313, 153, 16, 16); 
		inimigo_front[1] = Spritesheet.getSprite(330, 153, 16, 16); 
		
		
		parede_bloco= Spritesheet.getSprite(313, 241, 16, 16);
		chao = Spritesheet.getSprite(273, 241, 16, 16); 
	}
	
	
	public static BufferedImage getSprite(int x,int y, int width, int height) {
		return spritesheet.getSubimage(x,y,width,height);
	}
	
	
	
}
