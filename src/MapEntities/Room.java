package MapEntities;

import java.awt.Dimension;
import java.util.ArrayList;

import Tiles.Tile;
import Utilities.Drawer;

public class Room extends MapEntity {
	private int Capacity;
	
	public Room(ArrayList<Tile> t, int c){
		this.t = t;
		this.setCapacity(c);
	}

	
	@Override
	public void draw(){
		for (Tile t : this.t){
			Drawer.drawTile(t);
		}
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		this.Capacity = capacity;
	}
}
