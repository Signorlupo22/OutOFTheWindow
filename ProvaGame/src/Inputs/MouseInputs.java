package Inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Utility.Vector2;
import WindowLogic.EditorMappa;
import WindowLogic.GamePanel;

public class MouseInputs implements MouseListener, MouseMotionListener{
	
	int numShell = 0;
	EditorMappa edit;
	
	public MouseInputs(int num, EditorMappa ed) {
		numShell = num;
		edit = ed;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		edit.mouseMoved(e);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		edit.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		edit.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		edit.mouseReleased(e);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
