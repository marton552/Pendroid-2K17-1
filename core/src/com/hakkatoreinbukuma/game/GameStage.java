package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.BackgroundActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class GameStage extends MyStage {

    Agyu agyu;
    BackgroundActor backgroundActor;


    public GameStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);
        agyu = new Agyu();
        backgroundActor = new BackgroundActor(this);

        addActor(backgroundActor);
        addActor(agyu);

        //setCameraResetToLeftBottomOfScreen();
        //((OrthographicCamera)getCamera()).zoom = 0.7f;
        //setCameraMoveToXY(128,72,0.5f,0.4f,100);

        addListener(new InputListener(){
            @Override
            public boolean mouseMoved(InputEvent event, float x, float y) {
                float[] floats = Core.calcAngle(x,y,100f);
                System.out.println(floats[0] + " - " + floats[1]);
                agyu.setAngle(floats[1]);
                return super.mouseMoved(event, x, y);
            }
        });
    }

    @Override
    public void init() {

    }


}
