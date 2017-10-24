package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;

public class ControlStage extends MyStage {
    public GameStage getGameStage() {
        return gameStage;
    }

    GameStage gameStage;

    public ControlStage(Batch batch, MyGdxGame game, final GameStage gameStage) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);
        this.gameStage =gameStage;
	//====================================================================
        Slider slider = new Slider(10,400, 1, false, game.getSliderStyle());
        slider.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameStage.setV(((Slider)actor).getValue());
                System.out.println(((Slider)actor).getValue() + " m/s");
            }
        });
        addActor(slider);
	//====================================================================
	DataActor data = new DataActor();
	addActor(data);
	//====================================================================
        slider.setPosition(getViewport().getWorldWidth()/2-200, getViewport().getWorldHeight()-50);
        slider.setSize(400,20);
        slider.setValue(200);
        setDebugAll(true);
    }

    @Override
    public void init() {

    }
}
