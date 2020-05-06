package niklas.commands;

import niklas.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportALL implements CommandExecutor {
    private main plugin;

    public TeleportALL(main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("core.tpall") || sender.isOp()){
        if (sender instanceof Player){
            Player player = (Player) sender;
            //Teleport all the online players to you
            if (Bukkit.getServer().getOnlinePlayers().size() == 1){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no-players")));
            }else if(Bukkit.getServer().getOnlinePlayers().size() > 1){
                int numOfPlayers = 0;
                for(Player p : Bukkit.getServer().getOnlinePlayers()) {
                    p.teleport(player.getLocation());
                    numOfPlayers++;
                }
                player.sendMessage(ChatColor.YELLOW + "Teleported all " + (numOfPlayers - 1) + " players to you.");
            }
        }
        }else{
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no-perms")));
        }
        return true;
    }
}

