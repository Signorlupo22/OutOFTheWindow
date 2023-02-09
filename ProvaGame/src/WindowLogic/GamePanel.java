package WindowLogic;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

import Inputs.KeyboardInputs;
import Utility.Vector2;

public class GamePanel extends JPanel {
	private int  xDelta= 100, yDelta = 100;
	
	public GamePanel() {
		setPanelSize();
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

	}
}
