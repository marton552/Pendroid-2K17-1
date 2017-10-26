package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.Gdx;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyScreen;

public class EndScreen extends MyScreen {
    MyGdxGame game;
    EndStage endStage;

    public EndScreen(MyGdxGame game) {
        super(game);
        this.game = game;
        //GlobalMusic.playMenuMusic();
        endStage = new EndStage(spriteBatch, game);
        Gdx.input.setInputProcessor(endStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        endStage.act(delta);
        endStage.draw();
    }

    @Override
    public void init() {

    }
}
