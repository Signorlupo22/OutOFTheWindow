package WindowLogic;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Utility.LoadSave;


public class ShellTimer extends Thread {
	protected JFrame jframe;
	private JLabel label;
	private Timer timer;
    private int count;
    private boolean continueTimer = true;
    Image bg;
    private long startTime,currentTime;
    
    public ShellTimer(long st) {
    	jframe = new JFrame("Timer");
        label = new JLabel("Testo iniziale");
        jframe.add(label);
        timer = new Timer();
        
        
        jframe.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width - 200,0);
        jframe.setSize(200, 220);
        label.setFont(new Font("Citystencil",0,55));
        label.setSize(new Dimension(200, 220));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		
		jframe.setVisible(true);
		startTime = st;
		Sfondo();
    }
    public void run() {
    	while(true && continueTimer) {
    		//repaint();
    		updateTimer();
    		label.setText((int)(currentTime/10) + "");
    	}
    }
    public void Sfondo() {
    	bg = LoadSave.GetSpriteAtlas("1.png");
    	Graphics g = jframe.getGraphics();
    	jframe.paintComponents(g);
    	g.drawImage(bg,0,0,null);
    }
    public void stopTimer() {
    	continueTimer = false;
    }
    
    public void updateTimer() {
    	currentTime = System.currentTimeMillis() - startTime ;
    }
    
    public void repaint() {
    	//jframe.repaint();
    	Graphics g = jframe.getGraphics();
    	g.drawImage(bg,0,0,null);
    	label.setText(currentTime + "");
    }

}
