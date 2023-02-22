package Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public abstract class Entity {
	protected int x , y;
	protected int width, height;
	protected Rectangle2D.Float hitbox;
	
	public Entity(int x, int y,int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	protected void drawHitBox(Graphics g) {
		//hitbox
		g.setColor(Color.pink);
		g.drawRect((int)hitbox.x, (int)hitbox.y, (int)hitbox.width,(int) hitbox.height);
	}
	
	protected void initHitbox(float x,float y , float  width, float height) {
		hitbox = new Rectangle2D.Float((int)x, (int)y, width, height);
	}
	
	protected void updateHitbox() {
		hitbox.x = (int)x;
		hitbox.y = (int)y;
	}
	
	public Rectangle2D.Float getHitbox() {
		return hitbox;
	}
}
