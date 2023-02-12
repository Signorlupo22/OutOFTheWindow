package Entities;

import static Utility.Constants.Direciotn.DOWN;
import static Utility.Constants.Direciotn.LEFT;
import static Utility.Constants.Direciotn.RIGHR;
import static Utility.Constants.Direciotn.UP;
import static Utility.Constants.PlayerConstants.GetSpriteAmount;
import static Utility.Constants.PlayerConstants.IDLE;
import static Utility.Constants.PlayerConstants.RUNNING;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Utility.Vector2;

public class Player extends Entity{
	
	private BufferedImage[][] animation;
	private int aniTick , aniIndex , aniSpeed = 5;
	private int playerAction = IDLE;
	private int playerDir = 0;
	private boolean moving = false;
	
	private Vector2 posOfshell;
	
	Dimension size;
	
	
	public Player(int x, int y) {
		super(x, y);
		size = Toolkit.getDefaultToolkit().getScreenSize(); ///dimensioni dello schermo
		
		loadAnimation();
		
	}
	
	public void update() {
		
		setAnimation();
		updateAnimationTick();
		updatePos();
	}
	
	public void render(Graphics g) {
		g.drawImage(animation[playerAction][aniIndex], x, y,152 / 3 ,192 / 3,null);
	}
	
	private void loadAnimation() { ///metodo per leggere l'immagine del personaggio
		
		// TODO Auto-generated method stub
		InputStream is = getClass().getResourceAsStream("/Anim.png");
		
		try {
			BufferedImage img = ImageIO.read(is);
			
			animation = new BufferedImage[2][14];
			for(int j = 0; j < animation.length; j++) {
				for (int i = 0; i < animation[j].length; i++) {
					animation[j][i] = img.getSubimage(i * 151,  j* 191, 151, 192);
				}	
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		// TODO Auto-generated method stub

	}
	
	
	private void updatePos() {
		// TODO Auto-generated method stub
		if(moving) {
			switch (playerDir) {
			case LEFT:
				x -= 1;
				break;
			case UP:
				y -= 1;
				break;
			case RIGHR:
				x += 1;
				break;
			case DOWN:
				y += 1;
				break;
			default:
				break;
			}
		}
	}

	private void updateAnimationTick() {
		// TODO Auto-generated method stub
		aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex ++;
			
			if(aniIndex >= GetSpriteAmount(playerAction))
				aniIndex = 0;
		}
	}
	
	
	public void setDireciotn(int direciotn) {
		this.playerDir = direciotn;
		moving = true;
	}
	
	public void setMoving(boolean moving ) {
		this.moving = moving;
	}
	public void setAnimation(){
		if(moving)
			playerAction = RUNNING;
		else playerAction = IDLE;
	}
	
	void updatePosOfShell(Vector2 pos) {
		this.posOfshell = pos;
	}
}
