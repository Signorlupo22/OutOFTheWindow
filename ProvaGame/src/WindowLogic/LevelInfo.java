/*
 * 
 * crea le shell per un livello (un oggetto levelinfo per ogni livello)
 * le mette in posizione
 * chiama l'update per ogni shell:
 * 		-aggiorna tutte le shell del suo livello (frame, logica, altro)
 * */

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
	
	
	///ci sar� un costruttore con tutte le varie info (numero di shell)
	
	
	
	public LevelInfo() { ///costruttore di default
		size = Toolkit.getDefaultToolkit().getScreenSize(); ///dimensioni dello schermo
		shell = new ShellLevel[shellCount]; ///crea le varie shell
		panel = new GamePanel[shellCount]; ///grafica delle shell (Thomas dice motore grafico e io sorride� e annuir� senza capire)
		editor = new EditorMappa(); ///crea una shell editor
		
		
		int i = 0;		///inizializza le shell
		for(ShellLevel s : shell) {
			panel[i] = new GamePanel(); ///inizializza il motore grafico
			shell[i] = new ShellLevel(posOfShell[i].getX() ,posOfShell[i].getY() ,400,400,panel[i],i);
			i++;
		}
		editorShell = new ShellLevel(editor, i);
	}
	
	
	public void SnapShell() {
		//thomas sta facendo (dovrebbe attaccare le shell una all'altra)
		
		
		
		int i = 0;
		
		//aggiorna il vettore delle poszioni (chiamato ogni frame)
		for(ShellLevel s : shell) {
			if(s != null) {
				posOfShell[i].setX((int)s.jframe.getLocation().getX());
				posOfShell[i].setY((int)s.jframe.getLocation().getY());
				i++; 
			}
		}
		
		//prova dello snap
		Vector2 pos = new Vector2(posOfShell[0].getX() + 405, posOfShell[0].getY());
		
		shell[1].jframe.setLocation(pos);
		
		
		//editor shell dovrebbe dire quali sono collegate. sta in basso a dx
		editorShell.jframe.setLocation(size.width - 650,size.height - 500);
	}
	
	
	public void repaint(){
		
	}
	
	public void updateGame() {
		//update
		//update della grafica di ogni shell
		for(GamePanel s : panel) {
			s.repaint();
		}
		SnapShell();
	}
}
