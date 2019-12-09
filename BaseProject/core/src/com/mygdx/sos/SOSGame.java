package com.mygdx.sos;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.screen.GameScreen;
import com.mygdx.util.AssetLoader;
import org.w3c.dom.Text;


public class SOSGame extends Game {

	@Override
	public void create() {
		Gdx.app.log("HeroGame!", "created");
		AssetLoader.load();
		setScreen(new GameScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}

//	// Objects used
//	Texture walkSheet;
//	SpriteBatch spriteBatch;
//	int currX = 50, currY = 50;
//	// A variable for tracking elapsed time for the animation
//	float stateTime;
//	OrthographicCamera camera;
//	boolean movingUp, movingDown, movingRight, movingLeft, moving;
//
//	@Override
//	public void create() {
//		float w = Gdx.graphics.getWidth();
//		float h = Gdx.graphics.getHeight();
//
//		AssetLoader.load();
//		movingUp = false;
//		movingDown = false;
//		movingRight = false;
//		movingLeft = false;
//		moving = false;
//
//		camera = new OrthographicCamera();
//		camera.setToOrtho(false,w,h);
//		camera.update();
//
//		Gdx.input.setInputProcessor(this);
//
//		// Instantiate a SpriteBatch for drawing and reset the elapsed animation
//		// time to 0
//		spriteBatch = new SpriteBatch();
//		stateTime = 0f;
//	}
//
//	@Override
//	public void render(float runtime) {
//		move();
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
//		spriteBatch.setProjectionMatrix(camera.combined);
//		stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
//		camera.update();
//		// Get current frame of animation for the current stateTime
//
//		TextureRegion currentFrameIdle;
//		TextureRegion currentFrameWalk;
//		currentFrameIdle = (TextureRegion) AssetLoader.walkA.getKeyFrame(runtime);
//		currentFrameWalk = (TextureRegion) AssetLoader.idleA.getKeyFrame(runtime);
//		spriteBatch.begin();
//		if(moving)
//		spriteBatch.draw(currentFrameWalk, currX, currY, 150, 150); // Draw current frame at (50, 50)
//		else spriteBatch.draw(currentFrameIdle, currX, currY, 150, 150);
//		spriteBatch.end();
//	}
//
//	@Override
//	public void dispose() { // SpriteBatches and Textures must always be disposed
//		spriteBatch.dispose();
//		walkSheet.dispose();
//		AssetLoader.dispose();
//	}
//
//	@Override
//	public void resume() {
//
//	}
//@Override
//	public boolean keyUp(int keycode) {
//	if(keycode == Input.Keys.LEFT) movingLeft = false;
//	if(keycode == Input.Keys.RIGHT) movingRight = false;
//	if(keycode == Input.Keys.UP) movingUp = false;
//	if(keycode == Input.Keys.DOWN) movingDown = false;
//		return true;
//	}
//
//	@Override
//	public void pause() {
//
//	}
//
//	@Override
//	public void resize(int x, int y) {
//
//	}
//
//	@Override
//	public boolean keyDown(int keycode) {
//		if(keycode == Input.Keys.LEFT) movingLeft = true;
//		if(keycode == Input.Keys.RIGHT) movingRight = true;
//		if(keycode == Input.Keys.UP) movingUp = true;
//		if(keycode == Input.Keys.DOWN) movingDown = true;
//
//		return true;
//	}
//
//	@Override
//	public boolean keyTyped(char character) {
//
//		return false;
//	}
//
//	@Override
//	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//		return false;
//	}
//
//	@Override
//	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
//		return false;
//	}
//
//	@Override
//	public boolean touchDragged(int screenX, int screenY, int pointer) {
//		return false;
//	}
//
//	@Override
//	public boolean mouseMoved(int screenX, int screenY) {
//		return false;
//	}
//
//	@Override
//	public boolean scrolled(int amount) {
//		return false;
//	}
//
//	private void move() {
//		float moveAmount = 2.0f;
//		if(movingUp) currY+=moveAmount;
//		if(movingDown) currY-=moveAmount;
//		if(movingRight) currX+=moveAmount;
//		if(movingLeft) currX-=moveAmount;
//
//		if(movingUp || movingDown || movingRight || movingLeft) moving = true;
//		else moving = false;
//	}
}