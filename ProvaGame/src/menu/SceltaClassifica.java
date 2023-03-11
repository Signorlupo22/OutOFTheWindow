package menu;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import classifica.Partita;
import classifica.ShlClassifica;
import classifica.VetClassifica;

public class SceltaClassifica extends Thread{
	
	static int LARGHEZZA = 0;
	final static int nFrame = 3;
	final static int DIMENSIONE=400;
	private JFrame[] frame = new JFrame[nFrame];
	private GamePanel[] panel = new GamePanel[nFrame];
	private VetClassifica vet;
	
	public SceltaClassifica() {
	}
	
	public void run() {

		for (int i = 0; i < nFrame; i++) {
			frame[i] = new JFrame("frameLV"+(i+1+"cla"));
			panel[i] = new GamePanel();

			frame[i].add(panel[i]);
			
		}

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame[0].setLocation(screenSize.width / 2 - 800 + LARGHEZZA, screenSize.height / 2 -200);
		frame[0].setSize(DIMENSIONE, DIMENSIONE);
		frame[1].setLocation(screenSize.width / 2 - 200 + LARGHEZZA, screenSize.height / 2 -200);
		frame[1].setSize(DIMENSIONE, DIMENSIONE);
		frame[2].setLocation(screenSize.width / 2 + 300 + LARGHEZZA, screenSize.height / 2 -200);
		frame[2].setSize(DIMENSIONE, DIMENSIONE);
	
		for (int i = 0; i < nFrame; i++) {
			frame[i].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame[i].setResizable(false);
			
			frame[i].addWindowFocusListener(new FrameSelectionListener(this));
			
			frame[i].setVisible(true);

			switch (i) {
				case 0:
					panel[0].paintSceltaLevel(0, 0, DIMENSIONE, DIMENSIONE,1);
					break;
				case 1:
					panel[1].paintSceltaLevel(0, 0, DIMENSIONE, DIMENSIONE,2);
					break;
				case 2:
					panel[2].paintSceltaLevel(0, 0, DIMENSIONE, DIMENSIONE,3);
					break;
			}
			
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void closeAll() {
		for (int i = 0; i < nFrame; i++) {
			frame[i].dispose();
		}
	}
	
	public void setVet(VetClassifica vet) {
		this.vet=vet;
	}
	

}
