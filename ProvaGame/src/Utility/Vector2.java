package Utility;

public class Vector2 {
	private int x;
	private int y;
	
	public static Vector2 ONE = new Vector2(1,1);
	public static Vector2 ONENEG = new Vector2(-1,-1);
	public static Vector2 ZERO = new Vector2(0,0);
	
	//variabili chiamabili dorettamente dalla classe ( metti caso che ci servono)
	public static Vector2 UP = new Vector2(0,-1);
	public static Vector2 DOWN = new Vector2(0,1);
	public static Vector2 LEFT = new Vector2(-1,0);
	public static Vector2 RIGHT = new Vector2(1,0);
	
	public Vector2() {
		this.x = 0;
		this.y = 0;
	}
	public Vector2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Vector2(Vector2 v) {
		if(v == null) return;
		
		this.x = v.x;
		this.y = v.y;
		
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	//ricevi la direzione della X 
	public int getDirX() {
		return (int)Math.signum(x);
	}
	
	//ricevi direzione della y
	public int getDirY() {
		return (int)Math.signum(y);
	}
}
