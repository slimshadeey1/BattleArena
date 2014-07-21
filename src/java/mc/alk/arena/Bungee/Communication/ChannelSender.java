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

    public ChannelSender(String subChannel, ArrayList<String> message) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream(); //Converted
        DataOutputStream data = new DataOutputStream(bytes); //Message will be
        ByteArrayDataOutput out = ByteStreams.newDataOutput();

        //Define Sub Channel
        out.writeUTF(subChannel);
        out.writeUTF(server);
        try {
            for (String s : message) {
                data.writeUTF(s);
            }
        } catch (IOException e) {
        }
        out.writeShort(bytes.toByteArray().length);
        out.write(bytes.toByteArray());

        plugin.getServer().sendPluginMessage(plugin, "BattleArena", out.toByteArray());
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

