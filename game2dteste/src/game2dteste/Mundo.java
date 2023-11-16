package game2dteste;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Mundo {

	
	public static List<Bloco> blocos = new ArrayList <Bloco>();
	
	public Mundo () {
		for(int xx = 0; xx <15*2; xx++) {
			blocos.add(new Bloco(xx*32,0));
		}
		for(int xx = 0; xx <15*2; xx++) {
			blocos.add(new Bloco(xx*32,480-32));
		}
		for(int yy = 0; yy <15; yy++) {
			blocos.add(new Bloco(0,yy*32));
		}
		for(int yy = 0; yy <15; yy++) {
			blocos.add(new Bloco(640-32,yy*32));
		}
		
	}
	
	
	public static boolean isFree(int x, int y) {
		
		for(int i = 0; i < blocos.size(); i++ ) {
			
			Bloco blocoAtual = blocos.get(i);
			if(blocoAtual.intersects(new Rectangle(x,y,32,32))) {
				return false;
			}
		}
		return true;
	}
	
	
	public void render(Graphics g) {
		
		for(int i = 0; i < blocos.size(); i++ ) {
			
			blocos.get(i).render(g);
			
		}
	}
	
	
}
