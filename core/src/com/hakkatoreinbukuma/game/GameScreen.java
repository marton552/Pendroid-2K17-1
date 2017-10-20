package com.hakkatoreinbukuma.game;

import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyScreen;

/**
 * Created by tanulo on 2017. 10. 20..
 */

public class GameScreen extends MyScreen {



    @Override
    public void init() {

    }

    public GameScreen(MyGdxGame game) {
        super(game);
        new GameStage(spriteBatch, game);
    }
}
