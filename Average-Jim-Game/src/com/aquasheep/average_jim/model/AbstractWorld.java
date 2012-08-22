package com.aquasheep.average_jim.model;

import com.badlogic.gdx.utils.Array;

public abstract class AbstractWorld {
	
	Array<Asteroid> asteroids = new Array<Asteroid>();
	Array<Block> blocks = new Array<Block>();
	Array<Citizen> citizens = new Array<Citizen>();
	Jim jim;
	
	//Accessors
	public Array<Asteroid> getAsteroids() {
		return asteroids;
	}
	
	public Array<Block> getBlocks() {
		return blocks;
	}
	
	public Array<Citizen> getCitizens() {
		return citizens;
	}
	
	public Jim getJim() {
		return jim;
	}
	//------------------------------------------
	public AbstractWorld() {
		
	}
	
	public void updateAsteroids() {
		
	}
	
	public void updateCitizens() {
		
	}
	
}
