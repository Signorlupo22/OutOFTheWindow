package Utility;

import MainGame.MainGame;

public class Constants {
	public static class Buttons{
		public static final int B_WIDTH_DEFAULT = 140;
		public static final int B_HEIGHT_DEFAULT = 56;
		public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT/1.5f * MainGame.SCALE);
		public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT/1.5f * MainGame.SCALE);
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
}
