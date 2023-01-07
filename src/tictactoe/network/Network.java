package tictactoe.network;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
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
    int localPortNum;
    String messageSentToServer, username, password;
    Gson gson;
    Message messageSent, messageReceived;
    String playerToString;
    public static String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Network() {

        try {
            socket = new Socket(InetAddress.getLoopbackAddress(), 5005);
            System.out.println("local addr:" + InetAddress.getLocalHost());
            dataInputStream = new DataInputStream(socket.getInputStream());
            printStream = new PrintStream(socket.getOutputStream());
            localPortNum = socket.getLocalPort();
            gson = new Gson();

            System.out.println("socket : " + socket + " \nportNumber on client: " + localPortNum);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        thread = new Thread(this);
        thread.start();

    }

    public void closeConnection() {
        messageSent = new Message();
        messageSent.setOperation("close");
        messageSentToServer = gson.toJson(messageSent);
        printStream.println(messageSentToServer);

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

                    String messageReceivedFromServer = "";
                    System.out.println("messageReceivedFromServer: " + messageReceivedFromServer);
                    messageReceivedFromServer = dataInputStream.readLine();
                    messageReceivedFromServer = messageReceivedFromServer.replaceAll("\r?\n", "");
                    if (!messageReceivedFromServer.isEmpty()) {

                        messageReceived = new Gson().fromJson(messageReceivedFromServer, Message.class);
                        if (messageReceived.getOperation().equals("close")) {

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
                    messageReceived = null;
                }

            } catch (IOException ex) {
                System.out.println("EX Error: " + ex.getLocalizedMessage());
            }
        }

    }

}
