package org.redcrew.kzak.skywars.runnables;

import org.redcrew.kzak.skywars.SkyWarsReloaded;
import org.redcrew.kzak.skywars.game.Game;

public class CheckForMinPlayers implements Runnable {

	@Override
	public void run() {
		for(Game game: SkyWarsReloaded.getGC().getGames()) {
    		game.prepareForStart();
    	}
	}

}
