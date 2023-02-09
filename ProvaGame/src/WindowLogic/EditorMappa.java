package WindowLogic;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class EditorMappa extends GamePanel {
	private BufferedImage bg;
	
	
	public EditorMappa() {
		setPanelSize();
		importImg();
	}
	
	
	
	private void importImg() {
		// TODO Auto-generated method stub
		InputStream is = getClass().getResourceAsStream("/Map.png");
		
		try {
			bg = ImageIO.read(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	private void setPanelSize() {
		Dimension size = new Dimension(650,400);
		setMaximumSize(size);
		setMinimumSize(size);
		setPreferredSize(size);
		
	}
	
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawImage(bg, 0, 0,650,400,null);
		

	}
}
