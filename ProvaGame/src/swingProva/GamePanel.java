/*
 * motore grafico (ancora non so cosa sia)
 * 
*/




package swingProva;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;


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
	public void paintComponentMenu(Graphics g, int x, int y, int width, int height) {
		super.paintComponent(g);
		BufferedImage img = LoadSave.GetSpriteAtlas("LogoConGriglia.png");
		g.drawImage(img, x, y, width, height, null);
	}
	
	public void paintComponent1(Graphics g, int x, int y, int width, int height) {
		super.paintComponent(g);
		BufferedImage img = LoadSave.GetSpriteAtlas("livello1.png");
		g.drawImage(img, x, y, width, height, null);
	}
	public void paintComponent2(Graphics g, int x, int y, int width, int height) {
		super.paintComponent(g);
		BufferedImage img = LoadSave.GetSpriteAtlas("");
		g.drawImage(img, x, y, width, height, null);
	}
	public void paintComponent3(Graphics g, int x, int y, int width, int height) {
		super.paintComponent(g);
		BufferedImage img = LoadSave.GetSpriteAtlas("");
		g.drawImage(img, x, y, width, height, null);
	}
	
	public void paintLogoMenu(int x, int y, int width, int height) {
		paintComponentMenu(getGraphics(),x,y,width,height);
	}
	public void paint1(int x, int y, int width, int height) {
		paintComponent1(getGraphics(),x,y,width,height);
	}
}
