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

    public static void load() {
        tiledMap = new TmxMapLoader().load("tfjungle/timefantasyjungle.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, 3f);

        atlas = new TextureAtlas(Gdx.files.internal("side/testerino.atlas"));

        TextureRegion[] idle = new TextureRegion[3], walk = new TextureRegion[3];
        idle[0] = (atlas.findRegion("1_1_idle1 (1)"));
        idle[1] = (atlas.findRegion("1_1_idle1 (2)"));
        idle[2] = (atlas.findRegion("1_1_idle1 (3)"));

        walk[0] = (atlas.findRegion("1_1_walk1 (1)"));
        walk[1] = (atlas.findRegion("1_1_walk1 (2)"));
        walk[2] = (atlas.findRegion("1_1_walk1 (3)"));

        // Initialize the Animation with the frame interval and array of frames
        walkA = new Animation(0.1f, walk);
        idleA = new Animation(0.1f, idle);
        walkA.setPlayMode(Animation.PlayMode.LOOP);
        idleA.setPlayMode(Animation.PlayMode.LOOP);
    }

    public static void dispose() {
        // We must dispose of the texture when we are finished.
        texture.dispose();
    }

}
