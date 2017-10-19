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
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.Stack;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture agyu;
	Texture kerek;
	Sprite asd;
	Stack<MyStage> stages;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		agyu = new Texture("ágyú.png");
		kerek = new Texture("kerék.png");
		stages = new Stack<MyStage>();

		asd = new Sprite(agyu);
		asd.setRotation(30);

		setStage(new GameStage());
	}

	public void setStage(MyStage stage) {
		stages.pop().destroy();
		stages.push(stage);
		stages.peek().create();
	}

	public void update(float dt){
		stages.peek().update(dt);
	}

	@Override
	public void render () {
		update(Gdx.graphics.getDeltaTime());

		float mx = Gdx.input.getX();
		float my = Gdx.input.getY();

        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		//asd.setRotation(angle);
		//asd.draw(batch);
		//batch.draw(kerek, 25, 0);

		stages.peek().render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		agyu.dispose();
		kerek.dispose();
		stages.peek().destroy();

	}
}

