/*
 * motore grafico (ancora non so cosa sia)
 * 
*/




package WindowLogic;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.*;

import Inputs.KeyboardInputs;
import Utility.Vector2;
import static Utility.Constants.PlayerConstants.*;
import static Utility.Constants.Direciotn.*;

public class GamePanel extends JPanel {
	private int  xDelta= 100, yDelta = 100;
	
	private BufferedImage img;
	private BufferedImage[][] animation;
	
	private int aniTick , aniIndex , aniSpeed = 5;
	private int playerAction = IDLE;
	private int playerDir = 0;
	private boolean moving = false;
	public GamePanel() {
		setPanelSize();
		
		importImg();
		
		loadAnimation();
		
	}
	
	private void loadAnimation() { ///metodo per leggere l'immagine del personaggio
		// TODO Auto-generated method stub
		animation = new BufferedImage[2][14];
		for(int j = 0; j < animation.length; j++) {
			for (int i = 0; i < animation[j].length; i++) {
				animation[j][i] = img.getSubimage(i * 151,  j* 191, 151, 192);
			}	
		}
	}

	private void importImg() { ///carica l'immagine del personaggio
		// TODO Auto-generated method stub
		InputStream is = getClass().getResourceAsStream("/Anim.png");
		
		try {
			img = ImageIO.read(is);
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
	
	private void setPanelSize() {
		Dimension size = new Dimension(400,400);
		setMaximumSize(size);
		setMinimumSize(size);
		setPreferredSize(size);
		
	}
	public void paintComponent(Graphics g) { ///aggiornamento della singola shell
		
		super.paintComponent(g);
		
		setAnimation();
		updateAnimationTick();
		updatePos();
		g.drawImage(animation[playerAction][aniIndex], xDelta, yDelta,152 / 3 ,192 / 3,null);
		

	}

	private void updatePos() {
		// TODO Auto-generated method stub
		if(moving) {
			switch (playerDir) {
			case LEFT:
				xDelta -= 1;
				break;
			case UP:
				yDelta -= 1;
				break;
			case RIGHR:
				xDelta += 1;
				break;
			case DOWN:
				yDelta += 1;
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
}
