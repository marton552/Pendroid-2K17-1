package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;

public class GameStage extends MyStage {

    public GameStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(1280, 720, new OrthographicCamera(1280,720)), batch, game);
    }

    @Override
    public void init() {

    }

    Agyu agyu = new Agyu();

}
