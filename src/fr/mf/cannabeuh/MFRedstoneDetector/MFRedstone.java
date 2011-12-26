package fr.mf.cannabeuh.MFRedstoneDetector;

import java.util.Map.Entry;

import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockRedstoneEvent;

public class MFRedstone extends BlockListener {
	MFRedstoneDetector plugin;
	public MFRedstone(MFRedstoneDetector evel) {
		 plugin = evel;
	}
	public void onBlockRedstoneChange(BlockRedstoneEvent event){
		if(plugin.notif.equals(true)){
			for (Entry<Player, Player> entity : plugin.MapNotify.entrySet()) {
				Player p=entity.getKey();
				if(p.isOnline()){
					p.sendMessage("world : "+event.getBlock().getLocation().getWorld().getName()+
					  "   x : "+event.getBlock().getLocation().getBlockX()+
					  "   y : "+event.getBlock().getLocation().getBlockY()+
					  "   z : "+event.getBlock().getLocation().getBlockZ());
				}
			}
		}
	}
}
