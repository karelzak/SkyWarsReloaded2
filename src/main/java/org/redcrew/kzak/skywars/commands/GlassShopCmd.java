package org.redcrew.kzak.skywars.commands;

import org.bukkit.ChatColor;
import org.redcrew.kzak.skywars.SkyWarsReloaded;
import org.redcrew.kzak.skywars.game.GamePlayer;
import org.redcrew.kzak.skywars.menus.BuyColorMenu;
import org.redcrew.kzak.skywars.utilities.Messaging;


public class GlassShopCmd extends BaseCmd { 

	public GlassShopCmd() {
		forcePlayer = true;
		cmdName = "glassshop";
		argLength = 1; //counting cmdName
		usage = "";
		desc = ":: Menu for purchasing glass colors.";

	}

	@Override
	public boolean run() {
		if (SkyWarsReloaded.getCfg().purchaseColorClassEnabled()) {
			GamePlayer gPlayer = SkyWarsReloaded.getPC().getPlayer(player.getUniqueId());
			if (!gPlayer.inGame()) {
					new BuyColorMenu(gPlayer);
					return true;
			} else {
				sender.sendMessage(new Messaging.MessageFormatter().format("error.shop-not-available"));
				return true;
			}
			
		} else {
			sender.sendMessage(ChatColor.RED + "Glass Shop is disabled!");
			return true;
		}
	}
}
