/*
 * motore grafico (ancora non so cosa sia)
 * 
*/




package WindowLogic;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.*;

import Entities.Player;
import Inputs.KeyboardInputs;
import MainGame.MainGame;
import Utility.Vector2;
import levels.LevelManager;

import static Utility.Constants.PlayerConstants.*;
import static Utility.Constants.Direciotn.*;

public class GamePanel extends JPanel implements Runnable {
	int oneTime = 0;
	
	private Player p;
	private LevelManager lvlDraw;
	
	public GamePanel() {
	}
	public GamePanel(Player p, LevelManager lvlDraw) {
		this.lvlDraw = lvlDraw;
		this.p = p;
		setPanelSize(); 
		
	}
	private void setPanelSize() {
		Dimension size = new Dimension(MainGame.GAME_WIDTH,MainGame.GAME_HEIGHT);
		setMaximumSize(size);
		setMinimumSize(size);
		setPreferredSize(size);
		
	}
	public  void paintComponent(Graphics g) { ///aggiornamento della singola shell
		if(g == null) return;
		super.paintComponent(g);
		if(lvlDraw != null) {
			lvlDraw.draw(g);
		}
		if(p != null) {
			//aggiorna il player
			p.UpdateGraphics(g);
		}
	}
	
	public void update(){
		if(p != null)
			p.update();
	}
	public void repaintt() {
		repaint();
	}
	public Player getPlayer() {
		return p;
	}
	public LevelManager getLevelManager() {
		return lvlDraw;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		///modifiche che thomas ha fatto e caricher� al pi� presto
		
				double timePerFrame = 1000000000 / MainGame.FPS_SET;
				double timePerUpdate = 1000000000 / MainGame.UPS_SET;

				long previuosTime = System.nanoTime();
				
				int frame = 0;
				int updates = 0;
				long lastCheck = System.currentTimeMillis();
				
				double deltaU = 0;
				double deltaF = 0;
				
				
				while(true) {
					long currentTime = System.nanoTime();
					
					deltaU += ( currentTime - previuosTime) / timePerUpdate;
					deltaF += ( currentTime - previuosTime) / timePerFrame;
					previuosTime = currentTime;
					
					if(deltaU >= 1) {
						//update
						update();
						updates ++;
						deltaU --;
					}
					if(deltaF >= 1) {
						repaintt();
						frame++;
						deltaF --;
					}
					if(oneTime == 0 && lvlDraw.getCurrentLevel() != null) {
						initClass();
						oneTime++;
					}
					if(System.currentTimeMillis() - lastCheck >= 1000) {
						lastCheck = System.currentTimeMillis();
						//System.out.println("FPS: " +frame + "| UPS : " +updates);
						frame = 0;
						updates = 0;
					}
				}
	}
	
	public void initClass() {
		p.loadLevelData(lvlDraw.getCurrentLevel());
	}
	

}
