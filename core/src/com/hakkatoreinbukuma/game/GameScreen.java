package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyScreen;

public class GameScreen extends MyScreen {


    GameStage gameStage;
    ControlStage controlStage;

    @Override
    public void init() {

    }

    public GameScreen(MyGdxGame game) {
        super(game);
        GlobalMusic.playGameMusic();
        gameStage = new GameStage(spriteBatch, game);
        controlStage = new ControlStage(spriteBatch, game, gameStage);
        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(gameStage);
        inputMultiplexer.addProcessor(controlStage);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        gameStage.act(delta);
        gameStage.draw();
        controlStage.act(delta);
        controlStage.draw();
    }
}
