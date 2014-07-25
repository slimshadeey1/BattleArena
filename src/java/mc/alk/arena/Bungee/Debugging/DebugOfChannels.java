package mc.alk.arena.Bungee.Debugging;

import mc.alk.arena.*;
import mc.alk.arena.Bungee.Communication.*;

import java.io.*;
import java.util.*;

/**
 * This class is dedicated to debugging for bungee cord running servers.
 * This shall be disabled or removed on building/packaging of release version.
 * Created by Ben Byers on 7/24/2014.
 */
public class DebugOfChannels {
    /**
     * In this we will want to echo back ALL plugin messages on BattleArena Channel
     */
    private static ArrayList<String> message = new ArrayList<>();

    public DebugOfChannels(DataInputStream in) {
        try { ///TODO We need to use this for debugging purposes only, Always remove this before build.
            BAConverter debugProcessed = new BAConverter(in);
            String subchannel = debugProcessed.getSubChannel();
            String target = debugProcessed.getServer();
            ArrayList<String> payload = debugProcessed.getData();
            message.add("SubChannel: "+subchannel);
            message.add("Server: "+target);
            message.add("|---Packet Contents/Payload---|");
            for (String s:payload) {
                  message.add(s);
            }
            for (String mess:message){
                BattleArena.getSelf().getLogger().info("[BattleArena Debug] "+mess);
            }
        }catch (Exception e){}
    }
}
