package fr.mf.cannabeuh.MFRedstoneDetector;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MFRedstoneDetector extends JavaPlugin {
	public Boolean notif = false;
	Map <Player, Player> MapNotify = new HashMap <Player, Player>();
	public void onDisable() {
		 System.out.println("[MINE-FRANCE] Detecteur de redstone DESACTVER");
	}
	public void onEnable() {
		 PluginManager pm = getServer().getPluginManager();
		 pm.registerEvent(Event.Type.REDSTONE_CHANGE,new MFRedstone(this),Priority.Low,this);
		 pm.registerEvent(Event.Type.PLAYER_QUIT,new MFQuitRedstone(this),Priority.Low,this);
		 System.out.println("[MINE-FRANCE] Detecteur de redstone ACTVER");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		String command = cmd.getName().toLowerCase();
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(p.isOp()){
				if(command.equals("mfredstone")){
					if(MapNotify.containsKey(p)){
						MapNotify.remove(p);
						if(MapNotify.size()<1){
							p.sendMessage("Anti-boucle OK.");
							notif=false;
						}
						p.sendMessage("Notification redstone desactivé.");
						return true;
					}else{
						MapNotify.put(p, p);
						notif=true;
						p.sendMessage("Notification redstone activé.");
						return true;
					}
				}
			}
		}
		return false;
	}
}
