package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class MyActor extends Actor {
    abstract public void update(float dt);
    abstract public void destroy();
}
