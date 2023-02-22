package WindowLogic;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;

import MainGame.MainGame;
import Utility.LoadSave;

public class EditorMappa extends GamePanel {
	private BufferedImage bg;
	
	
	public EditorMappa() {
		setPanelSize();
		importImg();
	}
	
	
	
	private void importImg() {
		bg = LoadSave.GetSpriteAtlas("Map.png");
	}
	
	private void setPanelSize() {
		Dimension size = new Dimension(650,400);
		setMaximumSize(size);
		setMinimumSize(size);
		setPreferredSize(size);
		
	}
	
	
	public void paintComponent(Graphics g) {
		if(g == null) return;
		super.paintComponent(g);
		
		g.drawImage(bg, 0, 0,650,400,null);
		

	}
}
