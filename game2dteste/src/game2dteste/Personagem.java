package game2dteste;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Personagem extends Rectangle{

	
	public int spd = 4;
	public boolean right,up,down,left;
	
	public int curAnimation = 0;
	public int curFrames = 0, targetFrames = 15;
	
	
	public Personagem (int x, int y) {
		super(x,y,32,32);
	}
	
	public void tick () {
		if(right && Mundo.isFree(x+spd, y)) {
			x+=spd;
		}else if(left && Mundo.isFree(x-spd, y)) {
			x-=spd;
		}
		if(up&& Mundo.isFree(x, y-spd)) {
			y-=spd;
		}else if(down && Mundo.isFree(x, y+spd)) {
			y+=spd;
		}
		
		curFrames++;
		if (curFrames == targetFrames) {
			curFrames = 0;
			curAnimation++;
			if(curAnimation == Spritesheet.jogador_front.length) {
				curAnimation = 0;
			}
			
		}
		
	}
	
	public void render(Graphics g) {
		//g.setColor(Color.blue);
		//g.fillRect(x,y, width, height);
		g.drawImage(Spritesheet.jogador_front[curAnimation],x,y,32,32,null);
		
	}
	
	
}
