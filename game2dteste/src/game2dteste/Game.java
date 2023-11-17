package game2dteste;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {

	
	public static int WIDTH = 640, HEIGHT = 480;
	public static int SCALE = 3;
	public static Personagem personagem;
	public Mundo mundo;
	
	public List<Inimigo> inimigos =new ArrayList<Inimigo>();
	
	public Game () {
		
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		new Spritesheet();
		
		personagem = new Personagem(32,32);
		mundo = new Mundo();
		
		
		
		inimigos.add(new Inimigo(35,35));
	}
	
	
	public void tick() {
		
		personagem.tick();
		
		for(int i =0; i < inimigos.size(); i++ ) {
			inimigos.get(i).tick();
		}
	}
	
	public void render () {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();		
		
		
		//g.setColor(Color.green);		
		//g.fillRect(0,0, WIDTH,HEIGHT);
		g.drawImage(Spritesheet.chao, 0, 0, WIDTH*SCALE,HEIGHT*SCALE, null);
		
		
				
		personagem.render(g);
		mundo.render(g);
		
		for(int i =0; i < inimigos.size(); i++ ) {
			inimigos.get(i).render(g);
		}
		
		bs.show();
		
		
	}
	
	 public static void main (String[] arg) {
		Game game = new Game ();
		JFrame frame = new JFrame();
		
		
		frame.add(game);
		frame.setTitle("CBLIXO");	
		frame.pack();		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		new Thread(game).start();
	 }
	
	
	public void run() {
		
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// 
		if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
			personagem.right = true;
		} 
		else if(e.getKeyCode()== KeyEvent.VK_LEFT) {
			personagem.left = true;
		}
		if(e.getKeyCode()== KeyEvent.VK_UP) {
			personagem.up = true;
		}
		if (e.getKeyCode()== KeyEvent.VK_Z) {
			personagem.shoot = true;
		}
		else if(e.getKeyCode()== KeyEvent.VK_DOWN) {
			personagem.down = true;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
			personagem.right = false;
		} 
		else if(e.getKeyCode()== KeyEvent.VK_LEFT) {
			personagem.left = false;
		}
		if(e.getKeyCode()== KeyEvent.VK_UP) {
			personagem.up = false;
		} 
		else if(e.getKeyCode()== KeyEvent.VK_DOWN) {
			personagem.down = false;
		}
		
		
	}

	
	
	
}
