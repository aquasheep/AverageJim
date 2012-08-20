package com.aquasheep.average_jim.screens;

import com.aquasheep.average_jim.AverageJimGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GLCommon;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;

/** Base screen class */
public abstract class AbstractScreen implements Screen {
	
	protected final SpriteBatch spriteBatch;
	protected final Stage stage;
	protected final AverageJimGame game;
	protected final BitmapFont font;
	
	private TextureAtlas atlas;
	
	public AbstractScreen(AverageJimGame game) {
		this.game = game;
		spriteBatch = new SpriteBatch();
		stage = new Stage();
		font = new BitmapFont();
	}
	
	public TextureAtlas getAtlas(String name) {
		if (atlas==null) {
			atlas = new TextureAtlas(Gdx.files.internal("image-atlases/"+name+".atlas"));
		}
		return atlas;
	}
	
	public String getName() {
		return this.getClass().getSimpleName();
	}
	
	//Screen implementation
	
	@Override
	public void show() {
		//Allow stage to handle input
		Gdx.input.setInputProcessor(stage);
		Gdx.app.log(AverageJimGame.LOG, "Showing screen: "+getName());
	}
	
	@Override
	public void resize(int width, int height) {
		Gdx.app.log(AverageJimGame.LOG, "Resizing screen: "+getName()+" to "+width+","+height);
		
		//Update stage with new screen size
		stage.setViewport(width, height, true);
	}
	
	@Override
	public void render(float delta) {
		GLCommon gl = Gdx.gl;
		gl.glClearColor(0f,0f,0f,1f);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//Update stage and actors
		stage.act(delta);
		stage.draw();
	}
	
	
	@Override
	public void pause() {
		Gdx.app.log(AverageJimGame.LOG, "Pausing screen: "+getName());
	}
	
	@Override
	public void resume() {
		Gdx.app.log(AverageJimGame.LOG, "Resuming screen: "+getName());
	}
	
	@Override
	public void hide() {
		Gdx.app.log(AverageJimGame.LOG, "Hiding screen: "+getName());
		dispose();
	}
	
	@Override
	public void dispose() {
		Gdx.app.log(AverageJimGame.LOG, "Disposing screen: "+getName());
		
		stage.dispose();
		spriteBatch.dispose();
		font.dispose();
	}
}
