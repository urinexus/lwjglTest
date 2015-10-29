package Tiles;

public class DoorTile extends TileForRoom {
	private direction dir;
	
	public DoorTile(int x,int y, direction dir){
		super(x,y,true);
		this.dir = dir;

	}

	@Override
	public String getTexture() {	return "door.png";	}
	
	@Override
	public direction getDirection()	{ return this.dir;	}

	@Override
	public void setWalkable(boolean b){	walkable = b;	}

}
