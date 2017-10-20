package com.hakkatoreinbukuma.game.MyBaseClasses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2017. 10. 20..
 */

public class BackgroundActor extends OneSpriteStaticActor {
    public BackgroundActor(Stage stage) {
        super(Assets.manager.get(Assets.BG_TEXTURE));
        setSize(stage.getViewport().getWorldWidth(), stage.getViewport().getWorldHeight());
    }

    @Override
    public void init() {
        super.init();
    }
}
