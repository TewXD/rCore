package niklas.commands;

import niklas.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCMD implements CommandExecutor {
    public FlyCMD(main plugin) {
        this.plugin = plugin;
    }

    private main plugin;
    private ArrayList<Player> lista = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (sender.hasPermission("core.fly") || sender.isOp()) {
                if (args.length == 0) {
                    FlyMode(player);
                }
                if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target == null) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("null-players")));
                    } else {
                        FlyMode(target);
                        if(target.getAllowFlight()){
                            sender.sendMessage("§aFly enabled to " + target.getName());
                        }else{
                            sender.sendMessage("§cFly Disabled to " + target.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("You can only use this command ingame <3");
        }


        return true;
    }

    private void FlyMode(Player player) {
        if (lista.contains(player)) {
            lista.remove(player);
            player.setAllowFlight(false);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("disabled-fly-msg")));
        } else if (!lista.contains(player)) {
            lista.add(player);
            player.setAllowFlight(true);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("fly-msg")));
        }
    }
}

