package com.mygdx.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
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
    private int prevAnim;
    private float runTime;
    private boolean atk; // false = first attack type, true = second attack type

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

        runTime = 0;
        prevAnim = 1;
        atk = false;
    }

    public void render(float delta) {
        runTime += Gdx.graphics.getDeltaTime();

        MainHero hero = myWorld.getHero();
        moveHero(hero);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        AssetLoader.tiledMapRenderer.setView(cam);
        AssetLoader.tiledMapRenderer.render();

        batcher.begin();
        if (hero.attack) {
            if (prevAnim != 3) {
                runTime = 0;
                prevAnim = 3;
            }
            if(atk) currentA = AssetLoader.atkA;
            else currentA = AssetLoader.atkB;

            TextureRegion curr = currentA.getKeyFrame(runTime);

            if (hero.turned) curr.flip(true, false);
            batcher.draw(curr, hero.getX(), hero.getY(), hero.getWidth(), hero.getHeight());
            if (hero.turned) curr.flip(true, false);
            if (currentA.isAnimationFinished(runTime)) {
                atk = !atk;
                hero.attack = false;
                runTime = 0;
            }
        } else if (hero.moving) {
            prevAnim = 2;
            currentA = AssetLoader.walkA;
            TextureRegion curr = currentA.getKeyFrame(runTime);

            if (hero.turned) curr.flip(true, false);
            batcher.draw(curr, hero.getX(), hero.getY(), hero.getWidth(), hero.getHeight());
            if (hero.turned) curr.flip(true, false);
        } else {
            prevAnim = 1;
            currentA = AssetLoader.idleA;
            TextureRegion curr = currentA.getKeyFrame(runTime);
            if (hero.turned) curr.flip(true, false);
            batcher.draw(curr, hero.getX(), hero.getY(), hero.getWidth(), hero.getHeight());
            if (hero.turned) curr.flip(true, false);
        }
        batcher.end();
    }

    private void moveHero(MainHero hero) {
        float camX = 0, camY = 0;
        if (hero.movingUp) {
            if (hero.getY() < Gdx.graphics.getHeight() / 2)
                hero.setY(hero.getY() + 3f);
            else camY -= 3f;
            cam.translate(0,0,3f);
        }
        if (hero.movingDown) {
            if (hero.getY() > 10)
                hero.setY(hero.getY() - 3f);
            else camY += 3f;
        }
        if (hero.movingRight) {
            if(hero.getX() < Gdx.graphics.getWidth() / 2)
                hero.setX(hero.getX() + 3f);
            else camX -= 3f;
        }
        if (hero.movingLeft) {
            if(hero.getX() > 0)
                hero.setX(hero.getX() - 3f);
            else camX += 3f;
        }

        cam.translate(camX, camY);

        if (hero.movingUp || hero.movingDown || hero.movingRight || hero.movingLeft) hero.moving = true;
        else hero.moving = false;

    }

}

