// Author: Logan Tillman

package jtalk;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.Collections;
import java.util.ArrayList;

class ChatServerThread extends Thread {
    private Socket socket = null;
    private ConcurrentMap<String, ChatData> rooms;
    private ChatData room = null;
    private String chatName = null;

    public ChatServerThread(Socket socket, ConcurrentMap<String, ChatData> rooms) {
        super("ChatServerThread");
        this.socket = socket;
        this.rooms = rooms;
    }
     
    public void run() {
        try (
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String inputLine, outputLine;

            this.chatName = in.readLine();

            out.printf("Chat Rooms:%n%n");

            ArrayList<String> mapKeys = new ArrayList<String>(this.rooms.keySet());
            Collections.sort(mapKeys);
            for (String roomName : mapKeys) {
                ChatData room = this.rooms.get(roomName);
                out.printf("%s: ", room.getRoomName());
                for (String clientName : room.clientNames) {
                    out.printf("%s ", clientName);
                }
                out.println();
            }
            out.println();

            out.println("Enter chat room:");
            
            while (true) {
                inputLine = in.readLine();

                ChatData inputRoom = rooms.get(inputLine);

                if (inputRoom == null) {
                    out.println("Enter chat room:");
                    continue;
                } else {
                    this.room = inputRoom;
                    inputRoom.addClient(out, this.chatName);
                    break;
                }
            }
 
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equals("Bye"))
                    break;

                outputLine = inputLine;
                this.room.distributeMessage(this.chatName + ": " + outputLine);
            }

            this.room.deleteClient(out, this.chatName);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}