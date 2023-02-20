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
		case KeyEvent.VK_W:
			lvlInfo.getPlayer().setDireciotn(UP);
			break;
		case KeyEvent.VK_A:
			lvlInfo.getPlayer().setDireciotn(LEFT);
			break;
		case KeyEvent.VK_S:
			lvlInfo.getPlayer().setDireciotn(DOWN);
			break;
		case KeyEvent.VK_D:
			lvlInfo.getPlayer().setDireciotn(RIGHR);
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
		case KeyEvent.VK_A:
		case KeyEvent.VK_S:
		case KeyEvent.VK_D:
			lvlInfo.getPlayer().setMoving(false);
		default:
			break;
		}
	}

}
