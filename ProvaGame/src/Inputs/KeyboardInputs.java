package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import WindowLogic.GamePanel;

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
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			gamePanel.ChangeYdelta(-5);
			break;
		case KeyEvent.VK_A:
			gamePanel.ChangeXdelta(-5);
			break;
		case KeyEvent.VK_S:
			gamePanel.ChangeYdelta(5);
			break;
		case KeyEvent.VK_D:
			gamePanel.ChangeXdelta(5);
			break;
		default:
			break;
		}
	}

}
