package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
		Vector2 mouse = new Vector2(mx, my);
		Vector2 agyuv = new Vector2(0, 0);
		Vector2 ang = mouse - agyuv;
		float angle = (float)Math.toDegrees(Math.atan2(my - asd.getY(), mx - asd.getX()));


		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		asd.setRotation(angle);
		asd.draw(batch);


		batch.draw(kerek, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		agyu.dispose();
		kerek.dispose();

	}
}

