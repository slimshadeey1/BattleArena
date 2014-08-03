package mc.alk.arena.Bungee.Commands;

import java.util.*;

/**
 * Created by Ben Byers on 8/2/2014.
 */
public class GeneralCommand extends CommandMapper {
    public GeneralCommand(ArrayList<String> data) {
        String player = data.get(0);
        String playerServer = data.get(1);
        String command = data.get(2);
        String[] args = data.get(3).split(",");
        try {
            this.getExec(command, args[0]).invoke(command, player, playerServer, args);
        } catch (Exception e) {
        }
        switch (command) {
            case "arena":
                /**
                 * Whatever needs to be done here
                 */
                break;
            case "battleArena":
                /**
                 * Whatever needs to be done here
                 */
                break;
            /**
             * This will contain a case for each general command, then each command should have another switch case inside the command case.
             * I could also achieve the same effect with a hashmap of comamnds and tree maps which map to each subcommand.
             * If I were to do a map, I would then invoke the method with command,player,playerServer,args.
             */
        }
    }
}
