package com.mygdx.objects.actors;

import com.badlogic.gdx.math.Vector2;

public class MainHero {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private float rotation; // For handling bird rotation
    private int width;
    private int height;

    public boolean movingUp, movingDown, movingRight, movingLeft, moving, attack, turned;

    public MainHero(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        movingUp = false;
		movingDown = false;
		movingRight = false;
		movingLeft = false;
		moving = false;
        attack = false;
        turned = false;

        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);
    }

    public void update(float delta) {
        velocity.add(acceleration.cpy().scl(delta));

//        if (velocity.y > 200) {
//            velocity.y = 200;
//        }

        position.add(velocity.cpy().scl(delta));

    }

    public void onClick() {
        // velocity.y = -140;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void setX(float x) {
        this.position.x = x;
    }

    public void setY(float y) {
        this.position.y = y;
    }

}
