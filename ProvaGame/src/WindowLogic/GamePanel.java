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

import Entities.Player;
import Inputs.KeyboardInputs;
import MainGame.MainGame;
import Utility.Vector2;
import static Utility.Constants.PlayerConstants.*;
import static Utility.Constants.Direciotn.*;

public class GamePanel extends JPanel {

	private boolean moving = false;
	protected MainGame m;
	private Player p;
	public GamePanel() {
	}
	public GamePanel(MainGame m, Player p) {
		this.m = m;
		this.p = p;
		setPanelSize();

	}
	private void setPanelSize() {
		Dimension size = new Dimension(400,400);
		setMaximumSize(size);
		setMinimumSize(size);
		setPreferredSize(size);
		
	}
	public void paintComponent(Graphics g) { ///aggiornamento della singola shell
		if(g == null) return;
		
		super.paintComponent(g);
		if(p != null) {
			p.update();
			p.UpdateGraphics(g);
		}
		
	}
	
	public MainGame getGame() {
		return m;
	}
	
	public void repaint() {
		paintComponent(getGraphics());
	}
	public Player getPlayer() {
		// TODO Auto-generated method stub
		//prendere il player in base alla shell
		return p;
	}
	

}
