package org.redcrew.kzak.skywars.runnables;

import org.redcrew.kzak.skywars.SkyWarsReloaded;

public class SavePlayers implements Runnable {

	@Override
	public void run() {
		SkyWarsReloaded.getPC().savePlayersAsync();
	}

}
