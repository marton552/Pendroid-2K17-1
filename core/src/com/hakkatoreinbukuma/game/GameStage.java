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


    private float v = 100;
    private float x = 100;
    private float y = 100;


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
                setXY(x,y);
                return super.mouseMoved(event, x, y);
            }
        });
        agyuChanged();
    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
        agyuChanged();
    }

    public void setV(float v){
        this.v = v;
        agyuChanged();
    }

    protected void agyuChanged(){
        float[] floats = Core.calcAngle(x,y,v);
        agyu.setAngle(floats[1]);
    }

    @Override
    public void init() {

    }


}
