package io.seanbarker.trackerdeaths;

import io.seanbarker.trackerdeaths.builder.DeathCompiler;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathPlugin extends JavaPlugin {
    
    private boolean sendMessage;
    
    private final DeathBroadcaster listener = new DeathBroadcaster();
    
    public void onEnable() {
        if(getServer().getPluginManager().getPlugin("Tracker") == null) {
            getLogger().severe("Could not locate the Tracker plugin. Disabling.");
            getServer().getPluginManager().disablePlugin(this);
        }
        setupConfig();
        setSendMessage(getConfig().contains("Settings.SendMessage")
                     ? getConfig().getBoolean("Settings.SendMessage")
                     : true);
        getServer().getPluginManager().registerEvents(DeathCompiler.INSTANCE, this);
    }
    
    private void setupConfig() {
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.reloadConfig();
        Config.setConfig(getConfig());
    }
    
    public void setSendMessage(boolean value) {
        this.sendMessage = value;
        if(sendMessage) {
            getServer().getPluginManager().registerEvents(listener, this);
        } else {
            HandlerList.unregisterAll(listener);
        }
    }
    
    public boolean sendsMessage() {
        return sendMessage;
    }
    
}
