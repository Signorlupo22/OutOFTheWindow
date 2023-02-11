package MainGame; ///loop del gioco (chiama se stesso 200 volte al secondo. aggiornamento dello schermo 120 FPS)

import WindowLogic.LevelInfo;

public class MainGame implements Runnable {
	
	
	///thread
	/*
	thread -> esecuzione del programma che va in contemporanea ad altri thread (più parti del codice che lavorano allo stesso momento.)
	
	saranno più di uno:
		-uno per finestra
		-uno per il timer (forse)
		-in teoria basta	
	
	*/
	
	
	private Thread GameThread;
	private final int FPS_SET = 120;
	private LevelInfo game1;
	
	public MainGame(){
		game1 = new LevelInfo();
		startGameLoop();
	}

	private void startGameLoop(){
		GameThread = new Thread(this); ///crea un nuovo thread
		GameThread.start();	           ///avvia il thread
	}
	
	@Override
	public void run() {  ///funzione del thread che lo fa partire
		
		
		
		///modifiche che thomas ha fatto e caricherà al più presto
		
		double timePerFrame = 1000000000 / FPS_SET;
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();
		
		int frame = 0;
		long lastCheck = System.currentTimeMillis();
		while(true) {
			now = System.nanoTime();
			if(System.nanoTime() - lastFrame >= timePerFrame) {
				game1.repaint();
				lastFrame = now;
				frame++;
			}
			
			if(System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " +frame );
				frame = 0;
			}
		}
	}
}	
