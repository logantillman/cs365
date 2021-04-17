// Author: Logan Tillman

package jtalk;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.concurrent.*;

class ChatServer extends ServerSocket {

    ChatServer() throws IOException {
        super();
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java ChatServer <port> <chat room names>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        ConcurrentMap<String, ChatData> rooms = new ConcurrentHashMap<String, ChatData>();

        for (int i = 1; i < args.length; i++) {
            ChatData newRoom = new ChatData(args[i]);
            rooms.put(args[i], newRoom);
        }

        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening) {
                new ChatServerThread(serverSocket.accept(), rooms).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
}