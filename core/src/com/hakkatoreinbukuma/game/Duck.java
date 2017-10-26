package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

import java.util.Random;

public class Duck extends Sprite{
    MyGdxGame game;
    GameStage stage;

    private Random r = new Random();

    private int dir = 1; // 1 - bal, 2 - jobb, 3 - balfel, 4 - jobbfel
    private boolean down = true;
    private float downSpeed = 2;
    private float speed = 3;
    private int animSpeed = 50;
    private int animState = 0;
    private int autoFallCount = 0;
    private int autoFallSpeed = 150;

    private int ellapsedTime = 0;

    public boolean alive = true;


    public Duck(MyGdxGame game, GameStage stage) {
        super(Assets.manager.get(Assets.BIRD_LEFT));

        this.game = game;
        this.stage = stage;

        setX((float)stage.getViewport().getWorldWidth() / 2 + r.nextInt((int) stage.getViewport().getWorldWidth() / 2 - 60));
        setY((float)stage.getViewport().getWorldHeight() / 2 + r.nextInt((int) stage.getViewport().getWorldHeight() / 2 - 60));

    }

    private Texture[] getBirdTexture(int direction){
        if(direction == 1){
            return new Texture[]{Assets.manager.get(Assets.BIRD_LEFT), Assets.manager.get(Assets.BIRD_LEFT2)};
        }else if(direction == 2){
            return new Texture[]{Assets.manager.get(Assets.BIRD_RIGHT), Assets.manager.get(Assets.BIRD_RIGHT2)};
        }else if(direction == 3){
            return new Texture[]{Assets.manager.get(Assets.BIRD_LEFTUP), Assets.manager.get(Assets.BIRD_LEFTUP2)};
        }else{
            return new Texture[]{Assets.manager.get(Assets.BIRD_RIGHTUP), Assets.manager.get(Assets.BIRD_RIGHTUP2)};
        }
    }

    public void changeDirection(int direction, boolean d){
        dir = direction;
        down = d;
        setTexture(getBirdTexture(dir)[0]);
    }

    public void act(float delta){
        ellapsedTime++;
        autoFallCount++;

        if(autoFallCount % autoFallSpeed == 0){
            autoFallCount = 0;
            if((dir == 1) || (dir == 2)){
                changeDirection(dir, true);
            }
        }

        if(down){
            setY(getY() - downSpeed);
        }

        if(ellapsedTime % animSpeed == 0){
            ellapsedTime = 0;
            if(animState == 0){
                animState = 1;
            }else{
                animState = 0;
            }
            setTexture(getBirdTexture(dir)[animState]);
        }

        if(dir == 1){
            setX(getX() - speed);
        }else if(dir == 2) {
            setX(getX() + speed);
        }else if(dir == 3) {
            setX(getX() - speed);
            setY(getY() + speed);
        }else if(dir == 4){
            setX(getX() + speed);
            setY(getY() + speed);
        }

        //X tengelyen túlment-e

        if(getX() <= stage.getViewport().getWorldWidth() / 2){
            changeDirection(2, down);
        }

        if(getX() >= stage.getViewport().getWorldWidth() - 80 - r.nextInt(20)){
            changeDirection(1, down);
        }

        //Y tengelyen túlment-e
        if(getY() <= stage.getViewport().getWorldHeight() / 2){
            if(dir == 1) {
                changeDirection(3, false);
            }else if(dir == 2){
                changeDirection(4, false);
            }
        }

        if(getY() >= stage.getViewport().getWorldHeight() - 80 - r.nextInt(20)){
            if(dir == 3){
                changeDirection(1, true);
            }else if(dir == 4){
                changeDirection(2, true);
            }else{
                changeDirection(dir, true);
            }
        }


    }
}
