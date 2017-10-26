package com.hakkatoreinbukuma.game;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;

import java.util.Random;

public class GlobalMusic {
    MyGdxGame game;
    private static Random r = new Random();
    public static Sound click = Assets.manager.get(Assets.CLICK_SOUND);
    public static Sound shoot = Assets.manager.get(Assets.LOVES_SOUND);
    public static Music menuMusic = Assets.manager.get(Assets.MENU_MUSIC);

    public static boolean gameMusicPlaying = false;
    public static boolean menuMusicPlaying = false;
    public static Music thisMusic;


    public static void playClickSound(){
        click.setVolume(click.play(), 0.8f);
    }

    public static void playMenuMusic(){
        if(gameMusicPlaying) {
            thisMusic.stop();
        }

        menuMusic.play();

        menuMusic.setLooping(true);
        menuMusic.setVolume(1);
    }

    public static void playGameMusic(){
        //if(menuMusicPlaying) {
            menuMusic.stop();
        //    menuMusicPlaying = false;
        //}

        playMusic();
    }

    public static void playShootSound(){
        shoot.setVolume(shoot.play(), 1);
    }

    private static void playMusic(){
        int music = r.nextInt(3);

        gameMusicPlaying = true;

        if(music == 0){
            thisMusic = Assets.manager.get(Assets.GAME_MUSIC);
        }else if(music == 1){
            thisMusic = Assets.manager.get(Assets.GAME2_MUSIC);
        }else {
            thisMusic = Assets.manager.get(Assets.GAME3_MUSIC);
        }

        thisMusic.play();
        thisMusic.setVolume(0.8f);
        thisMusic.setLooping(false);
        thisMusic.setOnCompletionListener(new Music.OnCompletionListener() {
            @Override
            public void onCompletion(Music music) {
                playMusic();
            }
        });
    }

}
