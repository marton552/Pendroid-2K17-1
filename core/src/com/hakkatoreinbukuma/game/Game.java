package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture agyu;
	Texture kerek;
	Sprite asd;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		agyu = new Texture("ágyú.png");
		kerek = new Texture("kerék.png");

		asd = new Sprite(agyu);
		asd.setRotation(30);


	}

	@Override
	public void render () {
		float mx = Gdx.input.getX();
		float my = Gdx.input.getY();
		//float angle = (float) Math.asin(Math.sqrt(mx*mx + my*my));
		//float angle = (float) Math.atan(my / mx);
		float pos1 = 0;
		float pos2 = 0;

		float angle = (MathUtils.radiansToDegrees * (float)Math.atan((Gdx.graphics.getHeight() - my) / mx));

		//int deltaX = x2 - x1;
		//int deltaY = y2 - y1;
		//int rad = Math.atan2(deltaY, deltaX);

        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		asd.setRotation(angle);
		asd.draw(batch);


		batch.draw(kerek, 25, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		agyu.dispose();
		kerek.dispose();

	}
}

