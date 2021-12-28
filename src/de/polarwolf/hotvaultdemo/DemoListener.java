package de.polarwolf.hotvaultdemo;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import de.polarwolf.hotblocks.events.HotBlocksTriggerBlockEvent;

public class DemoListener implements Listener {

	protected final Main main;

	public DemoListener(Main main) {
		this.main = main;
		main.getServer().getPluginManager().registerEvents(this, main);
	}

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void onHotBlocksTriggerEvent(HotBlocksTriggerBlockEvent event) {

		// Exit if we don't have a player
		Player player = event.getPlayer();
		if (player == null) {
			return;
		}

		// Exit if the rule has no points to award
		int points = event.getRule().getPoints();
		if (points == 0) {
			return;
		}

		// Call vault to give the points as money to the player
		main.awardPlayer(player, points);
	}

}
