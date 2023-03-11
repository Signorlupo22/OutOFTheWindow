/*
 * 
 * crea le shell per un livello (un oggetto levelinfo per ogni livello)
 * le mette in posizione
 * chiama l'update per ogni shell:
 * 		-aggiorna tutte le shell del suo livello (frame, logica, altro)
 * */

package WindowLogic;
import java.util.concurrent.Semaphore;

import Entities.Player;
import MainGame.MainGame;
import Utility.Vector2;
import levels.LevelManager;

import java.awt.*;

public class LevelInfo {
	//Sinsgole shell con le informazioni delle porte pos del player ecc|| editor shell quella dove attachi la shell
	private ShellLevel shell[], editorShell,timer;
	private EditorMappa editor;
	//motore grafico di ogni shell infatti dentro ad ogni ce un thread
	private GamePanel panel[];
	//thread dell game panel
	private Thread thread[];
	//disegnare il livello e infomazioni sulle collsioni
	private LevelManager levelSprite[];
	//quante shell ci sono su un livello
	private int shellCount = 4;
	//in che shell il player è
	int activePlayer = 0;
	//poszione di ogni singola shell
	private Vector2 posOfShell[];
	//dimesione dello schermo 
	Dimension size;
	//Vettore di player in ongi shell ci va un player
	Player player[];
	//semaforo per accedere alle imamgine un thread alla volta
	public static Semaphore semaphore = new Semaphore(1);

	int tryCange = -1;		
	int tryCange2 = -1;
	
	
	public LevelInfo( MainGame m, int shellCoutn, Vector2[] pos, int numLevel, int levelnum) { ///costruttore di default
		
		this.shellCount = shellCoutn;
		this.posOfShell = pos;

		size = Toolkit.getDefaultToolkit().getScreenSize(); ///dimensioni dello schermo
		
		//Iniziallizo le shell,thread, ecc.
		shell = new ShellLevel[shellCount]; ///crea le varie shell
		panel = new GamePanel[shellCount]; ///grafica delle shell (Thomas dice motore grafico e io sorride� e annuir� senza capire)
		levelSprite = new LevelManager[shellCount]; // disegnatore di livello
		thread = new Thread[shellCount]; //inizillizo il thread
		editor = new EditorMappa(shellCount); ///crea una shell editor
		player = new Player[shellCoutn];
		
		
		
		int i = 0;		///inizializza le shell
		for(ShellLevel s : shell) {
			player[i] = new Player(100,200,(int)(152 / 10 * MainGame.SCALE),(int)(191 / 10 * MainGame.SCALE) );
			levelSprite[i] = new LevelManager(i, numLevel);
			panel[i] = new GamePanel(player[i], levelSprite[i], i+1); ///inizializza il motore grafico
			shell[i] = new ShellLevel(posOfShell[i].getX() ,posOfShell[i].getY() ,400,400,panel[i],i,this, player[i], i, levelnum);
			
			
			//start ogni singolo thread
			thread[i] = new Thread(panel[i]);
			thread[i].start();
			i++;
		} 
		
		editorShell = new ShellLevel(editor, i,this);
		//timer = new ShellLevel();
		
		
	}
	
	
	public void SnapShell(int index1 , int index2) {
		if(index1 == -1 || index2 == -1 || index1 == index2) return;
		
		int i = 0;
		//aggiorna il vettore delle poszioni (chiamato ogni frame)
		for(ShellLevel s : shell) {
			if(s != null) {
				posOfShell[i].setX((int)s.jframe.getLocation().getX());
				posOfShell[i].setY((int)s.jframe.getLocation().getY());
				i++; 
			}
		}
		Vector2 pos = new Vector2(posOfShell[index1].getX() + MainGame.GAME_WIDTH + 30, posOfShell[index1].getY());
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
		setEntery();
		
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
	
	
	public void setEntery() {
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
		
		CloseAllEntery();
		
		try {
			tryCange2 = editor.getCollegamenti().getX();			
		} catch (Exception e) {
			tryCange2 = -1;
		}
		
	}
	
	
	void CloseAllEntery() {
		int i = 0;
		// il resto deve chiudere tutte le entrate quindi 
		for(Player p : player) {
			if(editor.getCollegamenti().getX()!= i && editor.getCollegamenti().getY()!= i) {
				if(p != null) {
					p.setHasEntery(false);
					p.setHasExit(false);
					
				}
			}
			i++;
		}
		//se clicca sue volte la stessa shell si scollega
		if(editor.getCollegamenti().getX() == editor.getCollegamenti().getY()) {
			player[editor.getCollegamenti().getX()].setHasEntery(false);
			player[editor.getCollegamenti().getX()].setHasExit(false);
		}
	}
}
