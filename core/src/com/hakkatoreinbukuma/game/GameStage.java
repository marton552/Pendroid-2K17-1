package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.BackgroundActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.ShapeType;
import com.hakkatoreinbukuma.game.MyBaseClasses.UI.MyLabel;

public class GameStage extends MyStage {

    Agyu agyu;
    Kerek kerek;
    Bullet bullet;
    Duck duck;
    BackgroundActor backgroundActor;
	MyLabel label;

    OneSpriteAnimatedActor explode;

	private float v = 100;
	private float x = 100;
	private float y = 100;
	private OneSpriteStaticActor[] dots = new OneSpriteStaticActor[20];

    public boolean isFire = false;

    private float[] fireAngle;
    private float fireX = 30;
    private float fireV;
    private int ellapsedTime = 0;

    private boolean timer = false;
    private int timerTick = 0;

    @Override
    public void act(float delta) {
        super.act(delta);
        duck.act(delta);

        if(timer){
            timerTick++;
            if(timerTick % 60 == 0){
                timerTick = 0;
                game.seconds++;
            }
        }

        ellapsedTime++;
        if(isFire){
            if(ellapsedTime % 1 == 0){
                ellapsedTime = 0;
                fireX = fireX + 8;
                bullet.setPosition(fireX - bullet.getWidth() / 2, Core.calcHeight(fireX, fireAngle[0], fireV) - bullet.getHeight() / 2);
                bullet.setRotation(fireAngle[0]);

                if(bullet.getX() > getViewport().getWorldWidth() + bullet.getWidth()){
                    bullet.setVisible(false);
                    isFire = false;
                }

                if(duck.getBoundingRectangle().overlaps(bullet.getBoundingRect())){
                    System.out.println("Boom");
                    timer = false;
                    explode.setPosition(bullet.getX() + bullet.getWidth() / 2, bullet.getY() + bullet.getHeight() / 2);
                    explode.setVisible(true);
                    explode.start();

                    bullet.setVisible(false);
                    duck.alive = false;
                    isFire = false;
                    Timer timer = new Timer();
                    timer.scheduleTask(new Timer.Task() {
                        @Override
                        public void run() {
                            game.setScreen(new EndScreen(game));
                        }
                    }, 3);
                }
            }
        }
        //Core.calcHeight(pos, floats[ax], v)

    }

    @Override
    public void draw() {
        super.draw();
        getBatch().begin();
        if(duck.alive) {
            duck.draw(getBatch());
        }
        getBatch().end();
    }

    public GameStage(Batch batch, final MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);
        game.seconds = 0;
        backgroundActor = new BackgroundActor(this);

        bullet = new Bullet(game);
        bullet.setVisible(false);
        bullet.setSize(64, 64);

        agyu = new Agyu(game);
        kerek = new Kerek(game);

        duck = new Duck(game, this);
        kerek.setPosition(10, 0);


        label = new MyLabel("Label", game.getLabelStyle());

        explode = new OneSpriteAnimatedActor(Assets.manager.get(Assets.EXPLODE_ATLAS));
        explode.stop();
        explode.setVisible(false);
        explode.setFps(10);
        explode.setFrame(0);
        explode.setLooping(false);
        explode.setSize(128, 128);

        addActor(backgroundActor);
        addActor(agyu);
        addActor(kerek);
        addActor(label);

        //setCameraResetToLeftBottomOfScreen();
        //((OrthographicCamera)getCamera()).zoom = 0.7f;
        //setCameraMoveToXY(128,72,0.5f,0.4f,100);

        addListener(new InputListener(){
            @Override
            public boolean mouseMoved(InputEvent event, float x, float y) {
                //setXY(x,y);
                return super.mouseMoved(event, x, y);
            }


        });
        addListener(new DragListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                setXY(x,y);
                super.touchDragged(event, x, y, pointer);
            }
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                setXY(x,y);
                super.drag(event, x, y, pointer);
            }
            @Override public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                setXY(x,y);
                super.touchDown(event, x, y, pointer, button);
		return true;
            }


        });

        for(int i=0; i<dots.length; i++){
            dots[i] = new OneSpriteStaticActor(Assets.manager.get(Assets.DOT_TEXTURE));
            dots[i].setVisible(false);
            addActor(dots[i]);
        }

        addActor(bullet);
        addActor(explode);

        timer = true;

        agyuChanged();
    }

    public void fire(){
        if(isFire || duck.alive == false){
            return;
        }

        System.out.println("Fire!");
        float saveX = x;
        float saveY = y;
        float saveV = v;
        int ax = 0;
        float[] floats = Core.calcAngle(saveX,saveY,saveV);
        if (Float.isNaN(floats[0]) || Float.isNaN(floats[1])) {
            return;
        }
        GlobalMusic.playShootSound();
        fireAngle = floats;
        fireX = 30;
        fireV = saveV;
        ellapsedTime = 0;
        isFire = true;

        bullet.setVisible(true);

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
	int WORLD_WIDTH = (int)getViewport().getWorldWidth();
	int ax = 0;
        float[] floats = Core.calcAngle(x,y,v);

        if (Float.isNaN(floats[0]) || Float.isNaN(floats[1])){
		label.setText("x  = " + x + "\r\ny  = " + y + "\r\nv0 = " + v + "\r\nTúl messze van!");
       		for(int i=0; i<dots.length; i++){
        	    dots[i].setVisible(false);
	        }
	} else {
		label.setText("x  = " + x + "\r\ny  = " + y + "\r\nv0 = " + v + "\r\na1 = " + floats[0] + "°\r\na2 = " + floats[1] + "°");
		agyu.setAngle(floats[ax]);

		float pos;
       		for(int i=2; i<dots.length; i++){
			pos = (float)(WORLD_WIDTH / dots.length) * (float)i;
        		dots[i].setVisible(true);
			dots[i].setPosition(pos, Core.calcHeight(pos, floats[ax], v));
	        }
		System.out.println(Core.calcHeight(x, floats[ax], v));
		System.out.println("");
	}
	    label.setPosition(2, getViewport().getWorldHeight() - label.getHeight() - 2);
    }


    @Override
    public void init() {

    }

}
