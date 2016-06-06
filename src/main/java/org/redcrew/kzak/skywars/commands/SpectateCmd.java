package org.redcrew.kzak.skywars.commands;

import org.redcrew.kzak.skywars.SkyWarsReloaded;
import org.redcrew.kzak.skywars.game.GamePlayer;
import org.redcrew.kzak.skywars.menus.SpecGameMenu;
import org.redcrew.kzak.skywars.utilities.Messaging;

public class SpectateCmd extends BaseCmd { 
	
	public SpectateCmd() {
		forcePlayer = true;
		cmdName = "spectate";
		argLength = 1; //counting cmdName
		usage = "";
		desc = ":: Allows a user to spectate games";

	}

	@Override
	public boolean run() {
		GamePlayer gPlayer = SkyWarsReloaded.getPC().getPlayer(player.getUniqueId());
		if (!gPlayer.inGame()) {
			new SpecGameMenu(gPlayer);
			return true;
		} else {
			sender.sendMessage(new Messaging.MessageFormatter().format("error.no-spectate-other-worlds"));
			return true;
		}
	}

}
