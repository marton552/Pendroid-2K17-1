package com.hakkatoreinbukuma.game.MyBaseClasses.UI;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.hakkatoreinbukuma.game.GlobalMusic;
import com.hakkatoreinbukuma.game.MyBaseClasses.Game.InitableInterface;

public class SwitchButton extends TextButton implements InitableInterface {
    public SwitchButton(String text, TextButtonStyle style) {
        super(text, style);
        setSize(30, 80);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                //click hang
                GlobalMusic.playClickSound();
            }
        });
    }

    @Override
    public void init() {

    }
}
