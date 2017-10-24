package com.hakkatoreinbukuma.game;

public class Core {
	public static float grav = 9.81f;
	public static float[] calcAngle(float x, float y, float v0){
      		double gyok = Math.sqrt(Math.pow(v0, 4)-grav*(grav*(x*x)+(2*y*(v0*v0))));
        	float megoldas1 = (float)Math.atan(((v0*v0)-gyok)/(grav*x)) * (float)(180f/Math.PI);
      		float megoldas2 = (float)Math.atan(((v0*v0)+gyok)/(grav*x)) * (float)(180f/Math.PI);
    		return new float[] {megoldas1, megoldas2};
    	}
	public static float calcHeight(float x, float angle, float v0){
		angle = (float)Math.PI/180f*angle;
		float height = (float)(x*((-1f*grav)*(Math.tan(angle)*Math.tan(angle))+2f*(v0*v0)*Math.tan(angle)-(grav*x)))/(2f*(v0*v0));
		return height;
	}
}
