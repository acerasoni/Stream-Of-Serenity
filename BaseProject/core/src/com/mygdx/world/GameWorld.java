package com.mygdx.world;

import com.badlogic.gdx.Gdx;
import com.mygdx.objects.actors.MainHero;

public class GameWorld {

    private MainHero hero;

    public GameWorld(int midPointY) {
        hero = new MainHero(33, midPointY - 5, 80, 80);
    }

    public void update(float delta) {
        if (hero == null) Gdx.app.log("Yepee", "yopee");
        hero.update(delta);
    }

    public MainHero getHero() {
        return hero;

    }

}
