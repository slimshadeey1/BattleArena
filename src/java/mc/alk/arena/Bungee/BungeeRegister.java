package mc.alk.arena.Bungee;

import mc.alk.arena.Bungee.Communication.*;
import org.bukkit.plugin.*;

/**
 * I have created this as a separate class only because if I want to register or execute anything on enable,
 * also I don't have to tamper with the main class now. Also this allows for disabling of Bungee compatibility.
 * Created by Ben Byers on 7/17/2014.
 */
public class BungeeRegister {
    private Plugin thisPlugin;

    public BungeeRegister(Plugin plugin) {
        plugin.getServer().getMessenger().registerIncomingPluginChannel(plugin, "BungeeCord", new ChannelListener());
        plugin.getServer().getMessenger().registerIncomingPluginChannel(plugin, "BattleArena", new ChannelListener());

        plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");
        plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "BattleArena");
        thisPlugin = plugin;
        new ChannelSender("GetServer");//This sets the server name.
    }
}
