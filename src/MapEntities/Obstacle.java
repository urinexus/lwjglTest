package MapEntities;

import java.util.ArrayList;

import Tiles.Tile;
import Utilities.Drawer;

public class Obstacle extends MapEntity {
	
	public Obstacle(ArrayList<Tile> t){
		this.t = t;
	}
			
			
	@Override
	public void draw() {
		for (Tile t : this.t){
			Drawer.drawTile(t);
		}
	}

}
