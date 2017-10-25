package com.hakkatoreinbukuma.game.MyBaseClasses.UI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.hakkatoreinbukuma.game.MyGdxGame;
import com.hakkatoreinbukuma.game.SkinMenuStage;

public class SkinChangeElement {
    public SwitchButton prevBtn;
    public SwitchButton fwdBtn;
    public OneSpriteStaticActor bg;

    private int type;
    private int max;
    private MyGdxGame game;

    private float x, y, width, height;

    public SkinChangeElement(float x, float y, float width, float height, int type, int max, SkinMenuStage stage, MyGdxGame game){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.type = type;
        this.max = max;
        this.game = game;

        bg = new OneSpriteStaticActor(Assets.manager.get(Assets.WHITE_TEXTURE));
        bg.setSize(width, height);
        bg.setPosition(x, y);

        prevBtn = new SwitchButton("<", game.getButtonStyle());
        prevBtn.setPosition(bg.getX() - prevBtn.getWidth() - 10, bg.getY());
        prevBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                prevTexture();
            }
        });

        fwdBtn = new SwitchButton(">", game.getButtonStyle());
        fwdBtn.setPosition(bg.getX() + bg.getWidth() + 10, bg.getY());
        fwdBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                nextTexture();
            }
        });
        stage.addActor(bg);
        stage.addActor(prevBtn);
        stage.addActor(fwdBtn);
    }

    public float[] getTextureXY(){
        return new float[] {x + width / 2, y + height / 2};
    }

    public void prevTexture(){
        int current = getCurrentTextureID();

        if(current != 1){
            setCurrentTextureID(current - 1);
        }
    }

    private int getCurrentTextureID(){
        if(type == 1) {
            return game.agyuTexture;
        }else if(type == 2){
            return game.bulletTexture;
        }else if(type == 3){
            return game.wheelTexture;
        }
        return 1;
    }

    private void setCurrentTextureID(int value){
        if(type == 1) {
            game.agyuTexture = value;
        }else if(type == 2){
            game.bulletTexture = value;
        }else if(type == 3){
            game.wheelTexture = value;
        }
    }

    public void nextTexture(){
        int current = getCurrentTextureID();

        if(current != max){
            setCurrentTextureID(current + 1);
        }
    }
}
