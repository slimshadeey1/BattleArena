package mc.alk.arena.Bungee.Communication;

import java.io.*;
import java.util.*;

public class BAConverter {
    /**
     * This is the new standardized packet format that Battle Arena will be using for bungee cord Communication.
     * Created by Ben Byers on 7/20/2014.
     */
    private ArrayList<String> dat;
    private String server;
    private String subChannel;

    public BAConverter(DataInputStream in) {
        try {
            subChannel = in.readUTF();
            server = in.readUTF();
            short len = in.readShort();
            byte[] bytes = new byte[len];


            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            DataInputStream pack = new DataInputStream(bais);
            while (pack.available() > 0) {
                dat.add(pack.readUTF());
            }
        } catch (IOException i) {
        }

    }

    public ArrayList<String> getData() {
        return dat;
    }

    public String getServer() {
        return server;
    }

    public String getSubChannel() {
        return subChannel;
    }
}
