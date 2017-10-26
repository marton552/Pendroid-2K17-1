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
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class ControlStage extends MyStage {
    public GameStage getGameStage() {
        return gameStage;
    }

    GameStage gameStage;
    private Slider slider;

    public ControlStage(Batch batch, MyGdxGame game, final GameStage gameStage) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);
        this.gameStage =gameStage;

	//====================================================================
        slider = new Slider(10,400, 1, false, game.getSliderStyle());
        slider.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameStage.setV(((Slider)actor).getValue());
                System.out.println(((Slider)actor).getValue() + " m/s");
            }
        });
        slider.setPosition(getViewport().getWorldWidth()/2-200, getViewport().getWorldHeight()-50);
        slider.setSize(400,20);
        slider.setValue(200);

        setDebugAll(true);

        OneSpriteStaticActor fireButton = new OneSpriteStaticActor(Assets.manager.get(Assets.FIREBTN_TEXTURE));
        fireButton.setSize(64, 54);
        fireButton.setPosition(getViewport().getWorldWidth() - fireButton.getWidth() - 10, 10);

        fireButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                gameStage.fire();
            }
        });

        addListener(new DragListener(){
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                if((x >= slider.getX()) && (x <= slider.getX() + slider.getWidth())){
                    if((y >= slider.getY()) && (y <= slider.getY() + slider.getHeight())){
                    }else{
                        gameStage.setXY(x, y);
                    }
                }else{
                    gameStage.setXY(x, y);
                }
                super.drag(event, x, y, pointer);
                /*if(!slider.isDragging()){
                    gameStage.setXY(x, y);
                }else{
                    event.stop();
                }*/
            }
        });


        addActor(slider);
        addActor(fireButton);
    }

    @Override
    public void init() {

    }
}
