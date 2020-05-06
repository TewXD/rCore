package niklas.commands;

import niklas.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCMD implements CommandExecutor {
    public BroadcastCMD(main main) {
    }
    private main plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.hasPermission("core.broadcast") || sender.isOp()){
        if (label.equalsIgnoreCase("broadcast")) {
            if (args.length == 0) {
                sender.sendMessage("§c§o/broadcast <message>");
            } else if (args.length > 0){
                StringBuilder sb = new StringBuilder();
                for(String s : args){
                    sb.append(s).append(" ");
                }
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', sb.toString()));
            }
        }else{
            sender.sendMessage("§c§oNo permissions.");
        }
      }
        return false;
    }
}

