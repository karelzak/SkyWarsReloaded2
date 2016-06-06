package org.redcrew.kzak.skywars.commands;

import org.redcrew.kzak.skywars.SkyWarsReloaded;
import org.redcrew.kzak.skywars.game.Game;
import org.redcrew.kzak.skywars.game.GamePlayer;

public class QuitGameCmd extends BaseCmd { 

	public QuitGameCmd() {
		forcePlayer = true;
		cmdName = "quit";
		argLength = 1; //counting cmdName
		usage = "";
		desc = ":: Allows the player to leave a joined game.";
	}

	@Override
	public boolean run() {
		GamePlayer gPlayer = SkyWarsReloaded.getPC().getPlayer(player.getUniqueId());
		if (gPlayer.inGame() && !gPlayer.isSpectating()) {
			Game game = gPlayer.getGame();
			game.deletePlayer(gPlayer, true, false);
			return true;
		} else if (SkyWarsReloaded.getCfg().spectatingEnabled()) {
			if (gPlayer.isSpectating()){
				gPlayer.setSpectating(false);
				gPlayer.getSpecGame().removeSpectator(gPlayer);
			}
			return true;
		}
		return true;
	}

}
