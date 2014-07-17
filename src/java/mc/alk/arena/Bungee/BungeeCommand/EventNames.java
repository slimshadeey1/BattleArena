package mc.alk.arena.Bungee.BungeeCommand;


import java.util.*;

/**
 * Created by Ben Byers on 7/17/2014.
 */
public class EventNames {
    public EventNames(Boolean run) {
        if (run) ;
    }

    private ArrayList<String> Names = new ArrayList<>();

    public ArrayList<String> getNames() {
        Names.add("DebugEvent");
        //In here we will create and return an Array of event names.
        return Names;
    }
}
