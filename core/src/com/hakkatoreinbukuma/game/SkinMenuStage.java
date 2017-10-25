package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.UI.MyButton;
import com.hakkatoreinbukuma.game.MyBaseClasses.UI.SkinChangeElement;
import com.hakkatoreinbukuma.game.MyBaseClasses.UI.SwitchButton;

public class SkinMenuStage extends MyStage {
    OneSpriteStaticActor bg;
    SkinChangeElement cannonSet;
    SkinChangeElement bulletSet;
    SkinChangeElement wheelSet;

    MyButton menuBtn;


    public SkinMenuStage(Batch batch, final MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);

        bg = new OneSpriteStaticActor(Assets.manager.get(Assets.MENU_BG));
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());

        addActor(bg);

        cannonSet = new SkinChangeElement(getViewport().getWorldWidth() / 2 - 150, 100, 300, 80, this, game);

        bulletSet = new SkinChangeElement(getViewport().getWorldWidth() / 2 - 150, 190, 300, 80, this, game);

        wheelSet = new SkinChangeElement(getViewport().getWorldWidth() / 2 - 150, 280, 300, 80, this, game);

        menuBtn = new MyButton("Menu", game.getButtonStyle());
        menuBtn.setPosition(getViewport().getWorldWidth() / 2 - menuBtn.getWidth() / 2, 10);
        menuBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MenuScreen(game));
            }
        });
        addActor(menuBtn);


    }

    @Override
    public void init() {

    }
}
