package niklas.commands;

import niklas.main;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class gmCMD implements CommandExecutor {
    public gmCMD(main plugin) {
        this.plugin = plugin;
    }

    private main plugin;
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        Player p = (Player)s;
        if (s.hasPermission("core.gamemode"))
            if (args.length == 0) {
                s.sendMessage(ChatColor.RED + "Usage: /gamemode <arg>");
            } else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s")) {
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(ChatColor.GREEN + "Successfully updated your gamemode");
            } else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c")) {
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(ChatColor.GREEN + "Successfully updated your gamemode");
            } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a")) {
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(ChatColor.GREEN + "Successfully updated your gamemode");

            }


        return false;
    }
}
