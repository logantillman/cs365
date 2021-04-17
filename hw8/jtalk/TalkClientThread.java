// Author: Logan Tillman

package jtalk;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;

class TalkClientThread extends Thread {
    private Socket socket = null;
    private String chatName = null;
    private TalkClient talkClient = null;

    TalkClientThread(Socket socket, String chatName, TalkClient talkClient) {
        super("TalkClientThread");
        this.socket = socket;
        this.chatName = chatName;
        this.talkClient = talkClient;
    }

    public void run() {
        try (
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String inputLine, outputLine;

            /* Printing the chatName so the server knows who the messages are coming from */
            out.println(this.chatName);
 
            /* Reading from stdin and sending the message to the server */
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equals("Bye"))
                    break;

                outputLine = inputLine;
                out.println(outputLine);
            }
            
            this.talkClient.interrupted = true;
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}