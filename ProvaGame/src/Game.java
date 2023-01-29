import javax.swing.*;


public class Game {
	private JFrame jframe,scheda1;
	
	public Game(){
		jframe  = new JFrame();
		
		
		jframe.setSize(400,400);
		jframe.setLocation(100, 100);
		jframe.setVisible(true);

	}
	
	public Object getpos() {
		return jframe.getLocationOnScreen();
	}
	public void modPos(int x ,int y) {
		jframe.setLocation(x, y);
	}

}
