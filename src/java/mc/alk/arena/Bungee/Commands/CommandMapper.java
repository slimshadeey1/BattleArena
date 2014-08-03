package mc.alk.arena.Bungee.Commands;

import java.lang.reflect.*;
import java.util.*;

/**
 * Created by Ben Byers on 8/2/2014.
 */
public abstract class CommandMapper {
    private CommandMapper exec;
    private static HashMap<String, TreeMap<String, Method>> CommandMap = new HashMap<String, TreeMap<String, Method>>();

    public void register() {
        exec = this;
        for (Method method : exec.getClass().getMethods()) {
            try {
                CommandSet commandSet = method.getAnnotation(CommandSet.class);
                TreeMap<String, Method> sub = new TreeMap<>();
                sub.put(commandSet.subcommand(), method);
                CommandMap.put(commandSet.command(), sub);
            } catch (Exception e) {
            }
        }
    }

    public Method getExec(String command, String subcommand) {

        if (CommandMap.containsKey(command)) ;
        TreeMap<String, Method> exec = CommandMap.get(command);

        if (exec.containsKey(subcommand)) ;
        return exec.get(subcommand);
    }
}
