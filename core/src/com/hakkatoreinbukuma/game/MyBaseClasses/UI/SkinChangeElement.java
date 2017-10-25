package com.hakkatoreinbukuma.game.MyBaseClasses.UI;

import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.hakkatoreinbukuma.game.MyGdxGame;
import com.hakkatoreinbukuma.game.SkinMenuStage;

public class SkinChangeElement {
    public SwitchButton prevBtn;
    public SwitchButton fwdBtn;
    public OneSpriteStaticActor bg;

    public SkinChangeElement(float x, float y, float width, float height, SkinMenuStage stage, MyGdxGame game){

        bg = new OneSpriteStaticActor(Assets.manager.get(Assets.WHITE_TEXTURE));
        bg.setSize(width, height);
        bg.setPosition(x, y);

        prevBtn = new SwitchButton("<", game.getButtonStyle());
        prevBtn.setPosition(bg.getX() - prevBtn.getWidth() - 10, bg.getY());
        fwdBtn = new SwitchButton(">", game.getButtonStyle());
        fwdBtn.setPosition(bg.getX() + bg.getWidth() + 10, bg.getY());

        stage.addActor(bg);
        stage.addActor(prevBtn);
        stage.addActor(fwdBtn);

    }
}
