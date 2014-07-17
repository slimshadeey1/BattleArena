package mc.alk.arena.Bungee;

/**
 * This will be all methods from sub bungee classes organizer. Maybe turn this into a constructor.
 * Created by Ben Byers on 7/17/2014.
 */
public class BungeeHooks {
    private static String server;

    public static void setServer(String server) {
        BungeeHooks.server = server;
    }

    public static String getServer() {
        return server;
    }
}
