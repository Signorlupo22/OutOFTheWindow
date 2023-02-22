package WindowLogic;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;

import Inputs.MouseInputs;
import MainGame.MainGame;
import Ui.ShellButton;
import Utility.LoadSave;
import Utility.Vector2;

public class EditorMappa extends GamePanel{
	private BufferedImage bg;
	private ShellButton[] buttons;
	private MouseInputs mouseInput;
	private int shellCount;
	int isFirst = 0;
	boolean oneClick = false;
	Vector2 shellColl;
	public EditorMappa(int shellCount) {
		super();
		setPanelSize();
		importImg();
		this.shellCount = shellCount;
		mouseInput = new MouseInputs(0, this);
		buttons = new ShellButton[shellCount];
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);
		
		requestFocus();
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new ShellButton(200 * i + 100, 200, 0);
		}
	}
	
	
	
	private void importImg() {
		bg = LoadSave.GetSpriteAtlas("Map.png");
	}
	
	private void setPanelSize() {
		Dimension size = new Dimension(650,400);
		setMaximumSize(size);
		setMinimumSize(size);
		setPreferredSize(size);
		
	}
	public void update() {
		int j = 0;
		for(ShellButton b : buttons) {
			int i = b.update();
			repaint();
			if(i == 2 && isFirst == 0 && !oneClick) {
				isFirst = 1;
				oneClick =  true;
				System.out.println("prima shell è: " + j);
				shellColl = new Vector2(j,-1);
			}else if(i == 2 && isFirst == 1 && !oneClick){
				oneClick =  true;
				System.out.println("seconda shell è: " + j);
				shellColl.setY(j);;
				isFirst = 0;
			}
			j++;
		}
	}
	
	public Vector2 getCollegamenti() {
		if(shellColl != null)
			return shellColl;
		return new Vector2(0,-1);
	}
	public void paintComponent(Graphics g) {
		if(g == null) return;
		super.paintComponent(g);
		
		g.drawImage(bg, 0, 0,650,400,null);
		for(ShellButton b : buttons) {
			b.draw(g);
		}

	}


	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		for(ShellButton b: buttons) {
			b.setMouseOver(false);
		}
		
		for(ShellButton b: buttons) {
			if(isIn(e, b)) {
				b.setMouseOver(true);
				break;
			}
		}
		
	}



	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	public void mousePressed(MouseEvent e) {
		for(ShellButton b: buttons) {
			if(isIn(e, b)) {
				b.setMousePressed(true);
				break;
			}
		}
		
	}
	public boolean isIn(MouseEvent e, ShellButton b) {
		return b.getBounds().contains(e.getX(),e.getY());
	}


	public void mouseReleased(MouseEvent e) {
		for(ShellButton b: buttons) {
			if(isIn(e, b)) {
				if(b.isMousePressed()) {
					b.doAction();
					
					break;
				}
			}
		}
		oneClick = false;
		resetButton();
		
	}



	private void resetButton() {
		// TODO Auto-generated method stub
		for(ShellButton b: buttons) {
			b.resetBools();
		}
	}



	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
