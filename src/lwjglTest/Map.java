package lwjglTest;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import Actor.*;
import MapEntities.*;
import Tiles.*;
import Utilities.Drawer;

public class Map {
	public static int MaxCoordinate;
	public static HashMap<Dimension,Tile> TileGrid;
	public static ArrayList<MapEntity> EntityList;
	public static HashMap<String,ArrayList<Actor>> Actors;
	
	static{
		MaxCoordinate = 20;
		TileGrid = new HashMap<Dimension,Tile>();
		for (int i=0;i<MaxCoordinate;i++)
			for (int j=0;j<MaxCoordinate;j++)
				TileGrid.put(new Dimension(i,j), new RoadTile(i,j));
		EntityList = new ArrayList<MapEntity>();
		Actors = new HashMap<String,ArrayList<Actor>>();
		Actors.put("Pedestrian", new ArrayList<Actor>());
		Actors.put("Portal", new ArrayList<Actor>());		
	}
	
	public static void addEntity(MapEntity e){ 
	EntityList.add(e);
	for (Tile t : e.t)
		TileGrid.put(new Dimension(t.getX(),t.getY()), t);
	
	ArrayList<Dimension> temp = new ArrayList<Dimension>();
	for (Dimension k : TileGrid.keySet())
		if (e.coordInside((int)k.getWidth(),(int)k.getHeight()))
			temp.add(k);
	temp.forEach(k -> TileGrid.remove(k));
	}
	
	public static void addActor(Actor a){
		Actors.get(a.getClass().getSimpleName()).add(a);
	}
	
	public static Tile getTile(int x,int y) {	
		return TileGrid.get(new Dimension(x,y));	
	}
	
	public static void updateTile(Tile t){
		TileGrid.put(new Dimension(t.getX(),t.getY()), t);
	}
	
	public static void update(){
		TileGrid.forEach((k,V) -> Drawer.drawTile(V));
		for (String t : Actors.keySet())
			for (Actor a : Actors.get(t))
				a.update();
		
	}
}
