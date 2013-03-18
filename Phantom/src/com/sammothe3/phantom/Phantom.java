package com.sammothe3.phantom;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

public class Phantom extends JavaPlugin {
	
	public static String HasFlown = null;
	public static String Recharged = null;
	public List<String> hasFlown = new ArrayList<String>();
	PlayerListener pl = new PlayerListener(this);
	
	@Override
	public void onEnable() {
		HasFlown = "You've already flown! Wait one minute.";
		Recharged = "Flying recharged!";
		this.getServer().getLogger().info("[Phantom] Phantom enabled!");
		this.getServer().getPluginManager().registerEvents(pl, this);
	}
	
	@Override
	public void onDisable() {
		this.getServer().getLogger().info("[Phantom] Phantom disabled!");
	}	

}
