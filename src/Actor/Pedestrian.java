package Actor;

import lwjglTest.Map;
import MapEntities.MapEntity;
import Tiles.Tile;
import Utilities.*;


public class Pedestrian extends Actor {
	private static final int coordBuffer = 5;
	private static final int dimension = 10;
	private double speed;
	private boolean firstUpdate = true;
	
	public Pedestrian(Tile t,double s,direction dir){
		super.setOnBlock(t);
		t.setWalkable(false);
		Map.updateTile(t);
		this.setX(onBlock.getX()*onBlock.getDimension()+(t.getDimension()-this.getDimension())/2);
		this.setY(onBlock.getX()*onBlock.getDimension()+(t.getDimension()-this.getDimension())/2);
		this.setSpeed(s);
		this.dir  = dir;
	}
	
	public void update(){
		if (firstUpdate)
			firstUpdate = false;
		else{
			
			findNewPath();
			
			Tile nextTile = null;
			
			switch (dir){
			case NORTH:	nextTile = Map.getTile(onBlock.getX(), onBlock.getY()-1);break;
			case EAST:	nextTile = Map.getTile(onBlock.getX()+1, onBlock.getY());break;
			case SOUTH:	nextTile = Map.getTile(onBlock.getX(), onBlock.getY()+1);break;
			case WEST:	nextTile = Map.getTile(onBlock.getX()-1, onBlock.getY());break;
			}
			
			if (nextTile!= null && nextTile.isWalkable()){
				int oldX = this.X;
				int oldY = this.Y;
				switch (dir){
				case NORTH:
					this.Y -= Timer.Delta() * speed;
					if (this.Y % onBlock.getDimension() > oldY % onBlock.getDimension()+coordBuffer){
						onBlock.setWalkable(true);
						Map.updateTile(onBlock);
						setOnBlock(Map.getTile(onBlock.getX(), onBlock.getY()-1));
						onBlock.setWalkable(false);
					}
					break;
				case EAST:
					this.X += Timer.Delta() * speed;
					if (this.X % onBlock.getDimension() < oldX % onBlock.getDimension()-coordBuffer){
						onBlock.setWalkable(true);
						Map.updateTile(onBlock);
						setOnBlock(Map.getTile(onBlock.getX()+1, onBlock.getY()));
						onBlock.setWalkable(false);
					}
					break;
				case SOUTH:
					this.Y += Timer.Delta() * speed;
					if (this.Y % onBlock.getDimension() < oldY % onBlock.getDimension()-coordBuffer){
						onBlock.setWalkable(true);
						Map.updateTile(onBlock);
						setOnBlock(Map.getTile(onBlock.getX(), onBlock.getY()+1));
						onBlock.setWalkable(false);
					}
					break;
				case WEST:
					this.X -= Timer.Delta() * speed;
					if (this.X % onBlock.getDimension() > oldX % onBlock.getDimension()+coordBuffer){
						onBlock.setWalkable(true);
						Map.updateTile(onBlock);
						setOnBlock(Map.getTile(onBlock.getX()-1, onBlock.getY()));
						onBlock.setWalkable(false);
					}
					break;
				}
				
			}
		}
		Map.updateTile(onBlock);
		Drawer.drawPed(this);
	}
	
	private void findNewPath(){
		switch (dir){
		case NORTH:
			if (onBlock.getY()==0 || (Map.getTile(onBlock.getX(),onBlock.getY()-1)!=null && !Map.getTile(onBlock.getX(),onBlock.getY()-1).isWalkable()))
				dir = direction.EAST;
			break;
		case EAST:
			if (onBlock.getX()==19 || (Map.getTile(onBlock.getX()+1,onBlock.getY())!=null && !Map.getTile(onBlock.getX()+1,onBlock.getY()).isWalkable()))
				dir = direction.SOUTH;
			break;
		case SOUTH:
			if (onBlock.getY()==19 || (Map.getTile(onBlock.getX(),onBlock.getY()+1)!=null && !Map.getTile(onBlock.getX(),onBlock.getY()+1).isWalkable()))
				dir = direction.WEST;
			break;
		case WEST:
			if (onBlock.getX()==0 || (Map.getTile(onBlock.getX()-1,onBlock.getY())!=null && !Map.getTile(onBlock.getX()-1,onBlock.getY()).isWalkable()))
				dir = direction.NORTH;
			break;
		}
	}
	
	public String getTexture(){		return "pedestrian.png";	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}


	public int getDimension() {
		return dimension;
	}

	
}
