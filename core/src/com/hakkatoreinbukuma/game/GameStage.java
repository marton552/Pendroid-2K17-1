package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GameStage extends MyStage{

    Agyu agyu;
    Kerek kerek;

    @Override
    public void render(SpriteBatch batch) {
        agyu.draw(batch, 1.0f);
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void create() {
        agyu = new Agyu();
        agyu.setPosition(0, 0);
        Actor asd = new Actor();
    }

    @Override
    public void destroy() {
        agyu.destroy();
    }
}
