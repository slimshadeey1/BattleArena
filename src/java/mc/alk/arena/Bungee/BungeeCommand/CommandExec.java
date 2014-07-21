package mc.alk.arena.Bungee.BungeeCommand;

import com.google.common.io.*;
import mc.alk.arena.*;
import mc.alk.arena.controllers.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

import java.io.*;
import java.util.*;

/**
 * Created by Ben Byers on 7/18/2014.
 */
public class CommandExec {
    public CommandExec(ArrayList<String> data, String server) {
        String playerName = data.get(0);
        String command = data.get(1);
        ArrayList<String> args = new ArrayList<>();
        for (String s : data) {
            if (data.indexOf(s) <= 1) {
                return;
            }
            args.add(s);
        }
        Player player = BattleArena.getSelf().getServer().getPlayer(playerName);
        String fullCommand = command;
        for (String s : args) {
            fullCommand = fullCommand + " " + s;
        }
        switch (args.get(0)) {
            case "join":
                player.sendMessage("Ben the system works :)");
                //player.performCommand(fullCommand); //For now I am passing these commands into the server as I will have the player on the server by then, its local.
            case "leave":
                player.performCommand(fullCommand);
            case "info": //TODO When we get hooks to all of the different methods in battle Arena's command system, We will be able to fill these with the necessary executions.
                break;
            case "create":
                break;
            case "delete":
                break;
            case "options":
                break;
            case "status":
                break;
            case "check":
                break;
        }
        }

    }

