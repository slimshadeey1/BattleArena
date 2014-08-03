package mc.alk.arena.Bungee;

import io.slimshadeey1.ChannelApi.API.*;
import org.bukkit.plugin.*;

/**
 * I have created this as a separate class only because if I want to register or execute anything on enable,
 * also I don't have to tamper with the main class now. Also this allows for disabling of Bungee compatibility.
 * Created by Ben Byers on 7/17/2014.
 */
public class BungeeRegister {
    public BungeeRegister(Plugin plugin) {
        new PluginRegister(plugin);//Initializes the channel system
        new ChannelReceive(new ChannelListener());//Registers are listeners
    }
}
