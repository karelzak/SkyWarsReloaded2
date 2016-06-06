package org.redcrew.kzak.skywars.utilities;

import org.redcrew.kzak.skywars.game.GamePlayer;

public class Tagged {
	private GamePlayer player;
	private Long time;
	
	public Tagged(GamePlayer player, Long time) {
		this.player = player;
		this.time = time;
	}
	
	public GamePlayer getPlayer() {
		return player;
	}
	
	public Long getTime() {
		return time;
	}
}
