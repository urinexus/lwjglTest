package Tiles;

public class StairTile extends Tile {
	private direction dir;
	
	public StairTile(int x, int y,direction dir){
		super(x, y,true);
		this.dir = dir;
	}

	@Override
	public String getTexture() {		return "stair.png";	}

	@Override
	public direction getDirection() {		return this.dir;	}

	@Override
	public void setWalkable(boolean b){	walkable = b;	}

}
