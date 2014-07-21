package mc.alk.arena.Bungee.BungeeCommand;


import mc.alk.arena.Bungee.Communication.*;

import java.util.*;

/**
 * Created by Ben Byers on 7/17/2014.
 */
public class EventNames {
    private ArrayList<String> Names = new ArrayList<>();

    public EventNames(ArrayList<String> data) {
        Names.add("DebugEvent");
        if (!(data.isEmpty()))
            new ChannelSender("EventNames", Names);//Change to Event
    }

    public ArrayList<String> getNames(){
        //In here we will create and return an Array of event names.
        return Names;
    }
}
