package mc.alk.arena.Bungee.Communication;

import com.google.common.io.*;
import mc.alk.arena.*;
import mc.alk.arena.Bungee.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;

import java.io.*;
import java.util.*;

/**
 * Created by Ben Byers on 7/17/2014.
 */
public class ChannelSender {
    private Plugin plugin = BattleArena.getSelf();
    private String server = BungeeHooks.getServer();


    public ChannelSender(String subChannel, ArrayList<String> message, Integer id) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream(); //Converted
        DataOutputStream data = new DataOutputStream(bytes); //Message will be
        ByteArrayDataOutput out = ByteStreams.newDataOutput();

        //Define Sub Channel
        out.writeUTF(subChannel);

        try {
            data.writeUTF(server);
            for (String s : message) {
                data.writeUTF(s);
            }
            data.writeShort(id);
        } catch (IOException e) {
        }
        out.writeShort(bytes.toByteArray().length);
        out.write(bytes.toByteArray());

        plugin.getServer().sendPluginMessage(plugin, "BattleArena", out.toByteArray());
    }

    public ChannelSender(String subChannel, String command, String playerName, ArrayList<String> args, ArrayList<String> response, boolean commandresponse) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream(); //Converted
        DataOutputStream data = new DataOutputStream(bytes); //Message will be
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        //Define Sub Channel
        out.writeUTF(subChannel);
        if (commandresponse) {
            try {
                data.writeUTF(server);
                data.writeUTF(playerName);
                data.writeUTF(command);
                ByteArrayOutputStream bytes1 = new ByteArrayOutputStream(); //Converted
                DataOutputStream subOut = new DataOutputStream(bytes1);
                for (String s : args) {
                    subOut.writeUTF(s);
                }
                data.writeInt(bytes1.toByteArray().length);
                data.write(bytes1.toByteArray());
                ByteArrayOutputStream bytes2 = new ByteArrayOutputStream(); //Converted
                DataOutputStream subOut1 = new DataOutputStream(bytes2);
                for (String s : response) {
                    subOut1.writeUTF(s);
                }
                data.writeInt(bytes2.toByteArray().length);
                data.write(bytes2.toByteArray());
            } catch (IOException e) {
            }
            out.writeShort(bytes.toByteArray().length);
            out.write(bytes.toByteArray());
        }


        plugin.getServer().sendPluginMessage(plugin, "BattleArena", out.toByteArray());
    }

    public ChannelSender(String subChannel, String targets, ArrayList<String> message) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream(); //Converted
        DataOutputStream data = new DataOutputStream(bytes); //Message will be
        ByteArrayDataOutput out = ByteStreams.newDataOutput();

        //Define Sub Channel
        out.writeUTF("Forward");
        out.writeUTF(targets);
        out.writeUTF(subChannel);

        try {
            for (String s : message) {
                data.writeUTF(s);
            }
        } catch (IOException e) {
        }
        out.writeShort(bytes.toByteArray().length);
        out.write(bytes.toByteArray());

        plugin.getServer().sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
    }

    public ChannelSender(String option, Player player, String arg) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();

        //Define Sub Channel
        out.writeUTF(option);
        out.writeUTF(player.getName());
        out.writeUTF(arg);

        plugin.getServer().sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
    }

    public ChannelSender(String option) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF(option);
        plugin.getServer().sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
    }
}

