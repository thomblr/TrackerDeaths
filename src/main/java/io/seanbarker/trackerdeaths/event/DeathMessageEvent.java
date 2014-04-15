package io.seanbarker.trackerdeaths.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import io.seanbarker.trackerdeaths.Death;
import io.seanbarker.trackerdeaths.messages.DeathMessageBuilder;
import io.seanbarker.trackerdeaths.messages.SimpleDeathMessageBuilder;

public class DeathMessageEvent extends AbstractDeathEvent implements Cancellable {

    private DeathMessageBuilder builder;
    
    private Collection<Player> recipients;
    
    private boolean cancelled;
    
    public DeathMessageEvent(Death death) {
        super(death);
        this.builder = new SimpleDeathMessageBuilder();
        this.recipients = Arrays.asList(Bukkit.getOnlinePlayers());
    }
    
    public DeathMessageBuilder getBuilder() {
        return builder;
    }
    
    public String getMessage() {
        return builder.getMessage(getDeath());
    }
    
    public Collection<Player> getRecipients() {
        return recipients;
    }
    
    public void setBuilder(DeathMessageBuilder builder) {
        this.builder = builder;
    }
    
    public void setRecipients(Collection<Player> recipients) {
        if(recipients == null) {
            this.recipients = new ArrayList<>();
            return;
        }
        this.recipients = recipients;
    }
    
    public void addRecipients(Collection<Player> recipients) {
        if(recipients == null) {
            return;
        }
        this.recipients.addAll(recipients);
    }
    
    public void removeRecipients(Collection<Player> recipients) {
        if(recipients == null) {
            return;
        }
        this.recipients.removeAll(recipients);
    }
    
    public void clearRecipients() {
        this.recipients.clear();
    }
    
    private static final HandlerList handlers = new HandlerList();
    
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    
    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

}
