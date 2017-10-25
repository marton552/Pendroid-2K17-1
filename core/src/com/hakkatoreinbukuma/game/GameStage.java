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
	private OneSpriteStaticActor[] dots = new OneSpriteStaticActor[20];

    public GameStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);
        agyu = new Agyu(game);
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
            public boolean mouseMoved(InputEvent event, float x, float y) {
                setXY(x,y);
                return super.mouseMoved(event, x, y);
            }


        });
        for(int i=0; i<dots.length; i++){
            dots[i] = new OneSpriteStaticActor(Assets.manager.get(Assets.DOT_TEXTURE));
            addActor(dots[i]);
        }

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
	float WORLD_HEIGHT = getViewport().getWorldWidth();
	int ax = 0;
        float[] floats = Core.calcAngle(x,y,v);
        floats[0] *= Core.r2d;
        floats[1] *= Core.r2d;

        if (Float.isNaN(floats[0]) || Float.isNaN(floats[1])){
		label.setText("x  = " + x + "\r\ny  = " + y + "\r\nv0 = " + v + "\r\nTúl messze van\r\n");
       		for(int i=0; i<dots.length; i++){
        	    dots[i].setVisible(false);
	        }
	} else {
		label.setText("x  = " + x + "\r\ny  = " + y + "\r\nv0 = " + v + "\r\na1 = " + floats[0] + "°\r\na2 = " + floats[1] + "°");
		agyu.setAngle(floats[ax]);
       		for(int i=0; i<dots.length; i++){
        		dots[i].setVisible(true);
			dots[i].setPosition((WORLD_HEIGHT / dots.length) * i, Core.r2d * Core.calcHeight((WORLD_HEIGHT / dots.length) * i, floats[ax], v));
			System.out.println(((WORLD_HEIGHT / dots.length) * i) + " " + Core.r2d * Core.calcHeight((WORLD_HEIGHT / dots.length) * i, floats[ax], v));
	        }
		System.out.println("");
	}
    }

    @Override
    public void init() {

    }


}
