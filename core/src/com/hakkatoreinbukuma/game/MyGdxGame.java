package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Game.MyGame;

public class MyGdxGame extends MyGame {
	SpriteBatch batch;
	Texture agyu;
	Texture kerek;
	Sprite asd;

	public int agyuTexture = 5;

	public Texture getAgyuTexture(){
		if(agyuTexture == 1){
			return Assets.manager.get(Assets.AGYU_1);
		}else if(agyuTexture == 2){
			return Assets.manager.get(Assets.AGYU_2);
		}else if(agyuTexture == 3){
			return Assets.manager.get(Assets.AGYU_3);
		}else if(agyuTexture == 4){
			return Assets.manager.get(Assets.AGYU_4);
		}else{
			return Assets.manager.get(Assets.AGYU_5);
		}
	}

	public Label.LabelStyle getLabelStyle() {
		Label.LabelStyle style;
		style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
		style.font = Assets.manager.get(Assets.ALEGREYAREGULAR_FONT);
		style.fontColor = Color.YELLOW;
		return style;
	}

	public Slider.SliderStyle getSliderStyle(){
		Slider.SliderStyle sliderStyle = new Slider.SliderStyle();
        sliderStyle.knobDown = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BG_TEXTURE),0,0,10,10));
        sliderStyle.knobOver = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BG_TEXTURE),100,120,10,10));
		sliderStyle.knob = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BG_TEXTURE),310,320,10,10));
		sliderStyle.background = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BG_TEXTURE),0,200,400,20));
		return sliderStyle;
	}

	public TextButton.TextButtonStyle getButtonStyle(){
		TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
		buttonStyle.font = Assets.manager.get(Assets.ALEGREYAREGULAR_FONT);
		buttonStyle.fontColor = new Color(1, 1, 1, 1);

		buttonStyle.up = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.WHITE_TEXTURE)));
		buttonStyle.down = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.FULLWHITE_TEXTURE)));
		buttonStyle.over = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.FULLWHITE_TEXTURE)));

		return buttonStyle;
	}

	@Override
	public void create() {
		super.create();
		Assets.prepare();
		setScreen(new LoadingScreen(this));
	}

	/*
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

		float angle = (MathUtils.radiansToDegrees * (float)Math.atan((Gdx.graphics.getHeight() - my) / mx));

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
	*/
}

