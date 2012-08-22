package com.aquasheep.average_jim.model;

import com.aquasheep.average_jim.model.Jim.State;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {

	public enum State {
		MOVING,DYING
	}
	
	public static final float SPEED = (float) 4f;
	public static final float JUMP_VELOCITY = 1f;
	public static final float SIZE = 0.5f;
	
	private Vector2 	position = new Vector2();
	private Vector2 	velocity = new Vector2();
	private Vector2 	acceleration = new Vector2();
	private Rectangle	bounds = new Rectangle();
	private State 		state = State.MOVING;
	private boolean	facingLeft = true;
	
	public Asteroid(Vector2 pos) {
		this.position = pos;
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void update(float delta) {
		position.add(velocity.tmp().mul(delta));
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setState(State newState) {
		state = newState;
	}

	public void setFacingLeft(boolean b) {
		facingLeft = b;
	}

	public Vector2 getAcceleration() {
		return acceleration;
	}
	
}
