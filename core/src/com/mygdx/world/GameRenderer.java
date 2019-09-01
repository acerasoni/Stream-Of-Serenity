package com.mygdx.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.objects.MainHero;
import com.mygdx.util.AssetLoader;

public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private Animation<TextureRegion> currentA;
    private SpriteBatch batcher;

    private int midPointY;
    private int gameHeight;

    public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
        myWorld = world;

        // The word "this" refers to this instance.
        // We are setting the instance variables' values to be that of the
        // parameters passed in from GameScreen.
        this.gameHeight = gameHeight;
        this.midPointY = midPointY;

        cam = new OrthographicCamera();
        cam.setToOrtho(false, 1080, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void render(float runTime) {
        MainHero hero = myWorld.getHero();
        if (hero.movingUp) hero.setY(hero.getY() + 3f);
        if (hero.movingDown) hero.setY(hero.getY() - 3f);
        if (hero.movingRight) hero.setX(hero.getX() + 3f);
        if (hero.movingLeft) hero.setX(hero.getX() - 3f);
        if (hero.movingUp || hero.movingDown || hero.movingRight || hero.movingLeft) hero.moving = true;
        else hero.moving = false;

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        batcher.begin();
        if (hero.attack) {
            currentA = AssetLoader.atkA;
            batcher.draw(currentA.getKeyFrame(runTime),
                    hero.getX(), hero.getY(), 90, 90);
            if(currentA.isAnimationFinished(runTime)) {
                hero.attack = false;
            }
        } else if (hero.moving) {
            currentA = AssetLoader.walkA;
            batcher.draw(currentA.getKeyFrame(runTime),
                    hero.getX(), hero.getY(), 90, 90);
        } else {
           currentA = AssetLoader.idleA;
            batcher.draw(currentA.getKeyFrame(runTime),
                    hero.getX(), hero.getY(), 90, 90);
        }
        batcher.end();
    }
}

