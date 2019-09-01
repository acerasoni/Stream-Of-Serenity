package com.mygdx.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class AssetLoader {

    public static Texture texture;
    public static TextureAtlas atlas;
    public static TiledMap tiledMap;
    public static TiledMapRenderer tiledMapRenderer;

    public static Animation idleA;
    public static Animation walkA;
    public static Animation atkA;

    public static void load() {
        tiledMap = new TmxMapLoader().load("tfjungle/timefantasyjungle.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, 3f);

        atlas = new TextureAtlas(Gdx.files.internal("side/testerino.atlas"));

        TextureRegion[] idle = new TextureRegion[3], walk = new TextureRegion[3], attack = new TextureRegion[3];
        idle[0] = (atlas.findRegion("1_1idle2 (1)"));
        idle[1] = (atlas.findRegion("1_1idle2 (2)"));
        idle[2] = (atlas.findRegion("1_1idle2 (3)"));

        walk[0] = (atlas.findRegion("1_1_walk (1)"));
        walk[1] = (atlas.findRegion("1_1_walk (2)"));
        walk[2] = (atlas.findRegion("1_1_walk (3)"));

        attack[0] = (atlas.findRegion("1_1_atk1 (1)"));
        attack[1] = (atlas.findRegion("1_1_atk1 (2)"));
        attack[2] = (atlas.findRegion("1_1_atk1 (3)"));
//        attack[3] = (atlas.findRegion("1_1_atk2 (1)"));
//        attack[4] = (atlas.findRegion("1_1_atk2 (2)"));
//        attack[5] = (atlas.findRegion("1_1_atk2 (3)"));

        // Initialize the Animation with the frame interval and array of frames
        walkA = new Animation(0.25f, walk);
        idleA = new Animation(0.25f, idle);
        atkA = new Animation(0.25f, attack);

        walkA.setPlayMode(Animation.PlayMode.LOOP);
        idleA.setPlayMode(Animation.PlayMode.LOOP);
        atkA.setPlayMode(Animation.PlayMode.NORMAL);
    }

    public static void dispose() {
        // We must dispose of the texture when we are finished.
        texture.dispose();
    }

}
