package mc.alk.arena.Bungee.Communication;

import java.io.*;
import java.util.*;

/**
 * Created by Ben Byers on 7/20/2014.
 */
public class RawCommandHandler {
    private String serverName;
    private String playerName;
    private String command;
    private String subChannel;
    private Integer argsLength;
    private ArrayList<String> args = new ArrayList<>();

    public RawCommandHandler(byte[] data, DataInputStream info) {
        try {
            subChannel = info.readUTF();
            serverName = info.readUTF();
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            DataInputStream in = new DataInputStream(bais);
            playerName = in.readUTF();
            command = in.readUTF();
            argsLength = in.readInt();
            byte[] bytes = new byte[argsLength];
            DataInputStream subIn = new DataInputStream(new ByteArrayInputStream(bytes));
            while (subIn.available() > 0) {
                args.add(in.readUTF());
            }
            in.readFully(bytes);
        } catch (IOException e) {
        }
        // Use the code sample in the 'Response' sections below to read
        // the data.
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getServerName() {
        return serverName;
    }

    public String getCommand() {
        return command;
    }

    public ArrayList<String> getArgs() {
        return args;
    }

    public Integer getArgsLength() {
        return argsLength;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getSubChannel() {
        return subChannel;
    }
}

