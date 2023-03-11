package swingProva;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class FrameSelectionListener implements WindowFocusListener {
	private static int scelta=0;
	private Menu menu2;
	private SceltaLivelli livelli;
	
	/*
	public void setMenu() {
		menu2.getMenu(menu2);;
	}*/
	public FrameSelectionListener() {
	}
	public FrameSelectionListener(Menu m) {
		menu2=m;
	}
	public FrameSelectionListener(SceltaLivelli l) {
		livelli=l;
	}
	
	public void windowGainedFocus(WindowEvent e) {
		if (e.getSource() instanceof JFrame) {
			JFrame selectedFrame = (JFrame) e.getSource();
			System.out.println("");

			switch(selectedFrame.getTitle()) {
				case"frame4":
					System.out.println("Hai selezionato il Frame 4");
					//scelta++;
					break;
				case"frame5":
					scelta++;
					System.out.println("Hai selezionato il Frame 5");
					if(scelta>1) {
						menu2.closeAll();
						try {
							menu2.join();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						SceltaLivelli s = new SceltaLivelli();
						s.start();
					}
					break;
				case"frame6":
					System.out.println("Hai selezionato il Frame 6");
					//scelta++;
					break;
				case"frameLV1":
					System.out.println("Hai selezionato il frameLV1");
					scelta++;
					if(scelta>2) {
						//livelli.closeAll();
						//SceltaLivelli s = new SceltaLivelli();
						//livelli.start();
					}
					break;
				case"frameLV2":
					scelta++;
					System.out.println("Hai selezionato il frameLV2");
					break;
				case"frameLV3":
					System.out.println("Hai selezionato il frameLV3");
					//scelta++;
					break;
			}
		}

	}
	

	
	public int scelta() {
		return scelta;
	}
	
	public void windowLostFocus(WindowEvent e) {
	}
}