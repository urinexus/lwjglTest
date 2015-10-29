package Utilities;

import java.io.InputStream;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import Actor.*;
import MapEntities.*;
import Tiles.Tile;
import static org.lwjgl.opengl.GL11.*;

public class Drawer {
	
	public static Texture loadTexture(String path){
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			tex = TextureLoader.getTexture("PNG", in);
		} catch (Exception e){
			e.printStackTrace();
		}
		return tex;
	}
	
	public static void drawTile(Tile t){
		
		glTranslatef(t.getX()*t.getDimension(),t.getY()*t.getDimension(),0);
		glPushMatrix();
		
		glTranslatef(t.getDimension()/2,t.getDimension()/2,0);
		int d=0;
		switch(t.getDirection()){
		case SOUTH: d = 0;	break;
		case WEST:	d = 90;	break;
		case NORTH: d = 180; break;
		case EAST:	d = -90;break;
		}		
		
		glRotatef(d,0,0,1);
		glTranslatef(-t.getDimension()/2,-t.getDimension()/2,0);
		
		(loadTexture(t.getTexture())).bind();
		glBegin(GL_QUADS);
		glTexCoord2f(0,0);
		glVertex2f(0,0);
		glTexCoord2f(1,0);
		glVertex2f(t.getDimension(),0);
		glTexCoord2f(1,1);
		glVertex2f(t.getDimension(),t.getDimension());
		glTexCoord2f(0,1);
		glVertex2f(0,t.getDimension());
		glEnd();
		glPopMatrix();
		
		glLoadIdentity();
		
	}	
	
	public static void drawPed(Pedestrian T){
		(loadTexture(T.getTexture())).bind();
		//glTranslatef(T.getOnBlock().getX()*T.getOnBlock().getDimension(),T.getOnBlock().getY()*T.getOnBlock().getDimension(),0);
		glTranslatef(T.getX(),T.getY(),0);
		
		glBegin(GL_QUADS);
		glTexCoord2f(0,0);
		glVertex2f(0,0);
		glTexCoord2f(1,0);
		glVertex2f(T.getDimension(),0);
		glTexCoord2f(1,1);
		glVertex2f(T.getDimension(),T.getDimension());
		glTexCoord2f(0,1);
		glVertex2f(0,T.getDimension());

		glEnd();
		glLoadIdentity();
		
	}
	
	public static void drawPortal(Portal p) {
		(loadTexture(p.getTexture())).bind();
		glTranslatef(p.getOnBlock().getX()*p.getOnBlock().getDimension(),p.getOnBlock().getY()*p.getOnBlock().getDimension(),0);
		glTranslatef(p.getX(),p.getY(),0);
		
		glBegin(GL_QUADS);
		glTexCoord2f(0,0);
		glVertex2f(0,0);
		glTexCoord2f(1,0);
		glVertex2f(p.getDimension(),0);
		glTexCoord2f(1,1);
		glVertex2f(p.getDimension(),p.getDimension());
		glTexCoord2f(0,1);
		glVertex2f(0,p.getDimension());

		glEnd();
		glLoadIdentity();
	}
}
