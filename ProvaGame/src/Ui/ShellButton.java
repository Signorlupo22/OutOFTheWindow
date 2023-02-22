package Ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Utility.LoadSave;
import static Utility.Constants.Buttons.*;

public class ShellButton {
	private int xPos, yPos, rowIndex, index;
	private int xOffsetCenter = B_WIDTH / 2;
	private BufferedImage[] imgs;
	private boolean mouseOver, mousePressed;
	private Rectangle bounds;
	
	
	public ShellButton(int xPos, int yPos, int rowIndex) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.rowIndex = rowIndex;
		loadImgs();
		initBounds();
	}
	private void initBounds() {
		bounds = new Rectangle(xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT);

	}

	private void loadImgs() {
		imgs = new BufferedImage[3];
		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS);
		for (int i = 0; i < imgs.length; i++)
			imgs[i] = temp.getSubimage(i * B_WIDTH_DEFAULT, rowIndex * B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);
	}
	
	public int update() {
		index = 0;
		if (mouseOver) {
			index = 1;
		}
		if (mousePressed)
			index = 2;
		return index;
	}

	public boolean isMouseOver() {
		return mouseOver;
	}
	public void draw(Graphics g) {
		g.drawImage(imgs[index], xPos - xOffsetCenter, yPos ,bounds.width ,bounds.height , null);
		g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}

	public boolean isMousePressed() {
		return mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void resetBools() {
		mouseOver = false;
		mousePressed = false;
	}
	public void doAction() {
		setMousePressed(true);
		
	}

}
