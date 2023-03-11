package menu;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

import classifica.*;

public class FrameSelectionListener implements WindowFocusListener {
	private static int sceltaClassifica=0, scelta=0;
	private Menu menu2;
	private SceltaLivelli livelli;
	private SceltaClassifica classifica;
	private String nomePlayer=null;
	public VetClassifica v = VetClassifica.load("classifiche.bin");
	
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
	public FrameSelectionListener(SceltaClassifica c) {
		classifica=c;
	}
	
	public void windowGainedFocus(WindowEvent e) {
		if (e.getSource() instanceof JFrame) {
			JFrame selectedFrame = (JFrame) e.getSource();
			System.out.println("");

			switch(selectedFrame.getTitle()) {
				case"frame4":
					if(sceltaClassifica>=1) {
						
						System.out.println("selezionato classifica entro");
						menu2.closeAll();
						try {
							menu2.join();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						AvvioSceltaCla();
					}
					System.out.println("Hai selezionato il Frame 4");
					sceltaClassifica++;
					break;
				case"frame5":
					scelta++;
					System.out.println("Hai selezionato il Frame 5");
					if(scelta>1) {
						menu2.closeAll();
						try {
							menu2.join();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						InNome inNome = new InNome(this);
						inNome.setVisible(true);
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
					
					
				case"frameLV1cla":
					System.out.println("Hai selezionato il frameLV1");
					scelta++;
					if(scelta>4) {
						v.getC(0).add(new Partita("null",999999999));
						v.getC(0).add(new Partita("null",999999999));
						v.getC(0).add(new Partita("null",999999999));
					    new ShlClassifica(v.getC(0));
					    classifica.closeAll();
					    try {
							classifica.join();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					break;
				case"frameLV2cla":
					scelta++;
					/*
					if(scelta>4) {
						v.getC(1).add(new Partita("null",999999999));
						v.getC(1).add(new Partita("null",999999999));
						v.getC(1).add(new Partita("null",999999999));
					    new ShlClassifica(v.getC(1));
					    classifica.closeAll();
					    try {
							classifica.join();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}*/
					break;
				case"frameLV3cla":
					scelta++;
					/*
					if(scelta>4) {
						v.getC(2).add(new Partita("null",999999999));
						v.getC(2).add(new Partita("null",999999999));
						v.getC(2).add(new Partita("null",999999999));
					    new ShlClassifica(v.getC(2));
					    classifica.closeAll();
					    try {
							classifica.join();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}*/
					break;
			}
		}

	}
	
	public void AvvioScelta(String nome) {
		nomePlayer=nome;
		System.err.println(nomePlayer);
		SceltaLivelli s = new SceltaLivelli();
		s.start();
	}
	public void AvvioSceltaCla() {
		System.err.println(nomePlayer);
		SceltaClassifica c = new SceltaClassifica();
		c.setVet(v);
		c.start();
	}
	
	public int scelta() {
		return scelta;
	}
	
	public void windowLostFocus(WindowEvent e) {
	}
}