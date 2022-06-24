package me.wubbo.executableapi.Utils;

import me.wubbo.executableapi.Listener.InteractionEvents;

public class EventUtils {

    public void setEvents() {
        new InteractionEvents().registerEvent();
    }

}
