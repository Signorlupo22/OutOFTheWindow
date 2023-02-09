package WindowLogic;
import java.lang.Math;

import Utility.Vector2;

import java.awt.*;

public class LevelInfo {
	private ShellLevel shell[], editorShell;
	private GamePanel panel[];
	private EditorMappa editor;
	int shellCount = 3;
	private Vector2 posOfShell[]= {new Vector2(100,100),new Vector2(500,400),new Vector2(900,700),new Vector2(1400,500),new Vector2(100,100),};
	Dimension size;
	
	public LevelInfo() {
		size = Toolkit.getDefaultToolkit().getScreenSize();
		shell = new ShellLevel[shellCount];
		panel = new GamePanel[shellCount];
		editor = new EditorMappa();
		
		
		int i = 0;
		for(ShellLevel s : shell) {
			panel[i] = new GamePanel();
			shell[i] = new ShellLevel(posOfShell[i].getX() ,posOfShell[i].getY() ,400,400,panel[i],i);
			i++;
		}
		editorShell = new ShellLevel(editor, i);
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
		
		//prova dello snap
		Vector2 pos = new Vector2(posOfShell[0].getX() + 410, posOfShell[0].getY());
		
		shell[1].jframe.setLocation(pos);
		
		//Dovrebbe bloccare le dimesioni ma non la blocca (che fastidio)
		//TODO Dimesione
		
		
		//l'ultima shell sta in alto a destra per dire quali sono collegate
		editorShell.jframe.setLocation(size.width - 650,size.height - 500);
	}
	
	
	public void repaint(){
		
		//update
		for(GamePanel s : panel) {
			s.repaint();
		}
		SnapShell();
	}
}
