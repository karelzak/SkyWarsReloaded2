package org.redcrew.kzak.skywars.commands;

import org.redcrew.kzak.skywars.SkyWarsReloaded;
import org.redcrew.kzak.skywars.utilities.Messaging;

public class SetSpawnCmd extends BaseCmd { 
	
	public SetSpawnCmd() {
		forcePlayer = true;
		cmdName = "setspawn";
		argLength = 1; //counting cmdName
		usage = "";
		desc = ":: Sets the spawn return point";

	}

	@Override
	public boolean run() {
		SkyWarsReloaded.getCfg().setSpawn(player.getLocation());
		sender.sendMessage(new Messaging.MessageFormatter().format("command.spawnset"));
		return true;
	}

}
