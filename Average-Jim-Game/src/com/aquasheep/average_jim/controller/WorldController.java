package com.aquasheep.average_jim.controller;

import java.util.HashMap;
import java.util.Map;

import com.aquasheep.average_jim.model.AbstractWorld;
import com.aquasheep.average_jim.model.Jim;
import com.aquasheep.average_jim.model.Jim.State;

public class WorldController {

	enum  Keys {
		LEFT, RIGHT, JUMP, FIRE;
	}
	
	private AbstractWorld world;
	private Jim jim;
	
	static Map<Keys, Boolean> keys = new HashMap<WorldController.Keys, Boolean>();
	static {
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
		keys.put(Keys.JUMP, false);
		keys.put(Keys.FIRE, false);
	};
	
	public WorldController(AbstractWorld world) {
		this.world = world;
		this.jim = world.getJim();
	}
	
	// ** Key Presses and Touches *************** //
	
	public void leftPressed() {
		keys.get(keys.put(Keys.LEFT, true));
	}
	
	public void rightPressed() {
		keys.get(keys.put(Keys.RIGHT, true));
	}
	
	public void jumpPressed() {
		keys.get(keys.put(Keys.JUMP, true));
	}
	
	public void firePressed() {
		keys.get(keys.put(Keys.FIRE, true));
	}
	
	public void leftReleased() {
		keys.get(keys.put(Keys.LEFT, false));
	}
	
	public void rightReleased() {
		keys.get(keys.put(Keys.RIGHT, false));
	}
	
	public void jumpReleased() {
		keys.get(keys.put(Keys.JUMP, false));
	}
	
	public void fireReleased() {
		keys.get(keys.put(Keys.FIRE, false));
	}
	
	/** The main update method **/
	public void update(float delta) {
		processInput();
		jim.update(delta);
	}
	
	/** Change jim's state based on input **/
	private void processInput() {
		if (keys.get(Keys.LEFT)) {
			//Jim is moving left
			jim.setFacingLeft(true);
			jim.setState(State.WALKING);
			jim.getVelocity().x = -Jim.SPEED;
		}
		if (keys.get(Keys.RIGHT)) {
			//Jim is moving left
			jim.setFacingLeft(false);
			jim.setState(State.WALKING);
			jim.getVelocity().x = Jim.SPEED;
		}
		if ((keys.get(Keys.RIGHT) && keys.get(Keys.LEFT)) || (!keys.get(Keys.RIGHT) && !keys.get(Keys.LEFT))) {
			jim.setState(State.IDLE);
			jim.getAcceleration().x = 0;
			jim.getVelocity().x = 0;
		}
	}
	
}
