package mc.alk.arena.Bungee;

import io.slimshadeey1.ChannelApi.API.*;
import io.slimshadeey1.ChannelApi.Objects.*;
import org.kitteh.tag.api.*;

import java.util.*;

/**
 * Created by Ben Byers on 8/2/2014.
 */
public class PopulateBungee {
    public static void setEvents() {
        BAout packet = new BAout("BattleArena", "eventnames");
        ArrayList<String> PlaceHolder = new ArrayList<>();
        PlaceHolder.add("TestinEvent");
        packet.setServer("Proxy");
        packet.setData(PlaceHolder);///TODO: Remove the placeholder and replace with a BA hook that returns all registered events.
        new ChannelSender(packet);
    }

    public static void setGames() {
        BAout packet = new BAout("BattleArena", "gamenames");
        ArrayList<String> PlaceHolder = new ArrayList<>();
        PlaceHolder.add("TestinGame");
        packet.setServer("Proxy");
        packet.setData(PlaceHolder);///TODO: Remove the placeholder and replace with a BA hook that returns all registered games.
        new ChannelSender(packet);
    }
}