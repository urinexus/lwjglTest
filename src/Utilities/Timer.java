package Utilities;

import org.lwjgl.Sys;

public class Timer {
	private static final float maxmult = 5, minmult = -1;
	private static boolean Paused = false;
	public static long Last, Total;
	public static float d = 0, multiplier = 1;
	
	public static long getTime(){
		return Sys.getTime() * 1000 / Sys.getTimerResolution();
	}
	
	public static float getDelta(){
		long current = getTime();
		int delta = (int) (current - Last);
		Last = current;
		return delta * 0.01f;
	}
	
	public static float Delta(){
		if (Paused) 
			return 0;
		else
			return d * multiplier;
	}
	
	public static float getTotalTime(){
		return Total;
	}
	
	public static float getMultiplier(){
		return multiplier;
	}
	
	public static void setMultiplier(float m){
		if (multiplier+m<minmult || multiplier+m>maxmult){
			
		}else{
			multiplier += m;
		}
	}
	public static void update(){
		d = getDelta();
		Total += d;
	}
	
	public static void Pause(){
		Paused = !Paused;
	}
	

}
