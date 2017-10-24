package com.hakkatoreinbukuma.game.MyBaseClasses.UI;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.hakkatoreinbukuma.game.MyBaseClasses.Game.InitableInterface;

import java.awt.Button;

public class MyButton extends TextButton implements InitableInterface {
    public MyButton(String text, TextButtonStyle style) {
        super(text, style);
        setSize(300, 50);
    }

    @Override
    public void init() {

    }
}
