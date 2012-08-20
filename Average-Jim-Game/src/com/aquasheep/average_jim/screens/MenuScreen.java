package com.aquasheep.average_jim.screens;

import com.aquasheep.average_jim.AverageJimGame;

public class MenuScreen extends AbstractScreen {
	
	public MenuScreen(AverageJimGame game) {
		super(game);
	}
	
	@Override
	public void show() {
		super.show();

		//Create the menu
		
	}
	
	@Override 
	public void resize(int width, int height) {
		super.resize(width,height);
		game.setScreen(new GameScreen(game));
	}
}
