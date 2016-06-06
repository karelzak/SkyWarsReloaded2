package org.redcrew.kzak.skywars.commands;

import org.redcrew.kzak.skywars.SkyWarsReloaded;
import org.redcrew.kzak.skywars.game.Game;


public class GamesCmd extends BaseCmd { 

	public GamesCmd() {
		forcePlayer = false;
		cmdName = "games";
		argLength = 1; //counting cmdName
		usage = "";
		desc = ":: List all games currenlty in progress";

	}

	@Override
	public boolean run() {
		for (Game game: SkyWarsReloaded.getGC().getGames()) {
			int number = game.getGameNumber();
			String map = game.getMapName();
			int players = game.getPlayers().size();
			String message = number + "   " + map + "   " + players;
			sender.sendMessage(message);
		}
		return true;
	}
}
