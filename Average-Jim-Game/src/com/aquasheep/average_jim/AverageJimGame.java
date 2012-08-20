package com.aquasheep.average_jim;

import com.aquasheep.average_jim.screens.SplashScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;

public class AverageJimGame extends Game {
	
	public static final String LOG = "AverageJim Log";
	private FPSLogger fpsLogger;
	
	@Override
	public void create() {
		setScreen(new SplashScreen(this));
		Gdx.app.log(LOG, "Creating game");
		fpsLogger = new FPSLogger();
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log(LOG, "Resizing game to: " + width+","+height);
	}

	@Override
	public void render() {
		super.render();
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
