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

    public static String getPlayerServer(Player player) {
        ArrayList<String> name = new ArrayList<>();
        name.add(player.getName());
        UUID uuid = UUID.fromString(player.getName());
        new ChannelSender("BattlePlayers", name, uuid.toString()); //I will be changing all of this to a map in my next commit. I cannot track the data accurately this way I have attempted.
        return playerServer;
    }
}
