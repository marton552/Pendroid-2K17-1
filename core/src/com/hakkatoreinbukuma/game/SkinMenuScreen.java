package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.Gdx;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyScreen;

public class SkinMenuScreen extends MyScreen {
    SkinMenuStage skinMenuStage;

    public SkinMenuScreen(MyGdxGame game) {
        super(game);
        skinMenuStage = new SkinMenuStage(spriteBatch, game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        skinMenuStage.act(delta);
        skinMenuStage.draw();

        Gdx.input.setInputProcessor(skinMenuStage);
    }

    @Override
    public void init() {

    }
}
