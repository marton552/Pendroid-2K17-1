package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyScreen;


public class LoadingScreen extends MyScreen {


    public LoadingScreen(MyGdxGame game) {
		super(game);
    }
	BitmapFont bitmapFont = new BitmapFont();

	 @Override
	public void show() {
	    Assets.manager.finishLoading();
		Assets.load();
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		spriteBatch.begin();
		bitmapFont.draw(spriteBatch,"Betöltés: " + Assets.manager.getLoadedAssets() + "/" + (Assets.manager.getQueuedAssets()+ Assets.manager.getLoadedAssets()) + " (" + ((int)(Assets.manager.getProgress()*100f)) + "%)", Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
		spriteBatch.end();
		if (Assets.manager.update()) {
			Assets.afterLoaded();
			game.setScreen(new MenuScreen(game));
		}
	}

	@Override
	public void hide() {

	}

	@Override
	public void init() {
		setBackGroundColor(0f, 0f, 0f);
	}
}
