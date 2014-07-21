package mc.alk.arena.Bungee.Communication;

import com.google.common.io.*;
import mc.alk.arena.Bungee.BungeeCommand.*;
import mc.alk.arena.Bungee.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.messaging.*;

import java.io.*;
import java.util.*;

/**
 *
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
            // Use the code sample in the 'Response' sections below to read
            // the data.
                switch (subchannel) { ///TODO Cleanup this entire class, redo it with BAConverter use instead of any other methods.
                    case "getGameNames":
                        BAConverter game = new BAConverter(in);
                        GameNames gameNames = new GameNames(game.getData());
                        break;
                    case "getEventNames":
                        BAConverter event = new BAConverter(in);
                        EventNames eventNames = new EventNames(event.getData());
                        break;
                    case "BattleArenaCommand":            /* I would like the rest of the channels to be executed in this fashion. */
                        BAConverter command = new BAConverter(in);
                        new CommandExec(command.getData(), command.getServer());
                        break;
                    case "BattleTeams":
                        BAConverter team = new BAConverter(in);
                        break;
                    case "BattlePlayers":
                        BAConverter players = new BAConverter(in);
                        break;
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


