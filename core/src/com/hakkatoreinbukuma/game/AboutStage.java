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

public class AboutStage extends MyStage {

    MyGdxGame game;

    OneSpriteStaticActor bgActor;
    MyLabel label;
    MyButton button;


    public AboutStage(Batch batch, final MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);
        this.game = game;

        bgActor = new OneSpriteStaticActor(Assets.manager.get(Assets.MENU_BG));
        bgActor.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        addActor(bgActor);

        label = new MyLabel("A játék célja, hogy minél hamarabb lelődd a kacsát.\nDe célozz pontosan, mert a madár igen gyors.\nA felső csúszkával tudod állítani a lövés erősségét.", game.getLabelStyle());
        label.setAlignment(Align.center);
        label.setPosition(getViewport().getWorldWidth() / 2 - label.getWidth() / 2, 180);
        addActor(label);

        button = new MyButton("Menu", game.getButtonStyle());
        button.setPosition(getViewport().getWorldWidth() / 2 - button.getWidth() / 2, 60);

        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MenuScreen(game));
            }
        });

        addActor(button);
    }

    @Override
    public void init() {

    }
}
