package org.redcrew.kzak.skywars.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import org.redcrew.kzak.skywars.SkyWarsReloaded;
import org.redcrew.kzak.skywars.game.Game;
import org.redcrew.kzak.skywars.game.Game.GameState;

public class PingListener implements Listener {

	@EventHandler
    public void onPing(final ServerListPingEvent serverListPingEvent) {
		if (SkyWarsReloaded.get().loadingEnded()) {
            if (SkyWarsReloaded.getGC().getGames().size() > 0) {
            	Game game = SkyWarsReloaded.getGC().getGame(1);
                serverListPingEvent.setMotd(game.getState().toString() + ":" + game.getPlayers().size() + ":" + game.getNumberOfSpawns() + ":" + game.getMapName());
            } else {
                serverListPingEvent.setMotd(GameState.ENDING.toString() + ":" + 0 + ":" + 0 + ":" + "null");
            }
		} else {
                serverListPingEvent.setMotd(GameState.ENDING.toString() + ":" + 0 + ":" + 0 + ":" + "null");
        }
    }
    
}
