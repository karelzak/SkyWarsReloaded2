package org.redcrew.kzak.skywars.commands;

import org.redcrew.kzak.skywars.SkyWarsReloaded;
import org.redcrew.kzak.skywars.utilities.Messaging;

public class ReloadCmd extends BaseCmd { 
	
	public ReloadCmd() {
		forcePlayer = false;
		cmdName = "reload";
		argLength = 1; //counting cmdName
		usage = "";
		desc = ":: Reloads the config, chest.yml and kits";

	}

	@Override
	public boolean run() {
		SkyWarsReloaded.get().reload();
		sender.sendMessage(new Messaging.MessageFormatter().withPrefix().format("command.reload"));
		return true;
	}

}
