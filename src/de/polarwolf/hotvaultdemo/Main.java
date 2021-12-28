package de.polarwolf.hotvaultdemo;

import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.economy.EconomyResponse.ResponseType;

public final class Main extends JavaPlugin {

	// Setup Vault
	// We use the demo-code from Vault to perform the integration
	// see https://github.com/MilkBowl/VaultAPI
	private static Economy econ = null;

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider(); //NOSONAR
		return econ != null;
	}

	// Use the simpliest Vault way to give the money to the player
	public void awardPlayer(Player player, int amount) {
		EconomyResponse eres = econ.depositPlayer(player, amount);
		if (eres.type == ResponseType.FAILURE) {
			String s = String.format("Vault failure: %s", eres.errorMessage);
			getLogger().info(s);
			return;
		}
		if (eres.type != ResponseType.SUCCESS) {
			String s = String.format("Vault error: %s", eres.type.toString());
			getLogger().info(s);
		}
	}

	@Override
	public void onEnable() {
		if (!setupEconomy()) {
			getLogger().warning("Error connecting to Vault");
			return;
		}
		new DemoListener(this);
		this.getLogger().info("Player are awarded with money when they trigger HotBlocks.");
	}

}