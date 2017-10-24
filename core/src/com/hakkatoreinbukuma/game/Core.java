package com.hakkatoreinbukuma.game;

public class Core {
	public static float grav = 9.81f;
	public static float d2r = (float)Math.PI/180f;
	public static float r2d = 180f/(float)Math.PI;
	public static float[] calcAngle(float x, float y, float v0){
      		double gyok = Math.sqrt(Math.pow(v0, 4)-grav*(grav*(x*x)+(2*y*(v0*v0))));
        	float megoldas1 = (float)Math.atan(((v0*v0)-gyok)/(grav*x))*r2d;
      		float megoldas2 = (float)Math.atan(((v0*v0)+gyok)/(grav*x))*r2d;
    		return new float[] {megoldas1, megoldas2};
    	}
	public static float calcHeight(float x, float angle, float v0){
		angle = d2r*angle;
		float height = (float)(x*((-1f*grav)*(Math.tan(angle)*Math.tan(angle))+2f*(v0*v0)*Math.tan(angle)-(grav*x)))/(2f*(v0*v0));
		return height;
	}
	public static float calcLowestV0Angle(float x, float y){
		return (float)Math.atan(y/x+Math.sqrt((y*y)/(x*x)+1f))*r2d;
	}
	public static float calcAngleOfReach(float distance, float v0){
		return (float)Math.asin(grav*distance/(v0*v0))*0.5f;
	}
	public static float calcMaxHeight(float angle, float v0){
		angle = angle*d2r;
		return (float)((v0*v0)*(Math.sin(angle)*Math.sin(angle)))/(2f*grav);
	}
}
