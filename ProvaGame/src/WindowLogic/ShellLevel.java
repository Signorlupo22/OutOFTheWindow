package WindowLogic;
import javax.swing.JFrame;

import Inputs.KeyboardInputs;
import Utility.*;

public class ShellLevel {
	//path dell immagine del livello (qua faro una cosa un po complessa)
	private final String path ="";
	//shell
	protected JFrameLevl jframe;
	//poszione della shell
	private Vector2 pos;
	private Vector2 Dim;
	//poszione delle porte
	private Vector2[] posDoor;
	
	//posizione fissa della dimensionede della shell
	private boolean PosFissa;
	//dimesione fissa
	private boolean DimFissa;
	
	
	//input forse

	
	public ShellLevel(GamePanel panel, int numShell) {
		jframe = new JFrameLevl(numShell, panel);
		Dim = new Vector2(400,400);
		pos = new Vector2(0,0);
		
		jframe.setLocation(pos);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(panel);
		jframe.setResizable(false);
		jframe.pack();
		
		
		
		jframe.setVisible(true);
	}
	
	
	public ShellLevel(int xpos,int ypos, int xdim,int ydim, GamePanel panel, int num) {
		//creo il frame (dentro ce anche il keyboard listener)
		jframe = new JFrameLevl(num, panel);
		
		//creo i vector2
		Dim = new Vector2(xdim,ydim);
		pos = new Vector2(xpos,ypos);
		
		//metto le dimesioni (con un Vector2 perche ho fatto un override della funzione)
		//jframe.setSize(Dim, num, panel);
		
		jframe.setLocation(pos);
		//se chiudi una chiudi tutte 
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//aggiugnere la grafica all frame 
		jframe.add(panel);
		jframe.setResizable(false);
		jframe.pack();
		
		//la rendo visibile
		jframe.setVisible(true);
	}
	
}
