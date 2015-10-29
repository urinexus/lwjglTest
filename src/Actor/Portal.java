package Actor;

import Tiles.Tile;
import Utilities.Drawer;
import Utilities.Timer;
import lwjglTest.Map;

import java.util.Random;

import org.lwjgl.Sys;

public class Portal extends Actor{
	private static Random randomiser = new Random(Sys.getTime());
	private static final int dimension = 15;
	private float timeSinceLastSpawn = 0 ,SpawnTimer;
	
	public Portal(Tile t,float tm,direction dir){
		this.setOnBlock(t);
		this.setX((t.getDimension()-this.getDimension())/2);
		this.setY((t.getDimension()-this.getDimension())/2);
		this.SpawnTimer = tm;
		this.dir = dir;
	}
	
	public void update(){
		Drawer.drawPortal(this);
		timeSinceLastSpawn += Timer.Delta();
		if (timeSinceLastSpawn > SpawnTimer){
			timeSinceLastSpawn = 0;
			spawn();
		}
		
	}
	
	public void spawn(){	Map.addActor(new Pedestrian(getOnBlock(),randomiser.nextInt(2)+1,this.getDirection()));	}
	
	public String getTexture(){	return "portal.png";	}

	public int getDimension() {		return dimension;	}
}