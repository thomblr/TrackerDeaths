package io.seanbarker.trackerdeaths.messages;

import io.seanbarker.trackerdeaths.Death;

public interface DeathMessageBuilder {

    public String getMessage(Death death);
    
}
