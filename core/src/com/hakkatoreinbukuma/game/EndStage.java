package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.UI.MyButton;
import com.hakkatoreinbukuma.game.MyBaseClasses.UI.MyLabel;

public class EndStage extends MyStage {

    OneSpriteStaticActor bgActor;
    MyLabel label;
    MyButton btn;


    public EndStage(Batch batch, final MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);
        bgActor = new OneSpriteStaticActor(Assets.manager.get(Assets.MENU_BG));
        bgActor.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());

        label = new MyLabel("Sikeresen lelőtted a kacsát!\n"+game.seconds+" másodperc alatt sikerült lelőnöd.", game.getLabelStyle());
        label.setAlignment(Align.center);
        label.setPosition(getViewport().getWorldWidth() / 2 - label.getWidth() / 2, 150);

        btn = new MyButton("Menu", game.getButtonStyle());
        btn.setPosition(getViewport().getWorldWidth() / 2 - btn.getWidth() / 2, 10);
        btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MenuScreen(game));
            }
        });

        addActor(bgActor);
        addActor(label);
        addActor(btn);

    }

    @Override
    public void init() {

    }
}
