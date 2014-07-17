package mc.alk.arena.Bungee.BungeePlayerControl;

import mc.alk.arena.Bungee.Communication.*;
import org.bukkit.entity.*;

/**
 * Created by Ben Byers on 7/17/2014.
 */
public class PlayerSender {
    public PlayerSender(Player player, String server) {
        new ChannelSender("ConnectOther", player, server);
    }
}
