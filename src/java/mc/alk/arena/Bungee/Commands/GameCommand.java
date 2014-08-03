package mc.alk.arena.Bungee.Commands;

import java.util.*;

/**
 * Created by Ben Byers on 8/2/2014.
 */
public class GameCommand extends CommandMapper {

    public GameCommand(ArrayList<String> data) {
        String player = data.get(0);
        String playerServer = data.get(1);
        String command = data.get(2);
        String[] args = data.get(3).split(",");
        try {
            this.getExec(command, args[0]).invoke(command, player, playerServer, args);
        } catch (Exception e) {
        }
    }
}
