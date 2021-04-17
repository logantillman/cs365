// Author: Logan Tillman

package jtalk;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;

class TalkClient {
    String chatName = null;
    boolean interrupted = false;

    TalkClient(String hostName, int portNumber, String chatName) throws IOException {
        try (
            Socket talkSocket = new Socket(hostName, portNumber);
            // PrintWriter out = new PrintWriter(talkSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(talkSocket.getInputStream()));
            // BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ) {
            this.chatName = chatName;
            String fromServer, fromUser;

            new TalkClientThread(talkSocket, this.chatName, this).start();

            while ((fromServer = in.readLine()) != null) {
                if (this.interrupted) {
                    break;
                }

                System.out.println(fromServer);
            }
            talkSocket.close();
        } catch (IOException e) {
            
        }
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java TalkClient <hostname> <port> <chatname>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        String chatName = args[2];

        try {
            TalkClient talkClient = new TalkClient(hostName, portNumber, chatName);
        } catch (IOException e) {
            System.out.println("Error with talk client");
        }
    }
}