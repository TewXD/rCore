package niklas.commands;

import niklas.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class TeleportCMD implements CommandExecutor {
    private main plugin;

    public TeleportCMD(main plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            if(sender.hasPermission("core.tp") || sender.isOp()){
                Player player = (Player) sender;
                if(args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null){
                        player.teleport(target.getLocation());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("teleport-done")));
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("null-players")));
                    }
                } else if(args.length == 2){
                    Player playtosend = Bukkit.getPlayer(args[0]);
                    Player target = Bukkit.getPlayer(args[1]);
                    if(target != null && playtosend != null){
                        playtosend.teleport(target.getLocation());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("teleport-done")));
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("null-players")));
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "USAGE: /tp <ign> <ign>");
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no-perms")));
            }
        } else {
            System.out.println("You can't use this command in console");
        }
        return false;
    }
}