package niklas;

        import niklas.commands.*;
        import niklas.events.JoinLeave;
        import org.bukkit.ChatColor;
        import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {
//TESTI LULULULU
    @Override
    public void onEnable() {
        System.out.println(ChatColor.GREEN+ "rCore Enabled");
        getCommand("tp").setExecutor(new TeleportCMD(this));
        getCommand("tpall").setExecutor(new TeleportALL(this));
        getCommand("getip").setExecutor(new IpCMD(this));
        getCommand("broadcast").setExecutor(new BroadcastCMD(this));
        getCommand("fly").setExecutor(new FlyCMD(this));
        getCommand("heal").setExecutor(new HealCMD(this));
        getCommand("gm").setExecutor(new gmCMD(this));
        getCommand("clearchat").setExecutor(new ClearChat(this));
        getServer().getPluginManager().registerEvents(new JoinLeave(), this);


        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED+ "rCore Disabled");
    }
}
