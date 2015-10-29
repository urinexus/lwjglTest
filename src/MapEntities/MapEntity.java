package MapEntities;

import java.util.ArrayList;

import Tiles.Tile;


public abstract class MapEntity {
	public ArrayList<Tile> t;
	
	public boolean coordInside(int x,int y){
		if (this.t.size() ==0) return false;
		int[] min = {this.t.get(0).getX(),this.t.get(0).getY()};
		int[] max = {this.t.get(0).getX(),this.t.get(0).getY()};
		for (Tile t : this.t){
			if (t.getX()<=min[0] && t.getY()<=min[1]){
				min[0] = t.getX();
				min[1] = t.getY();
			}
			if (t.getX()>=max[0] && t.getY()>=max[1]){
				max[0] = t.getX();
				max[1] = t.getY();
			}
		}
		
		return ((x>min[0]&&x<max[0])&&(y>min[1]&&y<max[1]));
	}
	
	public abstract void draw();
}
