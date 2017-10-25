package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.BackgroundActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.UI.MyLabel;

public class GameStage extends MyStage {

    Agyu agyu;
    BackgroundActor backgroundActor;
	MyLabel label;
	private float v = 100;
	private float x = 100;
	private float y = 100;
	private OneSpriteStaticActor[20] dots;

    public GameStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);
        agyu = new Agyu();
        backgroundActor = new BackgroundActor(this);

        label = new MyLabel("Label", game.getLabelStyle());

        addActor(backgroundActor);
        addActor(agyu);
        addActor(label);
        //setCameraResetToLeftBottomOfScreen();
        //((OrthographicCamera)getCamera()).zoom = 0.7f;
        //setCameraMoveToXY(128,72,0.5f,0.4f,100);

        addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);

            }

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
	if (Float.isNaN(floats[0]) || Float.isNaN(floats[1])){
		label.setText("x  = " + x + "\r\ny  = " + y + "\r\nv0 = " + v + "\r\nTúl messze van\r\n");
	} else {
		label.setText("x  = " + x + "\r\ny  = " + y + "\r\nv0 = " + v + "\r\na1 = " + floats[0] + "°\r\na2 = " + floats[1] + "°");
		agyu.setAngle(floats[1]);
	}
    }

    @Override
    public void init() {

    }


}
