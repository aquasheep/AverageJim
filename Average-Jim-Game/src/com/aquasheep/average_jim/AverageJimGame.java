package com.aquasheep.average_jim;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;

public class AverageJimGame implements ApplicationListener {
	
	public static final String LOG = "AverageJimGame Log";
	private FPSLogger fpsLogger;
	
	@Override
	public void create() {
		Gdx.app.log(LOG, "Creating game");
		fpsLogger = new FPSLogger();
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log(LOG, "Resizing game to: " + width+","+height);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1f,0f,0f,1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		fpsLogger.log();
	}

	@Override
	public void pause() {
		Gdx.app.log(LOG, "Pausing game");
	}

	@Override
	public void resume() {
		Gdx.app.log(LOG, "Resuming game");
	}

	@Override
	public void dispose() {
		Gdx.app.log(LOG, "Disposing game");
	}
	
}
