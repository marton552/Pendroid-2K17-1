package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Agyu extends OneSpriteStaticActor {
    float angle = 0;

    boolean isBlinking = false;

    public Agyu() {
        super(Assets.manager.get(Assets.AGYU_5));
    }

    @Override
    public void init() {

    }

    public void setBlinking(boolean blinking){
        isBlinking = blinking;
        if (!isBlinking){
            setVisible(true);
        }
    }

    public void setAngle(float angle) {

        //angle = MathUtils.radiansToDegrees * angle;


        if (!Float.isNaN(angle)) {
            setRotation(angle);
            setBlinking(false);
        }else{
            setBlinking(true);
        }
    }


    @Override
    public void act(float delta) {
        super.act(delta);
        if (isBlinking){
            setVisible(((int)(elapsedTime*8))%2==0);
        }
    }

    /*
    @Override
    public void destroy() {
    }*/
}
