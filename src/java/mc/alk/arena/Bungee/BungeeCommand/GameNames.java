package mc.alk.arena.Bungee.BungeeCommand;


import mc.alk.arena.Bungee.Communication.*;

import java.util.*;

/**
 * Created by Ben Byers on 7/17/2014.
 */
public class GameNames {
    private ArrayList<String> Names = new ArrayList<>();

    public GameNames(ArrayList<String> data) {
        Names.add("DebugGame");//This is to have something on the list, remove upon release
        if (!(data.isEmpty()))
            new ChannelSender("GameNames", Names);
    }

    public ArrayList<String> getNames(){
        return Names;
    }
}
