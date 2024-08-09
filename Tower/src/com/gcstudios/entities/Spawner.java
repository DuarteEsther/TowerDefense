package com.gcstudios.entities;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.gcstudios.main.Game;

public class Spawner extends Entity{
private int timer = 60;
private int curTimer = 0;
	public Spawner(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		// TODO Auto-generated constructor stub
	}

	public void tick() {
		//criar inimigos
		curTimer ++;
		if(curTimer == timer) {
			//HORA DE CRIAR O INIMIGO 
			curTimer = 2;
			timer = Entity.rand.nextInt(60 -30) + 30; //ORDEM ALEATORIA DO INIMIGO
			Enemy enemy = new Enemy(x,y,16,16,Entity.rand.nextDouble()+Entity.rand.nextInt(2),Entity.ENEMY1_RIGHT); //INIMIGO NO CINZA
			Game.entities.add(enemy);			
		}
	}
	
	public void render(Graphics g) {
	//	g.setColor(Color.red);
	//	g.fillRect((int)x, (int)y, width, height);
	}
}
