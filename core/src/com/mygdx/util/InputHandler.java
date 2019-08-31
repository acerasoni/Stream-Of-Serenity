package com.mygdx.util;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.objects.MainHero;

public class InputHandler implements InputProcessor {
    private MainHero hero;

    // Ask for a reference to the Bird when InputHandler is created.
    public InputHandler(MainHero hero) {
        // myBird now represents the gameWorld's bird.
        this.hero = hero;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        hero.onClick();
        return true; // Return true to say we handled the touch.
    }

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Input.Keys.LEFT) hero.movingLeft = true;
		if(keycode == Input.Keys.RIGHT) hero.movingRight = true;
		if(keycode == Input.Keys.UP) hero.movingUp = true;
		if(keycode == Input.Keys.DOWN) hero.movingDown = true;

		return true;
	}

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.LEFT) hero.movingLeft = false;
        if (keycode == Input.Keys.RIGHT) hero.movingRight = false;
        if (keycode == Input.Keys.UP) hero.movingUp = false;
        if (keycode == Input.Keys.DOWN) hero.movingDown = false;
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
