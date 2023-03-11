package Utility;

import java.awt.geom.Rectangle2D;

import Entities.Player;
import MainGame.MainGame;

public class HelperMethods {
	
	public static boolean CanMoveHere(float x,float y, float width, float height, int [][] lvlData, Player p){
		
		if(x <= 0 && !p.getHasEntery()){
			return false;
		}else if(x >= MainGame.GAME_WIDTH- width && !p.getHasExit()) {
			return false;
		}
		
		if(!isSolid(x, y, lvlData))
			if(!isSolid(x+width, y +height, lvlData))
				if(!isSolid(x + width, y, lvlData))
					if(!isSolid(x, y + height, lvlData))
						return true;
		
		return false;
	}
	
	private static boolean isSolid(float x, float y, int[][] lvlData) {
		if(x <= 0 || x >= MainGame.GAME_WIDTH ) return false;
		if( y < 0 || y >= MainGame.GAME_HEIGHT) return true;
		
		float xIndex = x / MainGame.TILES_SIZE;
		float yIndex = y / MainGame.TILES_SIZE;
		try {
			int a =lvlData[(int)yIndex][(int)xIndex];
		} catch (Exception e) {
			//se la shell e attaccata a un altra shell 
			return false;
		}
		
		int value = lvlData[(int)yIndex][(int)xIndex];
	
		if(value >= 48 || value < 0 || (value != 11 && value != 12 && value != 28)) 
			return true;
		
		return false;
	}
	
	public static float GetEntityXPosNextToWall(Rectangle2D.Float hitbox, float xSpeed) {
		int currentTile = (int) (hitbox.x / MainGame.TILES_SIZE);
		if (xSpeed > 0) {
			// Right
			int tileXPos = currentTile * MainGame.TILES_SIZE;
			int xOffset = (int) (MainGame.TILES_SIZE - hitbox.width);
			return tileXPos + xOffset - 1;
		} else
			// Left
			return currentTile * MainGame.TILES_SIZE;
	}

	public static float GetEntityYPosUnderRoofOrAboveFloor(Rectangle2D.Float hitbox, float airSpeed) {
		int currentTile = (int) (hitbox.y / MainGame.TILES_SIZE);
		if (airSpeed > 0) {
			// Falling - touching floor
			int tileYPos = currentTile * MainGame.TILES_SIZE;
			int yOffset = (int) (MainGame.TILES_SIZE - hitbox.height);
			return tileYPos + yOffset - 1;
		} else
			// Jumping
			return currentTile * MainGame.TILES_SIZE;

	}

	public static boolean IsEntityOnFloor(Rectangle2D.Float hitbox, int[][] lvlData) {
		// Check the pixel below bottomleft and bottomright
		if(hitbox.x <= 4 || hitbox.x >= MainGame.GAME_WIDTH - 4) return true;
		if (!isSolid(hitbox.x, hitbox.y + hitbox.height + 1, lvlData))
			if (!isSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, lvlData))
				return false;

		return true;
	}
}
