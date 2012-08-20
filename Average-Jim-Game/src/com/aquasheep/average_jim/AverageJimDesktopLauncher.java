package com.aquasheep.average_jim;

import java.io.IOException;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.tools.imagepacker.TexturePacker;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2.Settings;

public class AverageJimDesktopLauncher {

	public static void main(String[] args) throws IOException{
		//Create new game instance
		ApplicationListener listener = new AverageJimGame();
		
		//Run as LwjglApplication
		new LwjglApplication(listener,"Average Jim",640,480,false);
	}

}