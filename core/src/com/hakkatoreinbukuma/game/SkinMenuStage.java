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

        cannonSet = new SkinChangeElement(getViewport().getWorldWidth() / 2 - 150, 100, 300, 80, 1, 5, this, game);

        bulletSet = new SkinChangeElement(getViewport().getWorldWidth() / 2 - 150, 190, 300, 80, 2, 5, this, game);

        wheelSet = new SkinChangeElement(getViewport().getWorldWidth() / 2 - 150, 280, 300, 80, 3, 4, this, game);

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
    public void draw() {
        super.draw();
        getBatch().begin();
        getBatch().draw(game.getAgyuTexture(game.agyuTexture), cannonSet.getTextureXY()[0] - game.getAgyuTexture(game.agyuTexture).getWidth() / 2, cannonSet.getTextureXY()[1] - game.getAgyuTexture(game.agyuTexture).getHeight() / 2);
        getBatch().draw(game.getBulletTexture(game.bulletTexture), bulletSet.getTextureXY()[0] - 32, bulletSet.getTextureXY()[1] - 32, 64, 64 );
        getBatch().draw(game.getWheelTexture(game.wheelTexture), wheelSet.getTextureXY()[0] - game.getWheelTexture(game.wheelTexture).getWidth() / 2, wheelSet.getTextureXY()[1] - game.getWheelTexture(game.wheelTexture).getHeight() / 2);
        getBatch().end();
    }

    @Override
    public void init() {

    }
}
