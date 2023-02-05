package WindowLogic;
import java.awt.Graphics;

import javax.swing.*;

import Inputs.KeyboardInputs;
import Utility.Vector2;

public class GamePanel extends JPanel {
	private int frame = 0;
	private long lastCheck = 0;
	private int  xDelta= 100, yDelta = 100;
	
	
	
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
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(xDelta , yDelta , 100, 50);

	}
}
