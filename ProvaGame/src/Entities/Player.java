package Entities;

import static Utility.Constants.Direciotn.DOWN;
import static Utility.Constants.Direciotn.LEFT;
import static Utility.Constants.Direciotn.RIGHR;
import static Utility.Constants.Direciotn.UP;
import static Utility.Constants.PlayerConstants.GetSpriteAmount;
import static Utility.Constants.PlayerConstants.IDLE;
import static Utility.Constants.PlayerConstants.RUNNING;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.MissingFormatArgumentException;

import javax.imageio.ImageIO;

import MainGame.MainGame;
import Utility.HelperMethods;
import Utility.LoadSave;
import Utility.Vector2;
import WindowLogic.LevelInfo;

public class Player extends Entity{
	
	private BufferedImage[][] animation;
	private int aniTick , aniIndex , aniSpeed = 5;
	private int playerAction = IDLE;
	private int playerDir = 0;
	private boolean moving = false;
	private boolean left, up, right, down,jump;
	private float playerSpeed = 1.0f;
	private Vector2 posOfshell;
	private float xDrawOffeset = 1 * MainGame.SCALE;
	private float yDrawOffeset = 1 * MainGame.SCALE;
	
	private int[][] lvlData;
	
	Dimension size;
	
	//Gravity
	private float airSpeed = 0;
	private float gravity = 0.04f * MainGame.SCALE;
	private float jumpSpeed = -1.90f * MainGame.SCALE;
	private float fallSpeedAfterCollision = 0.5f;
	private boolean inAir = false;
	
	boolean HasEntery,HasExit;
	
	public Player(int x, int y, int width, int height) {
		super(x, y,width,height);
		size = Toolkit.getDefaultToolkit().getScreenSize(); ///dimensioni dello schermo
		
		loadAnimation();
		initHitbox(x, y, 12 * MainGame.SCALE,  15* MainGame.SCALE);
	}
	
	public void update() {
		updatePos();
		updateAnimationTick();
		setAnimation();
	}
	
	
	private void loadAnimation() { ///metodo per leggere l'immagine del personaggio
		
			BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
			
			animation = new BufferedImage[2][14];
			for(int j = 0; j < animation.length; j++) {
				for (int i = 0; i < animation[j].length; i++) {
					animation[j][i] = img.getSubimage(i * 151,  j* 191, 151, 192);
				}	
			}

	}
	
	
	private void updatePos() {
		// TODO Auto-generated method stub
		moving = false;
		if (jump && (!(hitbox.x <= 4) || !(hitbox.x >= MainGame.GAME_WIDTH - 4)))
			jump();
		if (!left && !right && !inAir)
			return;
		float xSpeed = 0;

		if (left)
			xSpeed -= playerSpeed;
		if (right)
			xSpeed += playerSpeed;

		if (!inAir)
			if (!HelperMethods.IsEntityOnFloor(hitbox, lvlData))
				inAir = true;
		if (inAir) {
			if (HelperMethods.CanMoveHere(hitbox.x, hitbox.y + airSpeed, hitbox.width, hitbox.height, lvlData, this)) {
				hitbox.y += airSpeed;
				airSpeed += gravity;
				updateXPos(xSpeed);
			} else {
				hitbox.y = HelperMethods.GetEntityYPosUnderRoofOrAboveFloor(hitbox, airSpeed);
				if (airSpeed > 0)
					resetInAir();
				else
					airSpeed = fallSpeedAfterCollision;
				updateXPos(xSpeed);
			}

		} else
			updateXPos(xSpeed);
		moving = true;

	}
	
	private void jump() {
		if (inAir)
			return;
		inAir = true;
		airSpeed = jumpSpeed;

	}
	public void resetInAir() {
		inAir = false;
		airSpeed = 0;

	}

	private void updateXPos(float xSpeed) {
		if (HelperMethods.CanMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, lvlData, this)) {
			hitbox.x += xSpeed;
		}
		if(hitbox.y > MainGame.GAME_HEIGHT + 50000) {
			setPostion(200, 200);
		}
		
	}

	private void updateAnimationTick() {
		// TODO Auto-generated method stub
		aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex ++;
			
			if(aniIndex >= GetSpriteAmount(playerAction))
				aniIndex = 0;
		}
	}
	public void resetDirBooleans() {
		left = false;
		right = false;

	}

	
	public void setDireciotn(int direciotn) {
		this.playerDir = direciotn;
		moving = true;
	}
	
	public void setMoving(boolean moving ) {
		this.moving = moving;
	}
	public void setAnimation(){
		if(moving)
			playerAction = RUNNING;
		else playerAction = IDLE;
	}
	
	void updatePosOfShell(Vector2 pos) {
		this.posOfshell = pos;
	}

	public void UpdateGraphics(Graphics g) {
		if(animation[playerAction][aniIndex] != null) 
			g.drawImage(animation[playerAction][aniIndex], (int)(hitbox.x - xDrawOffeset), (int)(hitbox.y - yDrawOffeset),(int)(152 / 10 * MainGame.SCALE),(int)(192 / 10 * MainGame.SCALE ),null);
		//drawHitBox(g);
		
	}
	
	
	public void setPostion(int xa, int ya) {
		hitbox.x = xa;
		hitbox.y = ya;
		updatePos();
	}
	
	
	public Vector2 getPostion() {
		return new Vector2((int)hitbox.x,(int)hitbox.y);
	}
	
	public void loadLevelData(int [][] lvlData) {
		if(lvlData == null) System.out.println("ao lvl data e vuoto");
		this.lvlData = lvlData;
	}
	


	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}
	
	public void setJump(boolean jump) {
		this.jump = jump;
	}
	public boolean getHasEntery() {
		return HasEntery;
	}
	
	public boolean getHasExit() {
		return HasExit;
	}
	
	
	public void setHasEntery(boolean HasEntery) {
		this.HasEntery = HasEntery;
	}
	
	public void setHasExit(boolean HasExit) {
		this.HasExit = HasExit;
	}
}
