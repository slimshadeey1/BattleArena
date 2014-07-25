package mc.alk.arena.Bungee;

import mc.alk.arena.Bungee.Communication.*;
import org.bukkit.entity.*;

import java.util.*;

/**
 * This will be all methods from sub bungee classes organizer. Maybe turn this into a constructor.
 * Created by Ben Byers on 7/17/2014.
 */
public class BungeeHooks {
    private static String server;
    private static String playerServer;
    public static void setServer(String server) {
        BungeeHooks.server = server;
    }

    public static String getServer(){
        return server;
    }

    public static String getPlayerServer() { //TODO I need to initialize this upon execution of a command. This might need to be a constructor.
        return playerServer;
    }
}
