package com.sammothe3.phantom;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {
	
	Phantom fl;
	public PlayerListener(Phantom Phantom) {
		fl = Phantom;
	}

	public void onPlayerClick(PlayerInteractEvent e) {
		if(e.getPlayer().getItemInHand().getType().equals(Material.FEATHER)&&e.getPlayer().hasPermission("phantom.fly")) {
			if(!fl.hasFlown.contains(e.getPlayer())){
				e.getPlayer().setAllowFlight(true);
				fl.hasFlown.add(e.getPlayer());
				@SuppressWarnings("unused")
				Thread t = new Thread(Countdown(e.getPlayer()));
			}
			else {
				e.getPlayer().sendMessage(Phantom.HasFlown);
			}
		}
	}

	private Runnable Countdown(Player player) {
		try {
			Thread.sleep(5000);
			player.setAllowFlight(false);
			Thread.sleep(60000);
			fl.hasFlown.remove(player);
		} catch (InterruptedException e) {
			//Stop them flying, just in case the thread *somehow* gets mess with.
			player.setAllowFlight(false);
			//Also allow them to activate it again, just in case.
			fl.hasFlown.remove(player);
		}
		return null;
	}
}