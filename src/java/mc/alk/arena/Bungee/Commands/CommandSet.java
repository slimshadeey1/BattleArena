package mc.alk.arena.Bungee.Commands;

/**
 * Created by Ben Byers on 8/2/2014.
 */
public @interface CommandSet {
    String command() default "";

    String subcommand() default "";
}
