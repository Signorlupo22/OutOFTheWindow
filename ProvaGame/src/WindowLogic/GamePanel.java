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
import MainGame.MainGame;
import Utility.Vector2;
import static Utility.Constants.PlayerConstants.*;
import static Utility.Constants.Direciotn.*;

public class GamePanel extends JPanel {

	private boolean moving = false;
	protected MainGame m;
	public GamePanel() {
		
	}
	public GamePanel(MainGame m) {
		this.m = m;
		setPanelSize();

	}
	private void setPanelSize() {
		Dimension size = new Dimension(400,400);
		setMaximumSize(size);
		setMinimumSize(size);
		setPreferredSize(size);
		
	}
	public void paintComponent(Graphics g) { ///aggiornamento della singola shell
		super.paintComponent(g);
		if(m != null)
			m.render(g);
	}
	
	public MainGame getGame() {
		return m;
	}

}
