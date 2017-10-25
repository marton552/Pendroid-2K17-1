package com.hakkatoreinbukuma.game;

public class Core {
	public static float grav = 9.81f;
	public static float d2r = (float)Math.PI/180f;
	public static float r2d = 180f/(float)Math.PI;
	public static float[] calcAngle(float x, float y, float v0){
      		double gyok = Math.sqrt(Math.pow(v0, 4)-grav*(grav*(x*x)+(2*y*(v0*v0))));
        	float megoldas1 = (float)Math.atan(((v0*v0)-gyok)/(grav*x));
      		float megoldas2 = (float)Math.atan(((v0*v0)+gyok)/(grav*x));
    		return new float[] {megoldas1 * r2d, megoldas2 * r2d};
    	}
	public static float calcHeight(float x, float angle, float v0){
		angle *= d2r;
		float sin2_tan = (float) Math.tan(angle) * (float) Math.tan(angle);
		return (float)(x*((-1f*grav)*sin2_tan+2f*(v0*v0)*Math.tan(angle)-(grav*x)))/(2f*(v0*v0));
	}
	public static float calcLowestV0Angle(float x, float y){
		return (float)Math.atan(y/x+Math.sqrt((y*y)/(x*x)+1f)) * r2d;
	}
	public static float calcAngleOfReach(float distance, float v0){
		return (float)Math.asin(grav*distance/(v0*v0))*0.5f * r2d;
	}
	public static float calcMaxHeight(float angle, float v0){
		angle *= d2r;
		float sin2_angle = (float) Math.sin(angle) * (float) Math.sin(angle);
		return (float)((v0*v0)*(sin2_angle))/(2f*grav);
	}
}
