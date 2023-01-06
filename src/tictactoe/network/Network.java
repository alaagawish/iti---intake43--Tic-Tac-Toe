package tictactoe.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Network implements Runnable {

    Socket socket;
    String messages;
    Thread thread;
    PrintStream printStream;
    DataInputStream dataInputStream;

    String messageSentToServer;

    public Network() {

        messageSentToServer = "Login,Alaa,2345";
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

                    printStream.println(messageSentToServer);
                    System.out.println(messageSentToServer);

                    String messageReceivedFromServer = dataInputStream.readLine();
                    System.out.println(messageReceivedFromServer);
                    if (messageReceivedFromServer.length() > 0) {
                        String[] arr = messageReceivedFromServer.split(",");
                        if (arr[0].equals("Login")) {

                            for (int i = 0; i < arr.length; i++) {
                                System.out.println(arr[i]);
                            }
                        } else if (messageReceivedFromServer.equals("close")) {

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
                    messageReceivedFromServer = null;
                    messageSentToServer = "Login,Alaa,23435";
                }

            } catch (IOException ex) {
                System.out.println("EX Error: " + ex.getLocalizedMessage());
            }
        }

    }

}
