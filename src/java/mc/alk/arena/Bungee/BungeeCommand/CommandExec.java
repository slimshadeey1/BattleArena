package mc.alk.arena.Bungee.BungeeCommand;

import com.google.common.io.*;

import java.io.*;
import java.util.*;

/**
 * Created by Ben Byers on 7/18/2014.
 */
public class CommandExec {
    String serverName;
    String playerName;
    String command;
    String subChannel;
    Integer argsLength;
    ArrayList<String> args = new ArrayList<>();
    public CommandExec(byte[] data,DataInputStream info){
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

    }

