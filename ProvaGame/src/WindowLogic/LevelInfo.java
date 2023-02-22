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
import Inputs.MouseInputs;
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
	int shellCount = 4;
	boolean HasEntery,HasExit;
	
	int activePlayer = 0;
	boolean entrato[] = {false,false,false,false,false,false};
	
	private Vector2 posOfShell[]= {new Vector2(100,100),new Vector2(500,400),new Vector2(900,700),new Vector2(1400,500),new Vector2(100,100),};
	Dimension size;
	
	Player player[] = new Player[shellCount];
	
	//semaforo per accedere alle imamgine un thread alla volta
	public static Semaphore semaphore = new Semaphore(1);
	///ci sar� un costruttore con tutte le varie info (numero di shell) 
	
	
	
	public LevelInfo( MainGame m) { ///costruttore di default
		
		size = Toolkit.getDefaultToolkit().getScreenSize(); ///dimensioni dello schermo
		shell = new ShellLevel[shellCount]; ///crea le varie shell
		panel = new GamePanel[shellCount]; ///grafica delle shell (Thomas dice motore grafico e io sorride� e annuir� senza capire)
		levelSprite = new LevelManager[shellCount];
		thread = new Thread[shellCount];
		editor = new EditorMappa(shellCount); ///crea una shell editor
		
		
		int i = 0;		///inizializza le shell
		for(ShellLevel s : shell) {
			player[i] = new Player(100,200,(int)(152 / 10 * MainGame.SCALE),(int)(191 / 10 * MainGame.SCALE) );
			levelSprite[i] = new LevelManager(m, i);
			panel[i] = new GamePanel(m, player[i], levelSprite[i]); ///inizializza il motore grafico
			shell[i] = new ShellLevel(posOfShell[i].getX() ,posOfShell[i].getY() ,400,400,panel[i],i,this, player[i], i);
			
			
			//start ogni singolo thread
			thread[i] = new Thread(panel[i]);
			thread[i].start();
			i++;
		} 
		editorShell = new ShellLevel(editor, i,this);
		
		
	}
	
	
	public void SnapShell(int index1 , int index2) {
		if(index1 == -1 || index2 == -1) return;
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
		
		
		
	}
	
	
	public void updateGame() {
		//update
		editor.update();
		if(editor.getCollegamenti()!= null &&editor.getCollegamenti().getY() != -1 ) {
			SnapShell(editor.getCollegamenti().getX(),editor.getCollegamenti().getY());
			
		}
		
		//editor shell dovrebbe dire quali sono collegate. sta in basso a dx
		editorShell.jframe.setLocation(size.width - 650,size.height - 500);
	}
	

	public Player getPlayer() {
		int tryCange = -1;		
		try {
			tryCange = editor.getCollegamenti().getY();		
			player[editor.getCollegamenti().getX()].setHasExit(true);
			player[editor.getCollegamenti().getY()].setHasEntery(true);
			
			
			player[editor.getCollegamenti().getY()].setHasExit(false);
			player[editor.getCollegamenti().getX()].setHasEntery(false);
		} catch (Exception e) {
			tryCange = -1;
			player[editor.getCollegamenti().getX()].setHasExit(false);
			player[editor.getCollegamenti().getX()].setHasEntery(false);
		}
		
		int i = 0;
		// il resto deve chiudere tutte le entrate quindi 
		for(Player p : player) {
			if(editor.getCollegamenti().getX()!= i && editor.getCollegamenti().getY()!= i) {
				p.setHasEntery(false);
				p.setHasExit(false);
			}
			i++;
		}
		
		int tryCange2 = -1;
		try {
			tryCange2 = editor.getCollegamenti().getX();			
		} catch (Exception e) {
			tryCange2 = -1;
		}
		
		if(player[activePlayer].getPostion().getX() > 220 * MainGame.SCALE) {

			if(tryCange != -1) {
				player[activePlayer].resetDirBooleans();
				player[activePlayer].resetInAir();
				shell[activePlayer].PlayerEsce();
				activePlayer = tryCange;
				System.out.println(tryCange);
				player[activePlayer].resetInAir();
				shell[activePlayer].PlayerEntra();
								
			}
			
		}else if(player[activePlayer].getPostion().getX() < -32 * MainGame.SCALE ) {
			
			if(tryCange2 != -1) {
				player[activePlayer].resetDirBooleans();
				player[activePlayer].resetInAir();
				shell[activePlayer].PlayerEntra();
				activePlayer = tryCange2;
				System.out.println(tryCange);
				player[activePlayer].resetInAir();
				shell[activePlayer].PlayerEsce();
								
			}
		}
		return player[activePlayer];
		
	}
}
