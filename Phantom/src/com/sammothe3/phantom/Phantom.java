package com.sammothe3.phantom;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Phantom extends JavaPlugin {
	
	public static String HasFlown = null;
	public List<Player> hasFlown = new ArrayList<Player>();
	PlayerListener pl = new PlayerListener(this);
	
	@Override
	public void onEnable() {
		HasFlown = this.getConfig().getString("HasFlown");
		this.getServer().getLogger().info("[Phantom] Phantom enabled!");
	}
	
	@Override
	public void onDisable() {
		this.getServer().getLogger().info("[Phantom] Phantom disabled!");
	}	

}
