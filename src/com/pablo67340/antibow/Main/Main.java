package com.pablo67340.antibow.Main;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{


	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
	}


	@EventHandler(priority=EventPriority.LOWEST)
	public void onDamage(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Arrow){
			Arrow arrow = (Arrow) e.getDamager();
			if(arrow.getShooter() instanceof Player){
				if(e.getEntity() instanceof Player){
					Player shooter = (Player) arrow.getShooter();
					Player victim = (Player) e.getEntity();
					if (shooter.getName() == victim.getName()){
						e.setCancelled(true);
						shooter.sendMessage("§cYou cannot boost yourself with a bow!");
					}else{
						e.setCancelled(false);
					}


				}

			}

		}

	}

}