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

    public Agyu() {
        super(Assets.manager.get(Assets.AGYU_TEXTURE));
    }

    @Override
    public void init() {

    }

    public void setAngle(float angle) {

        //angle = MathUtils.radiansToDegrees * angle;
        setRotation(angle);
    }
/*
    @Override
    public void destroy() {
    }*/
}
