package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class MenuStage extends MyStage {
    public MenuStage(Batch batch, final MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);

        OneSpriteStaticActor bgActor = new OneSpriteStaticActor(Assets.manager.get(Assets.MENU_BG));

        bgActor.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());

        TextButton playButton = new TextButton("Play", game.getButtonStyle());
        playButton.setSize(300, 70);
        playButton.setPosition(getViewport().getWorldWidth() / 2 - playButton.getWidth() / 2, getViewport().getWorldHeight() - 300);

        playButton.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
            }
        });
        addActor(bgActor);
        addActor(playButton);
    }

    @Override
    public void init() {

    }
}
