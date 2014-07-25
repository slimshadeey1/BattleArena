package mc.alk.arena.Bungee.Communication;

import com.google.common.io.*;
import mc.alk.arena.Bungee.BungeeCommand.*;
import mc.alk.arena.Bungee.*;
import mc.alk.arena.Bungee.Debugging.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.messaging.*;

import java.io.*;
import java.util.*;

/**
 * This is what listens to all channels, This class also directs what is received on each channel to the proper executor.
 * Created by Ben Byers on 7/17/2014.
 */
public class ChannelListener implements PluginMessageListener {
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (channel.equals("BattleArena")) {
            try {
                DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
            String subchannel = in.readUTF();
            String server;
                new DebugOfChannels(in);
                /**
                 * The following statement is for debugging purposes only.
                 */
                //-------------------------------------------------------------------
                new DebugOfChannels(in);                                    //-------
                //-------------------------------------------------------------------
                // Use the code sample in the 'Response' sections below to read
            // the data.
                switch (subchannel) {
                    /**
                     * This is how we populate the proxy game - server map.
                     */
                    case "getGameNames":
                        BAConverter game = new BAConverter(in);
                        GameNames gameNames = new GameNames(game.getData());
                        break;
                    /**
                     * This is how we populate the proxy event - server map
                     */
                    case "getEventNames":
                        BAConverter event = new BAConverter(in);
                        EventNames eventNames = new EventNames(event.getData());
                        break;

                    /**
                     * This will be handling all commands sent by players. When a player executes a command the proxy takes it
                     * and directs it to the proper server on this subchannel.
                     * The server will be dictated by both the command and the server the player is on. Something that can be done locally
                     * will mean I will send the command to the server the player is on.
                     */
                    case "BattleArenaCommand":            /* I would like the rest of the channels to be executed in this fashion. */
                        BAConverter command = new BAConverter(in);
                        new CommandExec(command.getData(), command.getServer());
                        break;
                    /**
                     * This is the channel we listen on for all team related queries. Alk we should probably implement hooks
                     * to use this instead of allowing developers to directly connect to this channel.
                     */
                    case "BattleTeams":
                        BAConverter team = new BAConverter(in);
                        break;
                    /**
                     * This is the channel we listen on for all Arena Player related queries. Alk we should probably implement hooks
                     * to use this instead of allowing developers to directly connect to this channel.
                     */
                    case "BattlePlayers":
                        BAConverter players = new BAConverter(in);
                        break;
                    /**
                     * This is the channel we listen on for all Statistic related queries. Alk we should probably implement hooks
                     * to use this instead of allowing developers to directly connect to this channel.
                     */
                    case "BattleStats":
                        BAConverter stats = new BAConverter(in);
                        break;
                }
            } catch (IOException x) {
            }
        } else if (channel.equals("BungeeCord")) {
            ByteArrayDataInput in = ByteStreams.newDataInput(message);
            String subchannel = in.readUTF();
            // Use the code sample in the 'Response' sections below to read
            // the data.
            try {
                switch (subchannel) {
                    case "GetServer":
                        String servername = in.readUTF();
                        BungeeHooks.setServer(servername);
                        break;
                }
            } catch (Exception x) {
            }

        }
    }
}


