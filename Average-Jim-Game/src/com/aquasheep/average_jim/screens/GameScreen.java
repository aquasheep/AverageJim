package com.aquasheep.average_jim.screens;

import com.aquasheep.average_jim.AverageJimGame;
import com.aquasheep.average_jim.controller.WorldController;
import com.aquasheep.average_jim.model.World1;
import com.aquasheep.average_jim.view.WorldRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class GameScreen extends AbstractScreen implements InputProcessor {
	
	private World1 world;
	private WorldRenderer renderer;
	private WorldController controller;
	
	private int width,height;
	
	public GameScreen(AverageJimGame game) {
		super(game);
	}
	
	@Override
	public void show() {
		world = new World1();
		renderer = new WorldRenderer(world, true);
		controller = new WorldController(world);
		Gdx.input.setInputProcessor(this);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		controller.update(delta);
		renderer.render();
	}
	
	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
