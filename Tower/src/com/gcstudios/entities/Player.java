package com.gcstudios.entities;


import java.awt.Color;
import java.awt.Graphics;

import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;
import com.gcstudios.main.Sound;



public class Player extends Entity{

	public int xTarget, yTarget;
	public boolean atacando = false;
	
	public Player(int x, int y, int width, int height,double speed,BufferedImage sprite) {
		super(x, y, width, height,speed,sprite);
	}
	
	public void tick(){
		Enemy enemy = null;
		for(int i =0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e instanceof Enemy ) {
				int xEnemy = e.getX();
				int yEnemy = e.getY();
				if(Entity.calculateDistance(this.getX(), this.getY(), xEnemy, yEnemy) < 40) {
				enemy = (Enemy) e;
			}
		}
	}
			
		if(enemy != null) {
			atacando = true;
			xTarget = enemy.getX();
			yTarget = enemy.getY();
			if(Entity.rand.nextInt(100) <30) {
				enemy.vida-=Entity.rand.nextDouble();
			}
		}else {
			atacando = false;
		}
	}
	
	public void render (Graphics g) {
		super.render(g);
		//MOSTRAR ATAQUE AS TORRES
		if(atacando)
			
		{
			g.setColor(Color.red);
			g.drawLine((int)x+6, (int)y+6, xTarget+6, yTarget+6);
			
		}
	}
	


}
