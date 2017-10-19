package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class MyStage {
    abstract public void render(SpriteBatch batch);
    abstract public void update(float dt);
    abstract public void create();
    abstract public void destroy();
}
