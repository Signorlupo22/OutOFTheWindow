package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import MainGame.MainGame;
import Utility.LoadSave;

public class LevelManager {
	private MainGame game;
	private BufferedImage[] levelSprite;
	private int num;
	
	public LevelManager(MainGame game, int num) {
		
		//levelSprite = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
		this.num = num;
		importSprite();
	}
	
	private void importSprite() {
		BufferedImage img = LoadSave.GetSpriteAtlas("tilemap_packed.png");
		
		levelSprite = new BufferedImage[112];
		for(int j = 0; j < 7 ; j++) {
			for (int i = 0; i < 16 ; i++) {
				int index = j* 16 + i;
				levelSprite[index] = img.getSubimage(i* 18, j * 18, 18, 18);
			}
		}
	}

	public void draw(Graphics g) {
		int[][] lvl = LoadSave.GetLevelData(LoadSave.LEVEL_ONE_DATA);
		if(lvl == null) return;
		
		for(int j = 0; j < MainGame.TILES_IN_HEIGHT ; j++) {
			for (int i = 0; i < MainGame.TILES_IN_WIDTH ; i++) {
				int index = lvl[j][i];
				g.drawImage(levelSprite[index], i*MainGame.TILES_SIZE, j * MainGame.TILES_SIZE, MainGame.TILES_SIZE , MainGame.TILES_SIZE,null);
			}
		}
	}
	
	public void update() {
		
	}
}
