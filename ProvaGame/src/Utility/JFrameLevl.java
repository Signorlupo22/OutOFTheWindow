package Utility;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;
import WindowLogic.GamePanel;

public class JFrameLevl extends JFrame {
	int numShell;
	private MouseInputs mouseInput;
	private GamePanel gamePanel;
	public JFrameLevl(int numShell, GamePanel gamePanel) {
		
		super.setTitle(numShell + "");
		
		this.numShell = numShell;
		
		this.gamePanel = gamePanel;
		mouseInput = new MouseInputs(numShell, gamePanel);
		
		KeyboardInputs keyListener = new KeyboardInputs(numShell, this.gamePanel);
		
		addKeyListener(keyListener);
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);
	}
	
	public void setSize(Vector2 v, int numSell, GamePanel gamePanel) {
		if(v == null) return;
		this.gamePanel = gamePanel;
		super.setSize(v.getX(), v.getY());
		super.setTitle(numShell + "");		
		KeyboardInputs keyListener = new KeyboardInputs(numShell,this.gamePanel);
		addKeyListener(keyListener);
		
		mouseInput = new MouseInputs(numShell, gamePanel);
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);
	}
	
	public void setLocation(Vector2 v) {
		if(v == null) return; 
		
		super.setLocation(v.getX(), v.getY());

	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.fillRect(10, 10, 10, 10);

	}
}
