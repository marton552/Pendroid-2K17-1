package com.hakkatoreinbukuma.game.MyBaseClasses.UI;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.hakkatoreinbukuma.game.MyBaseClasses.Game.InitableInterface;

public class SwitchButton extends TextButton implements InitableInterface {
    public SwitchButton(String text, TextButtonStyle style) {
        super(text, style);
        setSize(30, 80);
    }

    @Override
    public void init() {

    }
}
