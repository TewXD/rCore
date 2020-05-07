package niklas.commands;

import niklas.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor {
    public ClearChat(main main) {
    }

    private main plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("core.clearchat")) {
                for (int i = 0; i < 250; ++i) {
                    Bukkit.broadcastMessage(" ");
                }
                Bukkit.broadcastMessage("§7§m------------------------------");
                Bukkit.broadcastMessage("§aChat have been cleared by " +sender.getName());
                Bukkit.broadcastMessage("§7§m------------------------------");
            }else{
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no-perms")));
            }

        } else {
            System.out.println("You can't use this command in console.");
        }

        return false;
    }
}
