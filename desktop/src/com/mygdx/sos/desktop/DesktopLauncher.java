package com.mygdx.sos.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.sos.SOSGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Zombie Bird";
		config.width = 1920;
		config.useGL30 = false;
		config.height = 1080;
		new LwjglApplication(new SOSGame(), config);
	}
}
