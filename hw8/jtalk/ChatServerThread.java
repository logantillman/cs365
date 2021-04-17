// Author: Logan Tillman

package jtalk;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
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

            /* Grabbing the clients chat name */
            this.chatName = in.readLine();

            /* Printing out the chat rooms and the clients in each of them */
            out.printf("Chat Rooms:%n%n");

            /* Sorting the chat rooms alphabetically */
            ArrayList<String> mapKeys = new ArrayList<String>(this.rooms.keySet());
            Collections.sort(mapKeys);

            /* Looping through each room, printing its name and the clients in the room */
            for (String roomName : mapKeys) {
                ChatData room = this.rooms.get(roomName);
                out.printf("%s: ", room.getRoomName());
                for (String clientName : room.clientNames) {
                    out.printf("%s ", clientName);
                }
                out.println();
            }
            out.println();

            /* Prompting the user to enter a chat room until they enter a valid room */
            out.println("Enter chat room:");
            while (true) {
                inputLine = in.readLine();

                ChatData inputRoom = rooms.get(inputLine);

                if (inputRoom == null) {
                    out.println("Enter chat room:");
                    continue;
                } else {

                    /* Once the user enters a valid chat room name, it adds them to the data structures */
                    this.room = inputRoom;
                    inputRoom.addClient(out, this.chatName);
                    break;
                }
            }
 
            /* Reading from the socket and displaying the message to all users */
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equals("Bye"))
                    break;

                outputLine = inputLine;
                this.room.distributeMessage(this.chatName + ": " + outputLine);
            }
            
            /* Removing the client from the room */
            this.room.deleteClient(out, this.chatName);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}