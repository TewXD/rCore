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
        e.setJoinMessage("§7[§a+§7] "+e.getPlayer().getName());
    }
    @EventHandler
    public void postuminen (PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage("§7[§4-§7] "+e.getPlayer().getName());
    }
}

