package io.seanbarker.trackerdeaths.messages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import io.seanbarker.trackerdeaths.Config;
import io.seanbarker.trackerdeaths.Death;
import io.seanbarker.trackerdeaths.Names;

public class SimpleDeathMessageBuilder implements DeathMessageBuilder {
    
    final String SPACE = " ";
    
    @Override
    public String getMessage(Death death) {
        List<String> data = new ArrayList<>();
        
        String victim = getVictim(death);
        if(StringUtils.isNotEmpty(victim)) data.add(victim);
        
        String action = getAction(death);
        if(StringUtils.isNotEmpty(action)) data.add(action);
        
        String from = getFrom(death);
        String to = getTo(death);
        if(StringUtils.isNotEmpty(from)) data.add(from);
        if(StringUtils.isNotEmpty(from) && StringUtils.isNotEmpty(to)) data.add("and");
        if(StringUtils.isNotEmpty(to)) data.add(to);
        
        String killer = getKiller(death);
        if(StringUtils.isNotEmpty(killer)) {
            data.add("by");
            data.add(killer);
        }
        
        String meta = getMeta(death);
        if(StringUtils.isNotEmpty(meta)) data.add(meta);
        
        return StringUtils.join(data, " ");
    }
    
    public String getVictim(Death death) {
        return getName(death.getVictim());
    }
    
    public String getAction(Death death) {
        return Config.getString(death.getCause());
    }
    
    public String getFrom(Death death) {
        return Config.getString(death.getFrom());
    }
    
    public String getTo(Death death) {
        return Config.getString(death.getTo());
    }
    
    public String getKiller(Death death) {
        Entity killer = death.getKiller();
        Player credited = death.getCredited();
        String result = "";
        if(killer != null) {
            // There's a direct killer
            if(killer instanceof Player && killer.equals(credited)) {
                return result += getName(credited);
            } else {
                if(credited != null) {
                    result += getName(credited) + "'s ";
                } else {
                    result += Names.getArticle(killer) + SPACE;
                }
                result += Names.entity(killer);
            }
            return result;
        } else {
            return credited != null ? result += getName(credited) : "";
        }
    }
    
    public String getMeta(Death death) {
        return death.getMeta().size() != 0 ? StringUtils.join(death.getMeta(), " ") : "";
    }
    
    protected String getName(Player player) {
        ChatColor highlight = ChatColor.getByChar(Config.get().getString("Settings.Colors.Highlight"));
        ChatColor text = ChatColor.getByChar(Config.get().getString("Settings.Colors.Text"));
        boolean displayNames = Config.get().getBoolean("Settings.PlayerDisplayNames");
        return highlight + (displayNames ? player.getDisplayName() : player.getName()) + text;
    }

}
