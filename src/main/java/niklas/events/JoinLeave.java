package niklas.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeave implements Listener {
    @EventHandler
    public void liittyminen(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (p.hasPermission("core.staff") || p.isOp()) {
            Bukkit.broadcast("§7(§aS§7)§a "+ e.getPlayer().getName()+" §7connected to the server", "core.staff");
            e.setJoinMessage("");

        }else{
            e.setJoinMessage("§7[§a+§7] "+e.getPlayer().getName());
        }
    }
    @EventHandler
    public void postuminen (PlayerQuitEvent e){
        Player p = e.getPlayer();
        if (p.hasPermission("core.staff") || p.isOp()) {
            Bukkit.broadcast("§7(§cS§7)§c "+ e.getPlayer().getName()+" §7left the server", "core.staff");
            e.setQuitMessage("");

        }else{
            e.setQuitMessage("§7[§4-§7] "+e.getPlayer().getName());
        }
    }
}