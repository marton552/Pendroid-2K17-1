package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class DataActor extends Actor {
	BitmapFont font;
	float x = 0;
	float y = 0;
	float v0 = 0;
	float a1 = 0;
	float a2 = 0;
	boolean ok = false;
	boolean show = false;

    public DataActor(){
        font = new BitmapFont();
        font.setColor(0.5f,0.4f,0.2f,1);
    }

    //@Override
    public void draw(SpriteBatch batch) {
         font.draw(batch, "x = " + x, 0, 0);
    }

}
