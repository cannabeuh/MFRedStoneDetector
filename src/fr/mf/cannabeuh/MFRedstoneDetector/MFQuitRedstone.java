package fr.mf.cannabeuh.MFRedstoneDetector;

import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;

public class MFQuitRedstone extends PlayerListener {
	MFRedstoneDetector plugin;
	public MFQuitRedstone(MFRedstoneDetector evel) {
		 plugin = evel;
	}
	public void onPlayerQuit (PlayerQuitEvent event){
		if(plugin.MapNotify.contains(event.getPlayer())){
			plugin.MapNotify.remove(event.getPlayer());
		}
	}
}
