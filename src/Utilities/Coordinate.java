package Utilities;

import java.awt.Dimension;

public class Coordinate{
	
	private int x,y;
	
	public Coordinate(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){	return x;	}
	
	public int getY(){	return y;	}
	
	public int getXCoord(int d){	return x*d;	}
	
	public int getYOnSc(int d){	return y*d;	}

}
