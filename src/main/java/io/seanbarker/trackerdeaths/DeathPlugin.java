package io.seanbarker.trackerdeaths;

import io.seanbarker.trackerdeaths.builder.DeathCompiler;
import io.seanbarker.trackerdeaths.messages.MessageBroadcaster;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathPlugin extends JavaPlugin {
    
    public void onEnable() {
        if(getServer().getPluginManager().getPlugin("Tracker") == null) {
            getLogger().severe("Could not locate the Tracker plugin. Disabling.");
            getServer().getPluginManager().disablePlugin(this);
        }
        setupConfig();
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(DeathCompiler.INSTANCE, this);
        manager.registerEvents(new MessageBroadcaster(), this);
    }
    
    private void setupConfig() {
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.reloadConfig();
        Config.setConfig(getConfig());
    }
    
}
