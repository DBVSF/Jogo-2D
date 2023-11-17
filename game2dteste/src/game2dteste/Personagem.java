package game2dteste;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Personagem extends Rectangle{

	
	public int spd = 4;
	public boolean right,up,down,left;
	
	public int curAnimation = 0;
	public int curFrames = 0, targetFrames = 15;
	
	public int dir = 1;
	
	public static List <Bala> balas = new ArrayList<Bala>(); 
	
	public boolean shoot = false;
	
	public Personagem (int x, int y) {
		super(x,y,32,32);
	}
	
	public void tick () {
		
		boolean moveu = false;
		
		if(right && Mundo.isFree(x+spd, y)) {
			x+=spd;
			moveu = true;
			dir = 1;
		}else if(left && Mundo.isFree(x-spd, y)) {
			x-=spd;
			moveu = true;
			dir = -1;
		}
		if(up&& Mundo.isFree(x, y-spd)) {
			y-=spd;
			moveu = true;
		}else if(down && Mundo.isFree(x, y+spd)) {
			y+=spd;
			moveu = true;
		}
		
		if (shoot) {
			shoot = false;
			balas.add(new Bala(x,y,dir));
		}
		
		for(int i = 0; i<balas.size(); i++) {
			balas.get(i).tick();
		}
		
		
		if(moveu) {
				
			curFrames++;
			if (curFrames == targetFrames) {
				curFrames = 0;
				curAnimation++;
				if(curAnimation == Spritesheet.jogador_front.length) {
					curAnimation = 0;
				}
				
			}
		}
	}
	
	public void render(Graphics g) {
		//g.setColor(Color.blue);
		//g.fillRect(x,y, width, height);
		g.drawImage(Spritesheet.jogador_front[curAnimation],x,y,32,32,null);
		
		for(int i = 0; i<balas.size(); i++) {
			balas.get(i).render(g);
		}
		
	}
	
	
}
