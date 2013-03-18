package com.sammothe3.phantom;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {
	
	Phantom fl;
	public PlayerListener(Phantom Phantom) {
		fl = Phantom;
	}

	@EventHandler
	public void onPlayerClick(PlayerInteractEvent e) {
		if(e.getPlayer().getItemInHand().getType().equals(Material.FEATHER)&&(e.getPlayer().hasPermission("phantom.fly")||e.getPlayer().isOp())) {
			if((e.getAction().equals(Action.LEFT_CLICK_AIR)) || (e.getAction().equals(Action.LEFT_CLICK_BLOCK))||(e.getAction().equals(Action.RIGHT_CLICK_AIR)) || (e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
				if(!fl.hasFlown.contains(e.getPlayer().getName())){
					e.getPlayer().setAllowFlight(true);
					fl.hasFlown.add(e.getPlayer().getName());
					@SuppressWarnings("unused")
					Countdown t = new Countdown(e.getPlayer(), fl);
				}
				else {
					e.getPlayer().sendMessage(Phantom.HasFlown);
				}	
			}
		}
	}
}