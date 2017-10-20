package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyActor;

public class Agyu extends MyActor {
    float angle = 0;
    Texture texture = new Texture("agyu");

    @Override
    public void init() {

    }
/*
    @Override
    public void update(float dt) {
        float mx = Gdx.input.getX();
        float my = Gdx.input.getY();

        angle = (MathUtils.radiansToDegrees * (float)Math.atan((Gdx.graphics.getHeight() - my) / mx));
        setRotation(angle);
    }

    @Override
    public void destroy() {
    }*/
}
