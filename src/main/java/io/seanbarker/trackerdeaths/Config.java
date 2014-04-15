package io.seanbarker.trackerdeaths;

import org.bukkit.configuration.file.FileConfiguration;

import tc.oc.tracker.trackers.base.gravity.Fall.From;

public class Config {

    private static FileConfiguration config;
    
    public static void setConfig(FileConfiguration value) {
        config = value;
    }
    
    public static String getString(DeathCause cause) {
        if(cause == null) {
            return null;
        }
        return config.getString("Messages.Causes." + cause.toString().toLowerCase());
    }
    
    public static String getString(From from) {
        if(from == null) {
            return null;
        }
        return config.getString("Messages.From." + from.toString().toLowerCase());
    }
    
    public static String getString(To to) {
        if(to == null) {
            return null;
        }
        return config.getString("Messages.To." + to.toString().toLowerCase());
    }
    
    public static FileConfiguration get() {
        return config;
    }
    
}
