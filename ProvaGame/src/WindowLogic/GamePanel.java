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
    private Image imageBuffer;
    private Graphics graphicsBuffer;

	private boolean moving = false;
	protected MainGame m;
	private Player p;
	private LevelManager lvlDraw;
	public GamePanel() {
		
		//ALTRO GAME LOOP PER OGNI SHELL CHE SARA UN GAME LOOP 
	}
	public GamePanel(MainGame m, Player p, LevelManager lvlDraw) {
		this.lvlDraw = lvlDraw;
		this.m = m;
		this.p = p;
		setPanelSize();

	}
	private void setPanelSize() {
		Dimension size = new Dimension(MainGame.GAME_WIDTH,MainGame.GAME_HEIGHT);
		setMaximumSize(size);
		setMinimumSize(size);
		setPreferredSize(size);
		
	}
	public synchronized  void paintComponent(Graphics g) { ///aggiornamento della singola shell
		if(g == null) return;
		//System.out.print("a");
		super.paintComponent(g);
		if(lvlDraw != null) {
			lvlDraw.draw(g);
		}
		if(p != null) {
			p.UpdateGraphics(g);
		}
		//System.out.print("bbbbbbbbbbbb");
		//System.out.println("o");

	}
	

	
	public MainGame getGame() {
		return m;
	}
	
	public void update(){
		if(p != null)
			p.update();
	}
	public Player getPlayer() {
		// TODO Auto-generated method stub
		//prendere il player in base alla shell
		return p;
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
						repaint();
						frame++;
						deltaF --;
					}
					
					if(System.currentTimeMillis() - lastCheck >= 1000) {
						lastCheck = System.currentTimeMillis();
						System.out.println("FPS: " +frame + "| UPS : " +updates);
						frame = 0;
						updates = 0;
					}
				}
	}
	

}
