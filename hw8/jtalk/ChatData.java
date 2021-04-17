// Author: Logan Tillman

package jtalk;

import java.util.Vector;
import java.net.Socket;
import java.io.PrintWriter;

class ChatData {
    String roomName = null;
    Vector<PrintWriter> clients = new Vector<PrintWriter>();
    Vector<String> clientNames = new Vector<String>();

    ChatData(String roomName) {
        this.roomName = roomName;
    }

    String getRoomName() {
        return this.roomName;
    }

    void distributeMessage(String message) {
        for (PrintWriter client : clients) {
            client.println(message);
        }
    }

    void addClient(PrintWriter client, String clientName) {
        this.clients.add(client);
        this.clientNames.add(clientName);
        distributeMessage(clientName + " has joined");
    }

    void deleteClient(PrintWriter client, String clientName) {
        this.clients.remove(client);
        this.clientNames.remove(clientName);
        distributeMessage(clientName + " has left");
    }
    // distributeMessage: broadcasts a message to all clients in this chat room.
    // addClient: adds a client socket to the data structures for this ChatData object and creates a message indicating that the user has joined the chat room. This message is broadcast by distributeMessage.
    // deleteClient: removes a client socket from the data structures for this ChatData object and creates a message indicating that the user has left the chat room. This message is broadcast by distributeMessage.
    // broadcastMembers: writes a list of the chat rooms users to a new client so that the client can display the list of users in this chat room.
}