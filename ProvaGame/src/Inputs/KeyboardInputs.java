package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import WindowLogic.GamePanel;

import static Utility.Constants.Direciotn.*;
public class KeyboardInputs implements KeyListener{
	private int numShell = 0;
	private GamePanel gamePanel;
	public KeyboardInputs(int numShell, GamePanel gamepanel) {
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
			gamePanel.setDireciotn(UP);
			break;
		case KeyEvent.VK_A:
			gamePanel.setDireciotn(LEFT);
			break;
		case KeyEvent.VK_S:
			gamePanel.setDireciotn(DOWN);
			break;
		case KeyEvent.VK_D:
			gamePanel.setDireciotn(RIGHR);
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
			gamePanel.setMoving(false);
		default:
			break;
		}
	}

}
