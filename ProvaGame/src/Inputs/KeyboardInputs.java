package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import WindowLogic.GamePanel;
import WindowLogic.LevelInfo;

import static Utility.Constants.Direciotn.*;
public class KeyboardInputs implements KeyListener{
	private int numShell = 0;
	private GamePanel gamePanel;
	private LevelInfo lvlInfo;
	
	public KeyboardInputs(int numShell, GamePanel gamepanel,LevelInfo level) {
		this.lvlInfo = level;
		this.numShell = numShell;
		this.gamePanel = gamepanel;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			lvlInfo.getPlayer().setLeft(true);
			break;
		case KeyEvent.VK_D:
			lvlInfo.getPlayer().setRight(true);
			break;
		case KeyEvent.VK_SPACE:
			lvlInfo.getPlayer().setJump(true);
			break;
		default:
			break;
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			lvlInfo.getPlayer().setLeft(false);
			break;

		case KeyEvent.VK_D:
			lvlInfo.getPlayer().setRight(false);
			break;
		case KeyEvent.VK_SPACE:
			lvlInfo.getPlayer().setJump(false);
			break;
		}
	}

}
