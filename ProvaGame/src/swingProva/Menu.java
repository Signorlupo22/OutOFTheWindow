package swingProva;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.*;

public class Menu extends Thread {

	static int LARGHEZZA = -120;
	final static int nFrame = 8;
	static int DELAY=200;
	private JFrame[] frame = new JFrame[nFrame];
	private GamePanel[] panel = new GamePanel[nFrame];
	//private Menu menu;
	
	public Menu() {
	}	
	public void run() {


		for (int i = 0; i < nFrame; i++) {
			frame[i] = new JFrame("frame"+i);
			panel[i] = new GamePanel();

			frame[i].add(panel[i]);
		}

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		frame[0].setLocation(screenSize.width / 2 - 100 + LARGHEZZA, screenSize.height / 2 - 400);
		frame[0].setSize(600, 400);
		frame[1].setLocation(screenSize.width / 2 - 400 + LARGHEZZA, screenSize.height / 2 - 500);
		frame[1].setSize(350, 800);
		frame[2].setLocation(screenSize.width / 2 - 200 + LARGHEZZA, screenSize.height / 2 - 20);
		frame[2].setSize(650, 400);
		frame[3].setLocation(screenSize.width / 2 + 350 + LARGHEZZA, screenSize.height / 2 - 300);
		frame[3].setSize(300, 700);

		frame[4].setLocation(screenSize.width / 2 - 400 + LARGHEZZA, screenSize.height / 2 + 420);
		frame[4].setSize(300, 100);
		frame[5].setLocation(screenSize.width / 2 - 30 + LARGHEZZA, screenSize.height / 2 + 420);
		frame[5].setSize(300, 100);
		frame[6].setLocation(screenSize.width / 2 + 300 + LARGHEZZA, screenSize.height / 2 + 420);
		frame[6].setSize(300, 100);
		frame[7].setLocation(screenSize.width / 2 + 300 + LARGHEZZA, 4);
		frame[7].setSize(0, 0);

		frame[2].setUndecorated(true);
		frame[4].setUndecorated(true);
		frame[5].setUndecorated(true);
		frame[6].setUndecorated(true);

		for (int i = 0; i < nFrame; i++) {
			frame[i].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame[i].setResizable(false);
			
			frame[i].addWindowFocusListener(new FrameSelectionListener(this));
			
			frame[i].setVisible(true);

			switch (i) {
				case 0:
					panel[0].paintLogoMenu(-300, -100, 1050, 900);
					break;
				case 1:
					panel[1].paintLogoMenu(0, 0, 1050, 900);
					break;
				case 2:
					panel[2].paintLogoMenu(-192, -450, 1050, 900);
					break;
				case 3:
					panel[3].paintLogoMenu(-750, -200, 1050, 900);
					break;
				case 4:
					panel[4].paintLogoMenu(-750, -200, 1050, 900);
					break;
				case 5:
					panel[5].paintPlay(-10, -10, 320, 120);
					break;
			}
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		frame[7].dispose();
	}
	
	/*public void setMenu() {
		menu=this;
	}
	public void getMenu() {
		this.menu=m;
	}*/
	
 	public void closeAll() {
		for (int i = 0; i < nFrame; i++) {
			frame[i].dispose();
		}
	}
}
