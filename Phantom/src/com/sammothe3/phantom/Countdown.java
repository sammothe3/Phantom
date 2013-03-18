package com.sammothe3.phantom;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Countdown implements Runnable {

	Phantom fl;
	Player player;
	
	public Countdown(Player play, Phantom ph) {
		Thread runner = new Thread(this);
		player = play;
		this.fl = ph;
		runner.setDaemon(true);
		runner.start();
	}
	
	@Override
	public void run() {
		try {
			ItemStack head = player.getInventory().getHelmet();
			ItemStack newhead = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta lam = (LeatherArmorMeta)newhead.getItemMeta();
			lam.setColor(Color.SILVER);
			newhead.setItemMeta(lam);
			player.getInventory().setHelmet(newhead);
			Thread.sleep(5000);
			player.setAllowFlight(false);
			player.getInventory().setHelmet(head);
			Thread.sleep(60000);
			fl.hasFlown.remove(player.getName());
			player.sendMessage(Phantom.Recharged);
		} catch (InterruptedException e) {
			Bukkit.broadcastMessage("ex");
			//Stop them flying, just in case the thread *somehow* gets mess with.
			player.setAllowFlight(false);
			//Also allow them to activate it again, just in case.
			fl.hasFlown.remove(player);
		}
	}
}
