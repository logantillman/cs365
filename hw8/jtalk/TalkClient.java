// Author: Logan Tillman

package jtalk;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;

class TalkClient {
    TalkClient(String hostName, int portNumber) throws IOException {
        try (
            Socket talkSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(talkSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(talkSocket.getInputStream()));
        ) {
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String fromServer, fromUser;

            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye."))
                    break;

                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try {
            TalkClient talkClient = new TalkClient(hostName, portNumber);
        } catch (IOException e) {
            System.out.println("Error with talk client");
        }
    }
}