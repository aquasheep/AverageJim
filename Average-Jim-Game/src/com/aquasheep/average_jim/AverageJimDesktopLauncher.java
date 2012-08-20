package com.aquasheep.average_jim;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class AverageJimDesktopLauncher {

	public static void main(String[] args) {
		//Create new game instance
		ApplicationListener listener = new AverageJimGame();
		
		//Run as LwjglApplication
		new LwjglApplication(listener,"Average Jim",640,480,false);
	}

}
