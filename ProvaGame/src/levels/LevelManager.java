package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import MainGame.MainGame;
import Utility.Constants.LevelInfoStatic;
import Utility.LoadSave;

public class LevelManager {
	private BufferedImage[] levelSprite;
	private int num;
	private int level;
	private int lvl[][];
	public LevelManager(int num, int level) {
		
		//levelSprite = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
		this.num = num;
		this.level = level; 
		importSprite();
	}
	
	private void importSprite() {
		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
		
		levelSprite = new BufferedImage[112];
		for(int j = 0; j < 7 ; j++) {
			for (int i = 0; i < 16 ; i++) {
				int index = j* 16 + i;
				levelSprite[index] = img.getSubimage(i* 18, j * 18, 18, 18);
				//levelSprite[index] = img.getSubimage(i* 32, j * 32, 32, 32);
			}
		}
	}

	public void draw(Graphics g) { 
		lvl = LoadSave.GetLevelData(LevelInfoStatic.PATHLEVEL1 + num );
		if(lvl == null) return;
		
		for(int j = 0; j < MainGame.TILES_IN_HEIGHT ; j++) {
			for (int i = 0; i < MainGame.TILES_IN_WIDTH ; i++) {
				int index = lvl[j][i];
				g.drawImage(levelSprite[index], i * MainGame.TILES_SIZE, j * MainGame.TILES_SIZE, MainGame.TILES_SIZE , MainGame.TILES_SIZE,null);
			}
		}
	}
	
	public void update() {
		
	}
	
	public int[][] getCurrentLevel(){
		return lvl;
	}
}
