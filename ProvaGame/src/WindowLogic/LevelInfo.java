package WindowLogic;
import java.lang.Math;

import Utility.Vector2;

import java.awt.*;

public class LevelInfo {
	private ShellLevel shell[];
	private GamePanel panel[];
	int shellCount = 4;
	private Vector2 posOfShell[]= {new Vector2(100,100),new Vector2(500,400),new Vector2(900,700),new Vector2(1400,500),new Vector2(100,100),};
	
	public LevelInfo() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		shell = new ShellLevel[shellCount];
		panel = new GamePanel[shellCount];
		int i = 0;
		for(ShellLevel s : shell) {
			panel[i] = new GamePanel();
			s = new ShellLevel(posOfShell[i].getX() ,posOfShell[i].getY() ,400,400,panel[i],i);
			i++;
		}
	}
	
	
	public void SnapShell() {
		int i = 0;
		for(ShellLevel s : shell) {
			posOfShell[i].setX((int)s.jframe.getLocation().getX());
			posOfShell[i].setY((int)s.jframe.getLocation().getY());
			i++;
			
		}
		
	}
	
	
	public void repaint(){
		for(GamePanel s : panel) {
			s.repaint();
		}
	}
}
