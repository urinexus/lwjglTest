package Actor;

import Tiles.Tile;

public abstract class Actor {
	protected Tile onBlock;
	protected int X,Y;
	public static enum direction {NORTH,EAST,SOUTH,WEST};
	protected direction dir;
	
	public abstract void update();
	
	public abstract String getTexture();
	
	public abstract int getDimension();
	
	public Tile getOnBlock() {
		return onBlock;
	}

	public void setOnBlock(Tile onBlock) {
		this.onBlock = onBlock;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		this.X = x;
	}
	
	public int getY() {
		return Y;
	}

	public void setY(int y) {
		this.Y = y;
	}

	public direction getDirection() {
		return dir;
	}

	public void setDirection(direction dir) {
		this.dir = dir;
	}
}
