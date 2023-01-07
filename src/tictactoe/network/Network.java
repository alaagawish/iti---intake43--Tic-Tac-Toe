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
    public static Player result;

    public Player getResult() {
        return result;
    }

    public void setResult(Player result) {
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

    public Player login(String username, String password) {
        this.username = username;
        this.password = password;

        messageSent = new Message();
        messageSent.setOperation("Login");
        Player player = new Player(username, password);

        playerToString = gson.toJson(player);
        messageSent.setPlayers(player);
        messageSentToServer = gson.toJson(messageSent);
        printStream.println(messageSentToServer);
        while (true) {
            System.out.println("resultt:" + this.getResult());
            if (this.getResult() != null) {
//               Player playerLogin = new Gson().fromJson(this.getResult(), Player.class);
                System.out.println("doneeeeeeeeeeeeeeeeeeeeeee");
                return player;
            } else {
                return null;

            }
        }
    }

    public Player editPassword(String username, String newPassword) {
        this.username = username;
        this.password = password;

        messageSent = new Message();
        messageSent.setOperation("Edit");
//        messageSent.setNewPassword(newPassword);
        Player player = new Player(username, password);

        playerToString = gson.toJson(player);
        messageSent.setPlayers(player);
        messageSentToServer = gson.toJson(messageSent);
        printStream.println(messageSentToServer);
        while (true) {
            System.out.println("resultt:" + this.getResult());
            if (this.getResult() != null) {
//               Player playerLogin = new Gson().fromJson(this.getResult(), Player.class);
                System.out.println("doneeeeeeeeeeeeeeeeeeeeeee" + player + " " + playerToString);
                return player;
            } else {
                return null;

            }
        }
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
                        if (messageReceived.getOperation().equalsIgnoreCase("close")) {

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
                        } else if (messageReceived.getOperation().equalsIgnoreCase("Login")) {
                            if (messageReceived.isStatus()) {
                                System.out.println("Done login......." + messageReceived.getPlayers().get(0));
                                this.setResult(messageReceived.getPlayers().get(0));
                                thread.sleep(100);
                            } else {
                                System.out.println("something wrong, check password or username..");
                                this.setResult(null);
                                thread.sleep(100);
                            }

                        } else if (messageReceived.getOperation().equalsIgnoreCase("Edit")) {
                            if (messageReceived.isStatus()) {
                                System.out.println("Done login......." + messageReceived.getPlayers().get(0));
                                this.setResult(messageReceived.getPlayers().get(0));
                                thread.sleep(100);
                            } else {
                                System.out.println("something wrong, check password or username..");
                                this.setResult(null);
                                thread.sleep(100);
                            }

                        }

                    }

                    messageReceivedFromServer = null;
                    messageReceived = null;
                }

            } catch (IOException ex) {
                System.out.println("EX Error: " + ex.getLocalizedMessage());
            } catch (InterruptedException ex) {
                Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
