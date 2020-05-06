package niklas.commands;

import niklas.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCMD implements CommandExecutor {
    public HealCMD(main plugin) {
        this.plugin = plugin;
    }

    private main plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player Player = (Player) sender;
            if (sender.hasPermission("core.heal") || sender.isOp()) {
                if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    target.setHealth(20);
                    target.setFoodLevel(20);
                    sender.sendMessage("§aYou have healed " + target.getName());
                    target.sendMessage("§aYou have been healed by " + sender.getName());
                } else {
                    Player.setHealth(20);
                    Player.setFoodLevel(20);
                    sender.sendMessage("§aYou have healed yourself.");
                }
            }

        } else {
            System.out.println("You can only use this command ingame honey :)");
        }
        return false;
    }
}
