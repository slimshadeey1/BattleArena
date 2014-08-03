package mc.alk.arena.Bungee.Commands;

import java.lang.reflect.*;
import java.util.*;

/**
 * Created by Ben Byers on 8/2/2014.
 */
public abstract class SubCommandMapper {
    private SubCommandMapper exec;
    private static HashMap<String, Method> CommandMap = new HashMap<String, Method>();

    public void register() {
        exec = this;
        for (Method method : exec.getClass().getMethods()) {
            try {
                CommandSet commandSet = method.getAnnotation(CommandSet.class);
                CommandMap.put(commandSet.subcommand(), method);
            } catch (Exception e) {
            }
        }
    }

    public Method getExec(String subcommand) {
        if (CommandMap.containsKey(subcommand)) ;
        return CommandMap.get(subcommand);
    }
}
