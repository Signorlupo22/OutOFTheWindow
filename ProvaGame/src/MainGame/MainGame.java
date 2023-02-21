package MainGame; ///loop del gioco (chiama se stesso 200 volte al secondo. aggiornamento dello schermo 120 FPS)

import java.awt.Graphics;

import Entities.Player;
import WindowLogic.LevelInfo;

public class MainGame implements Runnable {
	
	
	///thread
	/*
	thread -> esecuzione del programma che va in contemporanea ad altri thread (pi� parti del codice che lavorano allo stesso momento.)
	
	saranno pi� di uno:
		-uno per finestra
		-uno per il timer (forse)
		-in teoria basta	
	
	*/
	
	
	private Thread GameThread;
	public final static int FPS_SET = 100;
	private LevelInfo game1;
	public final static int UPS_SET = 200;
	
	
	public final static int TILE_DEFAULT_SIZE = 18;
	public final static float SCALE = 2.0f;
	public final static int TILES_IN_WIDTH = 12;
	public final static int TILES_IN_HEIGHT = 13;
	public final static int TILES_SIZE = (int)(TILE_DEFAULT_SIZE * SCALE);
	public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
	public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;
	
	public MainGame(){
		game1 = new LevelInfo(this);
		initClasses();
		startGameLoop();
		
	}

	private void initClasses() {
		// TODO Auto-generated method stub
		
	}

	private void startGameLoop(){
		GameThread = new Thread(this); ///crea un nuovo thread
		GameThread.start();	           ///avvia il thread
	}
	

	public void update() {
		if(game1 != null)
			game1.updateGame();
	}
	
	public void render() {

	}

	@Override
	public void run() {  ///funzione del thread che lo fa partire

		///modifiche che thomas ha fatto e caricher� al pi� presto
		
		double timePerFrame = 1000000000 / FPS_SET;
		double timePerUpdate = 1000000000 / UPS_SET;

		long previuosTime = System.nanoTime();
		
		int frame = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();
		
		double deltaU = 0;
		double deltaF = 0;
		while(true) {
			long currentTime = System.nanoTime();
			
			deltaU += ( currentTime - previuosTime) / timePerUpdate;
			deltaF += ( currentTime - previuosTime) / timePerFrame;
			previuosTime = currentTime;
			
			if(deltaU >= 1) {
				//update
				update();
				updates ++;
				deltaU --;
			}
			if(deltaF >= 1) {
				render();
				frame++;
				deltaF --;
			}
			
			if(System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				//System.out.println("FPS: " +frame + "| UPS : " +updates);
				frame = 0;
				updates = 0;
			}
		}
	}

	public Player getPlayer() {
		// TODO Auto-generated method stub
		//prendere il player in base
		return null;
	}
	
	
}	
