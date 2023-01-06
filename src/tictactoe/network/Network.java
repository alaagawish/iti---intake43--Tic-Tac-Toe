package tictactoe.network;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import tictactoe.models.Message;
import tictactoe.models.Player;

public class Network implements Runnable {

    Socket socket;
    String messages;
    Thread thread;
    PrintStream printStream;
    DataInputStream dataInputStream;

    String messageSentToServer, username, password;

    public Network() {

        username = "Alaa";
        password = "2345";
        try {
            socket = new Socket("127.0.0.1", 5005);
            dataInputStream = new DataInputStream(socket.getInputStream());
            printStream = new PrintStream(socket.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        thread = new Thread(this);
        thread.start();

    }

    public void closeConnection() {

        printStream.println("close");

        try {
            thread.sleep(100);
            dataInputStream.close();
            printStream.close();
            socket.close();
            thread.stop();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InterruptedException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {

        while (true) {
            try {
                if (socket.isConnected()) {
                    Gson gson = new Gson();
                    Message messageSent = new Message();
                    messageSent.setOperation("Login");
                    Player player = new Player(username, password);

                    String playerToString = gson.toJson(player);
                    messageSent.setPlayers(player);
                    String messageSentToServer = gson.toJson(messageSent);

                    printStream.println(messageSentToServer);
                    String messageReceivedFromServer = "";
                    messageReceivedFromServer = dataInputStream.readLine();
                    messageReceivedFromServer = messageReceivedFromServer.replaceAll("\r?\n", "");
                    if (!messageReceivedFromServer.isEmpty()) {

                        Message messageReceived = new Gson().fromJson(messageReceivedFromServer, Message.class);

                        if (messageReceived.getOperation().equals("Login")) {
                            if (messageReceived.isStatus()) {
                                System.out.println("Done login.......");
                            } else {
                                System.out.println("something wrong, check password or username..");
                            }

                        } else if (messageReceived.getOperation().equals("close")) {

                            try {
                                thread.sleep(100);
                                dataInputStream.close();
                                printStream.close();
                                socket.close();
                                thread.stop();
                            } catch (IOException e) {
                                System.out.println("Error: " + e.getMessage());
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }

                    username = "Alaa";
                    password = "23444";
                }

            } catch (IOException ex) {
                System.out.println("EX Error: " + ex.getLocalizedMessage());
            }
        }

    }

}
