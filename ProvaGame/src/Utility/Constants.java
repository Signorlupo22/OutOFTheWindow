package Utility;

import Entities.Player;
import MainGame.MainGame;
import WindowLogic.LevelInfo;

public class Constants {
	public static class Buttons{
		public static final int B_WIDTH_DEFAULT = 782;
		public static final int B_HEIGHT_DEFAULT = 808;
		public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT/10f * MainGame.SCALE);
		public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT/10f * MainGame.SCALE);
	}
	
	public static class Direciotn{
		public static final int LEFT = 0;
		public static final int UP = 1; 
		public static final int RIGHR = 2;
		public static final int DOWN = 4;
	}
	
	public static class PlayerConstants{
		
		//variabili statiche per il player 
		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int JUMP = 2;
		public static final int FALLING = 3;
		public static final int GROUND = 4;
		
		public static int GetSpriteAmount(int player_action){
			switch (player_action) {
			case IDLE:
				return 9;
			case RUNNING:
				return 13;
			default:
				return 1;
			}
		}
	}
	
	public static class LevelInfoStatic{
		public static final Player player = new Player(100,200,(int)(152 / 10 * MainGame.SCALE),(int)(191 / 10 * MainGame.SCALE) );
		
		//LEVEL 1 INFO
		public static final Vector2[] POS_LEVEL1 = {new Vector2(100,100),new Vector2(500,400),new Vector2(900,700),new Vector2(1400,500),};
		public static final int LEVEL1_COUNT = 2;
		public static String PATHLEVEL1 = "level_one_data";
		
		
		//LEVEL 2 INFO
		public static final Vector2[] POS_LEVEL2 = {new Vector2(100,100),new Vector2(500,400),new Vector2(900,700),new Vector2(1400,500),};
		public static final int LEVEL2_COUNT = 3;
		public static String PATHLEVEL2 = "level_one_data";
		
	}
}
