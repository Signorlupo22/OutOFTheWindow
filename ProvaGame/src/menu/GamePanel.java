/*
 * motore grafico (ancora non so cosa sia)
 * 
*/

package menu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;

import Utility.LoadSave;

public class GamePanel extends JPanel {

	private boolean moving = false;
	private BufferedImage img = null;

	public GamePanel() {
	}

	private void setPanelSize() {
		Dimension size = new Dimension(400, 400);
		setMaximumSize(size);
		setMinimumSize(size);
		setPreferredSize(size);
	}

	public void paintImgMenu(int x, int y, int width, int height, String choose) {
		super.paintComponent(getGraphics());
		img = null;
		while (img == null) {
			img = LoadSave.GetSpriteAtlas(choose + ".png");
		}
		getGraphics().drawImage(img, x, y, width, height, null);
	}

	public void paintSceltaLevel(int x, int y, int width, int height, int choose) {
		super.paintComponent(getGraphics());
		img = null;
		while (img == null) {
			switch (choose) {
			case 1:
				do {
					img = LoadSave.GetSpriteAtlas("Level1.png");
				} while (img == null);

				break;
			case 2:
				while (img == null) {
					img = LoadSave.GetSpriteAtlas("livello2.png");
				}
				break;
			case 3:
				while (img == null) {
					img = LoadSave.GetSpriteAtlas("livello3.png");
				}
				break;
			}
		}

		getGraphics().drawImage(img, x, y, width, height, null);
	}

}
