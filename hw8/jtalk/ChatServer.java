// Author: Logan Tillman

package jtalk;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;

class ChatServer extends ServerSocket {
    ChatServer(int portNumber) throws IOException {
        try (
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine, outputLine;

            // Initiate conversation with client
            KnockKnockProtocol kkp = new KnockKnockProtocol();
            outputLine = kkp.processInput(null);
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                outputLine = kkp.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye.")) {
                    break;
                }
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public static void main(String[] args) throws IOException {
        int portNumber = Integer.parseInt(args[0]);

        try {
            ChatServer chatSever = new ChatServer(portNumber);
        } catch (IOException e) {
            System.out.println("Error with chat server");
            throw e;
        }
    }
}