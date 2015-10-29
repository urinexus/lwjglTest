package Tiles;

public class BlockTile extends Tile {

	public BlockTile(int x,int y){
		super(x,y,false);
	}

	@Override
	public String getTexture() {	return "block.png";	}

	@Override
	public direction getDirection() {	return direction.SOUTH;	}

	@Override
	public void setWalkable(boolean b){	}
}
