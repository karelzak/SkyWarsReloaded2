package org.redcrew.kzak.skywars.commands;

import org.redcrew.kzak.skywars.SkyWarsReloaded;
import org.redcrew.kzak.skywars.game.Game;
import org.redcrew.kzak.skywars.game.GamePlayer;
import org.redcrew.kzak.skywars.game.Game.GameState;
import org.redcrew.kzak.skywars.utilities.Messaging;

public class StartCmd extends BaseCmd { 
	
	public StartCmd() {
		forcePlayer = true;
		cmdName = "start";
		argLength = 1; //counting cmdName
		usage = "";
		desc = ":: Force start a game";

	}

	@Override
	public boolean run() {
		GamePlayer gPlayer = SkyWarsReloaded.getPC().getPlayer(player.getUniqueId());
		if (gPlayer.inGame()) {
			Game game = gPlayer.getGame();
			if (game.getState() == GameState.PREGAME) {
				game.startGame();
			}
			return true;
		} else {
			sender.sendMessage(new Messaging.MessageFormatter().format("error.not-in-game"));
			return true;
		}
	}

}
