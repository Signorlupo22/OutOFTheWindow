package MainGame;

import WindowLogic.LevelInfo;

public class MainGame implements Runnable {
	
	
	//thread
	private Thread GameThread;
	private final int FPS_SET = 120;
	private LevelInfo game1;
	
	public MainGame(){
		game1 = new LevelInfo();
		startGameLoop();
	}

	private void startGameLoop(){
		GameThread = new Thread(this);
		GameThread.start();
	}
	@Override
	public void run() {
		
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
