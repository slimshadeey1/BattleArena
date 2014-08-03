package mc.alk.arena.Bungee.Commands;

import mc.alk.arena.util.*;

import java.lang.reflect.*;
import java.util.*;

/**
 * Created by Ben Byers on 8/2/2014.
 */
public class EventCommand extends SubCommandMapper {
    public EventCommand(ArrayList<String> data) {
        String player = data.get(0);
        String playerServer = data.get(1);
        String command = data.get(2);
        String[] args = data.get(3).split(",");
    }
}
