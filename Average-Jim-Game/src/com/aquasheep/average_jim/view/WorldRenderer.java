package com.aquasheep.average_jim.view;

import com.aquasheep.average_jim.model.AbstractWorld;
import com.aquasheep.average_jim.model.Asteroid;
import com.aquasheep.average_jim.model.Block;
import com.aquasheep.average_jim.model.Citizen;
import com.aquasheep.average_jim.model.Jim;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class WorldRenderer {
	private static final float CAMERA_WIDTH = 10f;
	private static final float CAMERA_HEIGHT = 7f;
	
	private AbstractWorld world; //will be instantiated as the actual world used
	private OrthographicCamera cam;
	
	/** For debug rendering **/
	ShapeRenderer debugRenderer = new ShapeRenderer();
	
	/** Textures **/
	private Texture jimTexture;
	private Texture citizenTexture;
	private Texture asteroidTexture;
	private Texture blockTexture;
	
	private SpriteBatch spriteBatch;
	private boolean debug = false;
	private int width,height;
	private float ppuX,ppuY;//Pixels per unit
	
	public WorldRenderer(AbstractWorld world,boolean debug) {
		this.world = world;
		cam = new OrthographicCamera(CAMERA_WIDTH,CAMERA_HEIGHT);
		cam.position.set(CAMERA_WIDTH/2f,CAMERA_HEIGHT/2f,0);
		cam.update();
		this.debug = debug;
		spriteBatch = new SpriteBatch();
		if (!debug)
			loadTextures();		
	}
	
	public void setSize(int w, int h) {
		width = w;
		height = h;
		ppuX = (float)width/CAMERA_WIDTH;
		ppuY = (float)height/CAMERA_HEIGHT;
	}
	
	public void loadTextures() {
		jimTexture = new Texture(Gdx.files.internal("images/jim_01.png"));
		citizenTexture = new Texture(Gdx.files.internal("images/citizen_01.png"));
		asteroidTexture = new Texture(Gdx.files.internal("images/asteroid_01.png"));
		blockTexture = new Texture(Gdx.files.internal("block.png"));
	}
	
	public void render() {
		if (!debug) {
			spriteBatch.begin();
				drawBlocks();
				drawJim();
//				drawAsteroids();
//				drawCitizens();
			spriteBatch.end();
		} else
			drawDebug();
	}
	
	private void drawBlocks() {
		for (Block block : world.getBlocks()) {
			spriteBatch.draw(blockTexture, block.getPosition().x*ppuX, block.getPosition().y*ppuY,block.SIZE*ppuX,block.SIZE*ppuY);
		}
	}
	
	private void drawJim() {
		Jim jim = world.getJim();
		spriteBatch.draw(jimTexture, jim.getPosition().x*ppuX,jim.getPosition().y*ppuY,Jim.SIZE*ppuX,Jim.SIZE*ppuY);
	}
	
//	private void drawAsteroids() {
//		world.updateAsteroids();
//		for (Asteroid roid : world.getAsteroids()) {
//			spriteBatch.draw(asteroidTexture,roid.getPosition().x*ppuX,roid.getPosition().y*ppuY,roid.SIZE*ppuX,roid.SIZE*ppuY);
//		}
//	}
//	
//	private void drawCitizens() {
//		world.updateCitizens();
//		for (Citizen cit : world.getCitizens()) {
//			spriteBatch.draw(citizenTexture,cit.getPosition().x*ppuX,cit.getPosition().y*ppuY,Citizen.SIZE*ppuX,Citizen.SIZE*ppuY);
//		}
//	}
	
	private void drawDebug() {
		debugRenderer.setProjectionMatrix(cam.combined);
		debugRenderer.begin(ShapeType.Rectangle);
			
			//Render world blocks
			for (Block block : world.getBlocks()) {
				Rectangle rect = block.getBounds();
				float x1 = block.getPosition().x + rect.x;
				float y1 = block.getPosition().y + rect.y;
				debugRenderer.setColor(1, 0, 0, 1);
				debugRenderer.rect(x1, y1, rect.width, rect.height);
			}
			
			//Render Jim
			Jim jim = world.getJim();
			Rectangle rect = jim.getBounds();
			float x1 = jim.getPosition().x + rect.x;
			float y1 = jim.getPosition().y + rect.y;
			debugRenderer.setColor(0, 1, 0, 1);
			debugRenderer.rect(x1, y1, rect.width, rect.height);
			
//			//Render Asteroids
//			world.updateAsteroids();
//			for (Asteroid roid : world.getAsteroids()) {
//				rect = roid.getBounds();
//				x1 = roid.getPosition().x + rect.x;
//				y1 = roid.getPosition().y + rect.y;
//				debugRenderer.setColor(0,0,1,1);
//				debugRenderer.rect(x1,y1,rect.width,rect.height);
//			}
//			
//			//Render Citizens
//			world.updateCitizens();
//			for (Citizen cit : world.getCitizens()) {
//				rect = cit.getBounds();
//				x1 = cit.getPosition().x + rect.x;
//				y1 = cit.getPosition().y + rect.y;
//				debugRenderer.setColor(1,1,0,1);
//				debugRenderer.rect(x1,y1,rect.width,rect.height);
//			}
			
		debugRenderer.end();
	}
}
