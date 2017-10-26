package com.hakkatoreinbukuma.game.GlobalClasses;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;


public class Assets {
	// https://github.com/libgdx/libgdx/wiki/Managing-your-assets
	// http://www.jacobplaster.net/using-libgdx-asset-manager
	// https://www.youtube.com/watch?v=JXThbQir2gU
	// https://github.com/Matsemann/libgdx-loading-screen/blob/master/Main/src/com/matsemann/libgdxloadingscreen/screen/LoadingScreen.java

	public static AssetManager manager;



	public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.";


	static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
	static {
		fontParameter.fontFileName = "alegreyaregular.otf";
		fontParameter.fontParameters.size = 30;
		fontParameter.fontParameters.characters = CHARS;
		fontParameter.fontParameters.color = Color.WHITE;
	}
	public static final AssetDescriptor<BitmapFont> ALEGREYAREGULAR_FONT
			= new AssetDescriptor<BitmapFont>(fontParameter.fontFileName, BitmapFont.class, fontParameter);


	//public static final AssetDescriptor<Texture> AGYU_TEXTURE = new AssetDescriptor<Texture>("cannon/cannon5.png", Texture.class);
	public static final AssetDescriptor<Texture> BG_TEXTURE = new AssetDescriptor<Texture>("back2.png", Texture.class);
	public static final AssetDescriptor<Texture> MENU_BG = new AssetDescriptor<Texture>("menu.png", Texture.class);

	public static final AssetDescriptor<Texture> KEREK_1 = new AssetDescriptor<Texture>("kerek/wheel1.png", Texture.class);
	public static final AssetDescriptor<Texture> KEREK_2 = new AssetDescriptor<Texture>("kerek/wheel2.png", Texture.class);
	public static final AssetDescriptor<Texture> KEREK_3 = new AssetDescriptor<Texture>("kerek/wheel3.png", Texture.class);
	public static final AssetDescriptor<Texture> KEREK_4 = new AssetDescriptor<Texture>("kerek/wheel4.png", Texture.class);

	public static final AssetDescriptor<Texture> AGYU_1 = new AssetDescriptor<Texture>("cannon/cannon1.png", Texture.class);
	public static final AssetDescriptor<Texture> AGYU_2 = new AssetDescriptor<Texture>("cannon/cannon2.png", Texture.class);
	public static final AssetDescriptor<Texture> AGYU_3 = new AssetDescriptor<Texture>("cannon/cannon3.png", Texture.class);
	public static final AssetDescriptor<Texture> AGYU_4 = new AssetDescriptor<Texture>("cannon/cannon4.png", Texture.class);
	public static final AssetDescriptor<Texture> AGYU_5 = new AssetDescriptor<Texture>("cannon/cannon5.png", Texture.class);

	public static final AssetDescriptor<Texture> LOVEDEK_1 = new AssetDescriptor<Texture>("bullet/bullet1.png", Texture.class);
	public static final AssetDescriptor<Texture> LOVEDEK_2 = new AssetDescriptor<Texture>("bullet/bullet2.png", Texture.class);
	public static final AssetDescriptor<Texture> LOVEDEK_3 = new AssetDescriptor<Texture>("bullet/bullet3.png", Texture.class);
	public static final AssetDescriptor<Texture> LOVEDEK_4 = new AssetDescriptor<Texture>("bullet/bullet4.png", Texture.class);
	public static final AssetDescriptor<Texture> LOVEDEK_5 = new AssetDescriptor<Texture>("bullet/bullet5.png", Texture.class);

	public static final AssetDescriptor<Texture> ANIM_KACSA = new AssetDescriptor<Texture>("anim/duck.png", Texture.class);
	public static final AssetDescriptor<Texture> ANIM_ROBBANAS = new AssetDescriptor<Texture>("anim/robbanas.png", Texture.class);
	public static final AssetDescriptor<Texture> ANIM_LOADING = new AssetDescriptor<Texture>("atlasok/loading2.png", Texture.class);

	public static final AssetDescriptor<Texture> WHITE_TEXTURE = new AssetDescriptor<Texture>("ui_textures/white.png", Texture.class);
	public static final AssetDescriptor<Texture> FULLWHITE_TEXTURE = new AssetDescriptor<Texture>("ui_textures/fullwhite.png", Texture.class);

	public static final AssetDescriptor<Texture> DOT_TEXTURE = new AssetDescriptor<Texture>("Pont.png", Texture.class);

	public static final AssetDescriptor<TextureAtlas> TITLE_ATLAS = new AssetDescriptor<TextureAtlas>("atlasok/title.atlas", TextureAtlas.class);

	public static final AssetDescriptor<Texture> FIREBTN_TEXTURE = new AssetDescriptor<Texture>("Fire.png", Texture.class);


	//BIRD
	public static final AssetDescriptor<Texture> BIRD_LEFT = new AssetDescriptor<Texture>("bird/left.png", Texture.class);
	public static final AssetDescriptor<Texture> BIRD_LEFT2 = new AssetDescriptor<Texture>("bird/left2.png", Texture.class);

	public static final AssetDescriptor<Texture> BIRD_LEFTUP = new AssetDescriptor<Texture>("bird/leftup.png", Texture.class);
	public static final AssetDescriptor<Texture> BIRD_LEFTUP2 = new AssetDescriptor<Texture>("bird/leftup2.png", Texture.class);

	public static final AssetDescriptor<Texture> BIRD_RIGHT = new AssetDescriptor<Texture>("bird/right.png", Texture.class);
	public static final AssetDescriptor<Texture> BIRD_RIGHT2 = new AssetDescriptor<Texture>("bird/right2.png", Texture.class);

	public static final AssetDescriptor<Texture> BIRD_RIGHTUP = new AssetDescriptor<Texture>("bird/rightup.png", Texture.class);
	public static final AssetDescriptor<Texture> BIRD_RIGHTUP2 = new AssetDescriptor<Texture>("bird/rightup2.png", Texture.class);



	public static void prepare() {
		manager = new AssetManager();
		Texture.setAssetManager(manager);
	}

	public static void load() {
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));


//		manager.load(AGYU_TEXTURE);
		manager.load(BG_TEXTURE);
		manager.load(MENU_BG);

		manager.load(KEREK_1);
		manager.load(KEREK_2);
		manager.load(KEREK_3);
		manager.load(KEREK_4);

		manager.load(AGYU_1);
		manager.load(AGYU_2);
		manager.load(AGYU_3);
		manager.load(AGYU_4);
		manager.load(AGYU_5);

		manager.load(LOVEDEK_1);
		manager.load(LOVEDEK_2);
		manager.load(LOVEDEK_3);
		manager.load(LOVEDEK_4);
		manager.load(LOVEDEK_5);

		manager.load(ANIM_KACSA);
		manager.load(ANIM_LOADING);
		manager.load(ANIM_ROBBANAS);

		manager.load(WHITE_TEXTURE);
		manager.load(FULLWHITE_TEXTURE);

		manager.load(DOT_TEXTURE);

		manager.load(TITLE_ATLAS);

		manager.load(FIREBTN_TEXTURE);

		manager.load(BIRD_LEFT);
		manager.load(BIRD_LEFT2);

		manager.load(BIRD_LEFTUP);
		manager.load(BIRD_LEFTUP2);

		manager.load(BIRD_RIGHT);
		manager.load(BIRD_RIGHT2);

		manager.load(BIRD_RIGHTUP);
		manager.load(BIRD_RIGHTUP2);




		manager.load(ALEGREYAREGULAR_FONT);

	}

    public static void afterLoaded() {
        //manager.get(MUSIC).setLooping(true);
    }

	public static void unload() {
		manager.dispose();
	}

}
