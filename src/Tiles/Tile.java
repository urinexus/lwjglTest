package Tiles;

public abstract class Tile {
	private static final int dimension = 20;
	public static enum direction {NORTH,EAST,SOUTH,WEST};
	protected int X,Y;
	protected boolean walkable;
		
	public Tile(int x,int y,boolean b){
		this.X=x;
		this.Y=y;
		this.walkable = b;
	}
	
	public int getX(){	return X;	}
	
	public int getY(){	return Y;	}
	
	public int getDimension(){	return dimension;	}
	
	public boolean isWalkable(){	return walkable;	}
	
	public abstract String getTexture();
	
	public abstract direction getDirection();
	
	public abstract void setWalkable(boolean b);
}
