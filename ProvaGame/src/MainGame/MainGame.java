package MainGame; ///loop del gioco (chiama se stesso 200 volte al secondo. aggiornamento dello schermo 120 FPS)

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
	private final int FPS_SET = 120;
	private LevelInfo game1;
	private final int UPS_SET = 200;
	public MainGame(){
		game1 = new LevelInfo();
		startGameLoop();
	}

	private void startGameLoop(){
		GameThread = new Thread(this); ///crea un nuovo thread
		GameThread.start();	           ///avvia il thread
	}
	

	public void update() {
		game1.updateGame();
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
				game1.repaint();
				frame++;
				deltaF --;
			}
			
			if(System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " +frame + "| UPS : " +updates);
				frame = 0;
				updates = 0;
			}
		}
	}
}	
