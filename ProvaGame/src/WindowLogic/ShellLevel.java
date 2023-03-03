package WindowLogic;
import javax.swing.JFrame;

import Entities.Player;
import Inputs.KeyboardInputs;
import MainGame.MainGame;
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
	private Vector2[] posDoor = {new Vector2((int)(-23 * MainGame.SCALE),MainGame.TILES_SIZE * 9 +3),new Vector2((int)(216 * MainGame.SCALE),MainGame.TILES_SIZE * 7 +3)};
	
	//posizione fissa della dimensionede della shell
	private boolean PosFissa;
	//dimesione fissa
	private boolean DimFissa;
	
	private LevelInfo lvlInfo;
	private GamePanel panel;
	private Player p;

	
	private int numShell = -1;
	
	public ShellLevel(EditorMappa panel, int numShell, LevelInfo lvlInfo) {
		this.lvlInfo = lvlInfo;
		jframe = new JFrameLevl(numShell, panel,this.lvlInfo);
		Dim = new Vector2(400,400);
		pos = new Vector2(0,0);
		this.numShell = numShell;
		jframe.setLocation(pos);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(panel);
		jframe.setResizable(false);
		//jframe.setUndecorated(true);
		jframe.pack();
		
		
		jframe.setVisible(true);
	}
	
	
	public ShellLevel(int xpos,int ypos, int xdim,int ydim, GamePanel panel, int num,LevelInfo lvlInfo, Player p, int numShell,int levelnum) {
		//creo il frame (dentro ce anche il keyboard listener)
		this.panel = panel;
		this.lvlInfo = lvlInfo;
		this.p = p;
		jframe = new JFrameLevl(num, panel,this.lvlInfo);
		
		//creo i vector2
		Dim = new Vector2(xdim,ydim);
		pos = new Vector2(xpos,ypos);
		this.numShell = numShell;
		//metto le dimesioni (con un Vector2 perche ho fatto un override della funzione)
		//jframe.setSize(Dim, num, panel);
		
		jframe.setLocation(pos);
		//se chiudi una chiudi tutte 
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//aggiugnere la grafica all frame 
		jframe.add(panel);
		jframe.setResizable(false);
		//jframe.setUndecorated(true);
		jframe.pack();
		
		//la rendo visibile
		jframe.setVisible(true);
		getInfoLevel(levelnum,numShell);
		SetFristPos();
	}
	
	
	private void getInfoLevel(int levelInfo, int numshell) {
		switch (levelInfo) {
		case 1: {
			posDoor = Constants.LevelInfoStatic.PORTE_LEVEL1[numshell];
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + levelInfo);
		}
		
	}

	public void PlayerEntra() {
		if(panel != null) {
			panel.getPlayer().setPostion(posDoor[0].getX(), posDoor[0].getY());
			
		}
	}
	public void SetFristPos() {
		if(panel != null) {
			if(numShell == 0)
				panel.getPlayer().setPostion(40, posDoor[0].getY());
			else
				panel.getPlayer().setPostion(posDoor[0].getX(), posDoor[0].getY());
		}
	}
	
	public void PlayerEsce() {
		if(panel != null) {
			panel.getPlayer().setPostion(posDoor[1].getX(), posDoor[1].getY());
			
		}
	}
	
}
