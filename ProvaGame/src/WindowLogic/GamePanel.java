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
	
	private BufferedImage img ,subImage;
	
	public GamePanel() {
		setPanelSize();
		importImg();
	}
	
	private void importImg() {
		// TODO Auto-generated method stub
		InputStream is = getClass().getResourceAsStream("/player_sprites.png");
		
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
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		subImage = img.getSubimage(1*64, 8*40, 64, 40);
		g.drawImage(subImage, xDelta, yDelta,128,80,null);
		

	}
}
