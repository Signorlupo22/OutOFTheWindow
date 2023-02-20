package Utility;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;
import WindowLogic.EditorMappa;
import WindowLogic.GamePanel;
import WindowLogic.LevelInfo;

public class JFrameLevl extends JFrame {
	int numShell;
	private MouseInputs mouseInput;
	private GamePanel gamePanel;
	private LevelInfo lvlInfo;
	public JFrameLevl(int numShell, GamePanel gamePanel, LevelInfo lvlInfo) {
		
		super.setTitle(numShell + "");
		
		this.numShell = numShell;
		
		this.gamePanel = gamePanel;
		this.lvlInfo = lvlInfo;
		
		mouseInput = new MouseInputs(numShell, gamePanel);
		
		KeyboardInputs keyListener = new KeyboardInputs(numShell, this.gamePanel, lvlInfo);
		
		addKeyListener(keyListener);
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);
		
	}
	
	
	
	public void setSize(Vector2 v, int numSell, GamePanel gamePanel,LevelInfo lvlInfo) {
		if(v == null) return;
		this.gamePanel = gamePanel;
		super.setSize(v.getX(), v.getY());
		super.setTitle(numShell + "");		
		KeyboardInputs keyListener = new KeyboardInputs(numShell,this.gamePanel,lvlInfo);
		addKeyListener(keyListener);
		this.lvlInfo = lvlInfo; 
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
