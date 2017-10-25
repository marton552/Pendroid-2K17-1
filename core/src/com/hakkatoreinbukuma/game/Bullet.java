package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.graphics.Texture;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Bullet extends OneSpriteStaticActor {

    public Bullet(MyGdxGame game) {
        super(game.getBulletTexture(game.bulletTexture));
    }
}
