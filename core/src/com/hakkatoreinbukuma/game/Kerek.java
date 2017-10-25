package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.graphics.Texture;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Kerek extends OneSpriteStaticActor {

    public Kerek(MyGdxGame game) {
        super(game.getWheelTexture(game.wheelTexture));
    }
}
