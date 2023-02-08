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
			shell[i] = new ShellLevel(posOfShell[i].getX() ,posOfShell[i].getY() ,400,400,panel[i],i);
			i++;
		}
	}
	
	
	public void SnapShell() {
		//dovresti capirlo dal nome
		
		int i = 0;
		
		//aggiorna il vettore delle poszioni
		for(ShellLevel s : shell) {
			if(s != null) {
				posOfShell[i].setX((int)s.jframe.getLocation().getX());
				posOfShell[i].setY((int)s.jframe.getLocation().getY());
				i++; 
			}
		}
		
		
		//se sono in un range fare lo snap
		
		
		//for(int c = 0; c < shellCount; c++) {
		//	for(int j = 0; j < shellCount; j++) {
		//		if(posOfShell[c].equals(posOfShell[j], new Vector2(shell[j].jframe.getWidth()+ 10,shell[j].jframe.getHeight() + 10)) && c != j){
		//			Vector2 pos = new Vector2(posOfShell[c].getX() + 400, posOfShell[c].getY());
		//			shell[j].jframe.setLocation(pos);
		//		}
		//	}
		//}
		Vector2 pos = new Vector2(posOfShell[0].getX() + 400, posOfShell[0].getY());
		shell[1].jframe.setLocation(pos);
		
	}
	
	
	public void repaint(){
		
		//update
		for(GamePanel s : panel) {
			s.repaint();
		}
		
		
		SnapShell();
	}
}
