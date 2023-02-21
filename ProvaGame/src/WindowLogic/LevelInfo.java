/*
 * 
 * crea le shell per un livello (un oggetto levelinfo per ogni livello)
 * le mette in posizione
 * chiama l'update per ogni shell:
 * 		-aggiorna tutte le shell del suo livello (frame, logica, altro)
 * */

package WindowLogic;
import java.lang.Math;
import java.util.concurrent.Semaphore;

import Entities.Player;
import MainGame.MainGame;
import Utility.Vector2;
import levels.LevelManager;

import java.awt.*;

public class LevelInfo {
	private ShellLevel shell[], editorShell;
	private GamePanel panel[];
	private Thread thread[];
	private EditorMappa editor;
	private LevelManager levelSprite[];
	int shellCount = 3;
	
	int activePlayer = 0;
	boolean entrato[] = {false,false,false,false,false,false};
	
	private Vector2 posOfShell[]= {new Vector2(100,100),new Vector2(500,400),new Vector2(900,700),new Vector2(1400,500),new Vector2(100,100),};
	Dimension size;
	
	Player player[] = new Player[shellCount];
	
	
	public static Semaphore semaphore = new Semaphore(1);
	///ci sar� un costruttore con tutte le varie info (numero di shell)
	
	
	
	public LevelInfo( MainGame m) { ///costruttore di default
		
		size = Toolkit.getDefaultToolkit().getScreenSize(); ///dimensioni dello schermo
		shell = new ShellLevel[shellCount]; ///crea le varie shell
		panel = new GamePanel[shellCount]; ///grafica delle shell (Thomas dice motore grafico e io sorride� e annuir� senza capire)
		levelSprite = new LevelManager[shellCount];
		thread = new Thread[shellCount];
		editor = new EditorMappa(); ///crea una shell editor
		
		
		int i = 0;		///inizializza le shell
		for(ShellLevel s : shell) {
			player[i] = new Player(100,200);
			levelSprite[i] = new LevelManager(m,i);
			panel[i] = new GamePanel(m, player[i], levelSprite[i]); ///inizializza il motore grafico
			shell[i] = new ShellLevel(posOfShell[i].getX() ,posOfShell[i].getY() ,400,400,panel[i],i,this, player[i]);
			
			
			//start ogni singolo thread
			thread[i] = new Thread(panel[i]);
			thread[i].start();
			i++;
		}
		editorShell = new ShellLevel(editor, i,this);
		
		
	}
	
	
	public void SnapShell(int index1 , int index2) {
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
		Vector2 pos = new Vector2(posOfShell[index1].getX() + MainGame.GAME_WIDTH + 10, posOfShell[index1].getY());
		
		shell[index2].jframe.setLocation(pos);
		
		
		//editor shell dovrebbe dire quali sono collegate. sta in basso a dx
		editorShell.jframe.setLocation(size.width - 650,size.height - 500);
	}
	
	
	public void updateGame() {
		//update
		SnapShell(1,2);

	}
	

	public Player getPlayer() {
		if(player[activePlayer].getPostion().getX() > 421 && activePlayer < shellCount - 1) {
			activePlayer++;
			shell[activePlayer].PlayerEntra();
		}else if(player[activePlayer].getPostion().getX() < -46 && activePlayer > 0  ) {
			activePlayer--;
			shell[activePlayer].PlayerEsce();
		}
		return player[activePlayer];

	}
}
