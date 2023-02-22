package Utility;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import MainGame.MainGame;

public class LoadSave {
	public static final String PLAYER_ATLAS = "Anim.png";
	public static final String LEVEL_ATLAS = "outside_sprites.png";
	public static final String LEVEL_ONE_DATA = "level_one_data.png";
	public static final String MENU_BUTTONS = "ShellButton.png";
	
	public static BufferedImage GetSpriteAtlas(String fileName) {
		BufferedImage img = null;
		InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
		
		try {
			img = ImageIO.read(is);
			
		} catch (IOException e) {
			e.printStackTrace(); 
		}finally {
			try {
				is.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return img;

		
	}
	
	public static int[][] GetLevelData(String level){
		int[][] lvlData = new int[MainGame.TILES_IN_HEIGHT][MainGame.TILES_IN_WIDTH];
		BufferedImage img = LoadSave.GetSpriteAtlas(level);
		
		for(int j = 0; j < MainGame.TILES_IN_HEIGHT ; j++) {
			for (int i = 0; i < MainGame.TILES_IN_WIDTH ; i++) {
				Color color = new Color(img.getRGB(i, j));
				
				int value = color.getRed();
				if(value >= 48) value = 0;
				
				lvlData[j][i] = value;
			}
		}
		return lvlData;
	}
}
