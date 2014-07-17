package mc.alk.arena.Bungee.Communication;

import com.google.common.io.*;
import mc.alk.arena.Bungee.BungeeCommand.*;
import mc.alk.arena.Bungee.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.messaging.*;

import java.io.*;

/**
 * Created by Ben Byers on 7/17/2014.
 */
public class ChannelListener implements PluginMessageListener {
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (channel.equals("BattleArena")) {


            ByteArrayDataInput in = ByteStreams.newDataInput(message);
            String subchannel = in.readUTF();
            String rawData;
            short len;
            byte[] msgbytes;
            DataInputStream msgin;
            // Use the code sample in the 'Response' sections below to read
            // the data.
            try {
                switch (subchannel) {
                    case "getGameNames":
                        len = in.readShort();
                        msgbytes = new byte[len];
                        in.readFully(msgbytes);
                        msgin = new DataInputStream(new ByteArrayInputStream(msgbytes));
                        GameNames gameNames = new GameNames(msgin.readBoolean());
                        new ChannelSender("GameNames", gameNames.getNames(), 0);
                        break;

                    case "getEventNames":
                        len = in.readShort();
                        msgbytes = new byte[len];
                        in.readFully(msgbytes);
                        msgin = new DataInputStream(new ByteArrayInputStream(msgbytes));
                        rawData = msgin.readUTF();
                        EventNames eventNames = new EventNames(msgin.readBoolean());//Change to Event
                        new ChannelSender("EventNames", eventNames.getNames(), 0);//Change to Event
                        break;

                    case "CommandResponse":            /* I would like the rest of the channels to be executed in this fashion. */
                    case "BattleTeams":
                    case "BattlePlayers":
                    case "BattleStats":
                }
            } catch (IOException x) {
            }
        } else if (channel.equals("BungeeCord")) {
            ByteArrayDataInput in = ByteStreams.newDataInput(message);
            String subchannel = in.readUTF();
            String rawData;
            short len;
            byte[] msgbytes;
            DataInputStream msgin;
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

