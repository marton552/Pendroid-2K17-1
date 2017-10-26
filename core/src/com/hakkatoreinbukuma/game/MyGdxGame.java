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

	public int agyuTexture = 1;
	public int bulletTexture = 1;
	public int wheelTexture = 1;

	public int seconds = 0;

	public Texture getAgyuTexture(int textureID){
		if(textureID == 1){
			return Assets.manager.get(Assets.AGYU_1);
		}else if(textureID == 2){
			return Assets.manager.get(Assets.AGYU_2);
		}else if(textureID == 3){
			return Assets.manager.get(Assets.AGYU_3);
		}else if(textureID == 4){
			return Assets.manager.get(Assets.AGYU_4);
		}else{
			return Assets.manager.get(Assets.AGYU_5);
		}
	}

	public Texture getBulletTexture(int textureID){
		if(textureID == 1){
			return Assets.manager.get(Assets.LOVEDEK_1);
		}else if(textureID == 2){
			return Assets.manager.get(Assets.LOVEDEK_2);
		}else if(textureID == 3){
			return Assets.manager.get(Assets.LOVEDEK_3);
		}else if(textureID == 4){
			return Assets.manager.get(Assets.LOVEDEK_4);
		}else{
			return Assets.manager.get(Assets.LOVEDEK_5);
		}
	}

	public Texture getWheelTexture(int textureID){
		if(textureID == 1){
			return Assets.manager.get(Assets.KEREK_1);
		}else if(textureID == 2){
			return Assets.manager.get(Assets.KEREK_2);
		}else if(textureID == 3){
			return Assets.manager.get(Assets.KEREK_3);
		}else{
			return Assets.manager.get(Assets.KEREK_4);
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


}

