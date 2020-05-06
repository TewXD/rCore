package niklas.commands;

import com.sun.xml.internal.ws.client.SenderException;
import niklas.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sun.awt.Win32GraphicsConfig;

import static org.bukkit.Bukkit.*;

public class IpCMD implements CommandExecutor {
    private main plugin;

    public IpCMD(main main) {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
        if (sender.hasPermission("core.broadcast") || sender.isOp()) {
            if (CommandLabel.equalsIgnoreCase("getip")) {
                if (args.length == 1) {
                    Player p = Bukkit.getPlayer(args[0]);
                    Player k = Bukkit.getPlayerExact(args[0]);
                    if (p.isOnline()) {
                        String ip = p.getPlayer().getAddress().getAddress().getHostAddress();
                        sender.sendMessage("IP Of " + p.getName() + " Is " + ip);
                    }
                } else {
                    sender.sendMessage(ChatColor.GREEN + "Usage: /getip <player>");
                }
            }
        } else {
            sender.sendMessage("§c§oNo permissions.");
        }

        return false;
    }
}
