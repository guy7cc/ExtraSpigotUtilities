package io.github.guy7cc.extraspigotutilities;

import org.bukkit.plugin.java.JavaPlugin;

public final class ExtraSpigotUtilities extends JavaPlugin {
    private static ExtraSpigotUtilities plugin;
    @Override
    public void onEnable() {
        plugin = this;
        getCommand("hat").setExecutor(new HatCommand());
        getCommand("sit").setExecutor(new SitCommand());
        new RemoveSeatsScheduler().runTaskTimer(plugin, 0L, 20L);
    }

    @Override
    public void onDisable() { }

    public static ExtraSpigotUtilities getPlugin(){
        return plugin;
    }
}
