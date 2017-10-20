package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;

/**
 * Created by tanulo on 2017. 10. 20..
 */

public class ControlStage extends MyStage {
    public GameStage getGameStage() {
        return gameStage;
    }

    GameStage gameStage;

    public ControlStage(Batch batch, MyGdxGame game, GameStage gameStage) {
        super(new FitViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);
        this.gameStage =gameStage;
        Slider slider = new Slider(10, 200, 1, false, game.getSliderStyle());
        slider.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                System.out.println("Slider Klikk");
            }
        });
        addActor(slider);
    }

    @Override
    public void init() {

    }
}
