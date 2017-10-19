package com.hakkatoreinbukuma.game;

public class Core {
	public static float[] calcAngle(float x, float y, float v0){
      		float grav = 9.81f;
      		double gyok = Math.sqrt(Math.pow(v0, 4)-grav*(grav*(x*x)+(2*y*(v0*v0))));
        	float megoldas1 = (float)Math.atan(((v0*v0)-gyok)/(grav*x)) * (float)(180f/Math.PI);
      		float megoldas2 = (float)Math.atan(((v0*v0)+gyok)/(grav*x)) * (float)(180f/Math.PI);
    		return new float[] {megoldas1, megoldas2};
    	}
    	public float[] getArc(){
		float[] arc = {1.0f, 1.0f};
        	return arc;
    	}
}
