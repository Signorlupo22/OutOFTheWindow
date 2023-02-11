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

public class GamePanel extends JPanel {
	private int  xDelta= 100, yDelta = 100;
	
	private BufferedImage img;
	private BufferedImage[] idleAnim;
	
	private int aniTick , aniIndex , aniSpeed = 15;
	public GamePanel() {
		setPanelSize();
		
		importImg();
		
		loadAnimation();
		
	}
	
	private void loadAnimation() { ///metodo per leggere l'immagine del personaggio
		// TODO Auto-generated method stub
		idleAnim = new BufferedImage[5];
		
		for (int i = 0; i < idleAnim.length; i++) {
			idleAnim[i] = img.getSubimage(i * 150, 0, 150, 210);
		}
	}

	private void importImg() { ///carica l'immagine del personaggio
		// TODO Auto-generated method stub
		InputStream is = getClass().getResourceAsStream("/idle.png");
		
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

	public void ChangeXdelta(int value) { 
		this.xDelta += value;
	}
	public void ChangeYdelta(int value) {
		this.yDelta += value;

	}
	
	
	public void setPosMouse(Vector2 pos) {
		this.xDelta = pos.getX();
		this.yDelta = pos.getY();
		
	}
	private void setPanelSize() {
		Dimension size = new Dimension(400,400);
		setMaximumSize(size);
		setMinimumSize(size);
		setPreferredSize(size);
		
	}
	public void paintComponent(Graphics g) { ///aggiornamento della singola shell
		
		super.paintComponent(g);
		updateAnimationTick();
		g.drawImage(idleAnim[aniIndex], xDelta, yDelta,150 / 3,210 / 3,null);
		

	}

	private void updateAnimationTick() {
		// TODO Auto-generated method stub
		aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex ++;
			
			if(aniIndex >= idleAnim.length)
				aniIndex = 0;
		}
		
		
	}
}
