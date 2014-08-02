package mc.alk.arena.Bungee;

/**
 * Created by Ben Byers on 8/2/2014.
 */

import mc.alk.ChannelAPI.API.*;
import mc.alk.ChannelAPI.Objects.*;

import java.util.*;

public class Test implements ChannelExec {
    @ChannelInt(channel = "BattleArena", subchannel = "join")
    public static void onJoin(BAin in) {
        ArrayList<String> data = in.getData();

        //Use index to get the specific thing you want out of the packet.
    }
}
