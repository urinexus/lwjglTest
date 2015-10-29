package Tiles;

public class RoadTile extends Tile {
	
	public RoadTile(int x,int y){
		super(x,y,true);
	}
	
	
	@Override
	public String getTexture(){	return "road.png";	}

	@Override
	public direction getDirection() {	return direction.SOUTH;	}

	@Override
	public void setWalkable(boolean b){	walkable = b;	}
}
