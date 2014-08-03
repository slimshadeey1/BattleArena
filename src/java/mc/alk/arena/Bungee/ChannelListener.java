package mc.alk.arena.Bungee;

import io.slimshadeey1.ChannelApi.API.*;
import io.slimshadeey1.ChannelApi.Objects.*;


/**
 * This is what listens to all channels, This class also directs what is received on each channel to the proper executor.
 * Created by Ben Byers on 7/17/2014.
 */
public class ChannelListener implements ChannelExec {
    protected static String Server = BungeeControls.getServer();

    /**
     * This is how we populate the proxy game - server map.
     */

    @Receive(channel = "BattleArena", subchannel = "gamenames")
    //Make sure to have the proxy side send ready when looking for games!
    public static void getGameName(BAin in) {
        if (in.getData().get(0).equals("ready")) {
            PopulateBungee.setGames();
            //Place method here that queries all game names and sends them.
        }
    }

    /**
     * This is how we populate the proxy event - server map.
     */
    @Receive(channel = "BattleArena", subchannel = "eventnames")
    //Make sure to have the proxy side send ready when looking for events!
    public static void getEventName(BAin in) {
        if (in.getData().get(0).equals("ready")) {
            PopulateBungee.setEvents();
            //Place method here that queries all event names and sends them.
        }
    }

    /**
     * This will be handling all commands sent by players. When a player executes a command the proxy takes it
     * and directs it to the proper server on this subchannel.
     * The server will be dictated by both the command and the server the player is on. Something that can be done locally
     * will mean I will send the command to the server the player is on.
     */
    @Receive(channel = "BattleArena", subchannel = "gamecommand")
    public static void gameCommand(BAin in) {
        if (in.getServer().equals(Server)) {//Make sure we are supposed to process this
            /**
             * Here we will call a method that takes a game command which will be invoke like this (in.getData())
             * this will pass am array to the executor allowing us to index an array for each thing we need.
             */
        }
    }

    /**
     * This will be handling all commands sent by players. When a player executes a command the proxy takes it
     * and directs it to the proper server on this subchannel.
     * The server will be dictated by both the command and the server the player is on. Something that can be done locally
     * will mean I will send the command to the server the player is on.
     */
    @Receive(channel = "BattleArena", subchannel = "eventcommand")
    public static void eventCommand(BAin in) {
        if (in.getServer().equals(Server)) {//Make sure we are supposed to process this
            /**
             * Here we will call a method that takes a event command which will be invoke like this (in.getData())
             * this will pass am array to the executor allowing us to index an array for each thing we need.
             */
        }
    }

    /**
     * This will be handling all commands sent by players. When a player executes a command the proxy takes it
     * and directs it to the proper server on this subchannel.
     * The server will be dictated by both the command and the server the player is on. Something that can be done locally
     * will mean I will send the command to the server the player is on.
     */
    @Receive(channel = "BattleArena", subchannel = "generalcommand")
    public static void generalCommand(BAin in) {
        if (in.getServer().equals(Server)) {//Make sure we are supposed to process this
            /**
             * Here we will call a method that takes a general command which will be invoke like this (in.getData())
             * this will pass am array to the executor allowing us to index an array for each thing we need.
             */
        }
    }

    /**
     * This is the channel we listen on for all team related queries. Alk we should probably implement hooks
     * to use this instead of allowing developers to directly connect to this channel.
     */
    @Receive(channel = "BattleArena", subchannel = "arenateams")
    public static void getTeams(BAin in) {
        if (in.getServer().equals(Server) || in.getServer().equals("ALL")) { //This checks which server should be handling this team.
            /**
             * I believe I will create an object on the proxy plugin that will be an arena team, then when it gets here we can implement
             * a method called toArenaTeam, that will take an array of data, and then at the same time we can do a server check that sees
             * what server there on and where they need to be.
             */
        }
    }

    /**
     * This is the channel we listen on for all Arena Player related queries. Alk we should probably implement hooks
     * to use this instead of allowing developers to directly connect to this channel.
     */
    @Receive(channel = "BattleArena", subchannel = "arenaplayer")
    public static void getArenaPlayer(BAin in) {
        if (in.getServer().equals(Server)) { //Make sure we run this on the server the player is goin too.
            /**
             * I believe I will create an object on the proxy plugin that will be an arena player, then when it gets here we can implement
             * a method called toArenaPlayer (the same way its done with BukkitPlayer to ArenaPlayer), that will take an array of data,
             * and then at the same time we can do a server check that sees what server there on and where they need to be.
             */
        }
    }

    /**
     * This is the channel we listen on for all Statistic related queries. Alk we should probably implement hooks
     * to use this instead of allowing developers to directly connect to this channel.
     */
    @Receive(channel = "BattleArena", subchannel = "arenastats")
    public static void getStats(BAin in) {
        /**
         * This is ment to have a unified stat tracking system. If all servers have them then we can use
         * existing implementations of stat tracking.
         */
    }
}