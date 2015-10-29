package Tiles;

public class WallTile extends TileForRoom {

	public WallTile(int x, int y){
		super(x,y,false);
	}
	

	@Override
	public String getTexture() {return "room.png";	}

	@Override
	public direction getDirection() {	return direction.SOUTH;	}


	@Override
	public void setWalkable(boolean b) {	}

}
