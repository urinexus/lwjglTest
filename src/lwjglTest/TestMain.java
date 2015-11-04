package lwjglTest;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import org.lwjgl.*;
import org.lwjgl.opengl.*;

import Actor.*;
import MapEntities.*;
import Tiles.*;
import Utilities.*;
import static org.lwjgl.opengl.GL11.*;

public class TestMain {
	public static final int framedimension = 400;
	public static Map grid;
	
	public TestMain(){
		try{
			Display.setTitle("GridMap Test");
			Display.setDisplayMode(new DisplayMode(framedimension,framedimension));
			Display.create();
			}
			catch (LWJGLException e){
				e.printStackTrace();
				System.exit(0);
			}
			
			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			glOrtho(0,framedimension,framedimension,0,1,-1);
			glMatrixMode(GL_MODELVIEW);
			glEnable(GL_TEXTURE_2D);
			glEnable(GL_BLEND);
			glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
			
						
			ArrayList<Tile> t = new ArrayList<Tile>();
			for (int i=5;i<10;i++)
				for (int j=5;j<10;j++)
					if (i==5||i==9||j==5||j==9)
						t.add(new WallTile(i,j));
			t.remove(2);
			t.add(new DoorTile(5,7,Tile.direction.WEST));
			Room r = new Room(t,100); 
			
			ArrayList<Tile> t2 = new ArrayList<Tile>();
			t2.add(new BlockTile(5,0));
			Obstacle O = new Obstacle(t2);
			
			Map.addEntity(r);
			Map.addEntity(O);
			
			Portal P = new Portal(Map.TileGrid.get(new Dimension(0,0)),50,Actor.direction.EAST);
			Map.addActor(P);
			
			while(!Display.isCloseRequested()){
				Timer.update();
				Map.update();				
				
				Display.update();
				
			}
			
			Display.destroy();
	}
	
	public static void main(String[] args){
		new TestMain();
}
}