/*
 * motore grafico (ancora non so cosa sia)
 * 
*/




package swingProva;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;

import Utility.LoadSave;


public class GamePanel extends JPanel {

	private boolean moving = false;
	
	public GamePanel() {	
	}
	private void setPanelSize() {
		Dimension size = new Dimension(400,400);
		setMaximumSize(size);
		setMinimumSize(size);
		setPreferredSize(size);
	}
	
	public void paintLogoMenu(int x, int y, int width, int height) {
		super.paintComponent(getGraphics());
		BufferedImage img = LoadSave.GetSpriteAtlas("LogoConGriglia.png");
		getGraphics().drawImage(img, x, y, width, height, null);
	}
	
	public void paintPlay(int x, int y, int width, int height) {
		super.paintComponent(getGraphics());
		BufferedImage img = LoadSave.GetSpriteAtlas("play.png");
		getGraphics().drawImage(img, x, y, width, height, null);
	}
	public void paintSceltaLevel(int x, int y, int width, int height, int choose) {
		super.paintComponent(getGraphics());
		BufferedImage img = null;
		
		//while(img.i) {
			switch(choose) {
			case 1:
				img = LoadSave.GetSpriteAtlas("livello1.png");
				break;
			case 2:
				img = LoadSave.GetSpriteAtlas("livello2.png");
				break;
			case 3:
				img = LoadSave.GetSpriteAtlas("livello3.png");
				break;
			}
		//}
			
		
		getGraphics().drawImage(img, x, y, width, height, null);
	}
	
}
