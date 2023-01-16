package tictactoe.network;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import tictactoe.models.Message;
import tictactoe.models.Move;
import tictactoe.models.Player;
import tictactoe.screens.dualmode.OnlineListBase;
import tictactoe.utils.Dialogs;
import tictactoe.screens.game.GameBase;
import tictactoe.utils.Dialogs;

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
    Player playerOne, playerTwo, player2;
    int id;
    public static String flag;

    public Network() {

        try {
            socket = new Socket(InetAddress.getLoopbackAddress(), 5005);
//            socket = new Socket("10.145.19.97", 5005);

            System.out.println("local addr:" + InetAddress.getLocalHost());
            dataInputStream = new DataInputStream(socket.getInputStream());
            printStream = new PrintStream(socket.getOutputStream());
            localPortNum = socket.getLocalPort();
            gson = new Gson();
            flag = "nothing";
            System.out.println("socket : " + socket + " \nportNumber on client: " + localPortNum);
        } catch (IOException ex) {
            Dialogs.showAlertDialog(Alert.AlertType.WARNING, "Warning", "Network isn't connencted", "Server has a problem wait until fix error");
        }

        thread = new Thread(this);
        thread.start();

    }

    public Player login(String username, String password) {
        messageSent = new Message();
        messageSent.setOperation("Login");
        Player player = new Player(username, password);
        messageSent.setPlayers(player);
        messageSentToServer = gson.toJson(messageSent);
        printStream.println(messageSentToServer);
        try {
            thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (messageReceived.getPlayers().get(0).getUsername() != null) {
            messageReceived.setStatus("nothing");
            Player p = messageReceived.getPlayers().get(0);
            return p;
        } else {
            messageReceived = null;
            return null;

        }

    }

    public Player editPassword(String username, String newPassword) {
        messageSent = new Message();
        messageSent.setOperation("Edit");
        Player player = new Player(username, newPassword);

        messageSent.setPlayers(player);
        messageSentToServer = gson.toJson(messageSent);
        System.out.println("newpa:" + newPassword);
        printStream.println(messageSentToServer);
        try {
            thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("resultt:" + messageReceived.getPlayers().get(0));

        if (messageReceived.getPlayers().get(0).getUsername() != null) {

            messageReceived.setStatus("nothing");
            System.out.println("done" + messageReceived.getPlayers().get(0));
            return messageReceived.getPlayers().get(0);
        } else {
            return null;

        }

    }

    public Player register(String username, String password) {
        messageSent = new Message();
        messageSent.setOperation("register");
        Player player = new Player(username, password);
        messageSent.setPlayers(player);
        messageSentToServer = gson.toJson(messageSent);
        printStream.println(messageSentToServer);
        try {
            thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (messageReceived.getPlayers().get(0).getUsername() != null) {
            messageReceived.setStatus("nothing");
            return messageReceived.getPlayers().get(0);
        } else {
            return null;

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

    public void requestGame(Player playerAsk, Player playerReceive) {
        messageSent = new Message();
        messageSent.setOperation("requestGame");
        messageSent.setPlayers(playerAsk);
        messageSent.setPlayers(playerReceive);
        player2 = playerReceive;
        messageSentToServer = gson.toJson(messageSent);
        System.out.println("requestgame::" + messageSentToServer);
        printStream.println(messageSentToServer);
        try {
            thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public synchronized void logout(String userName) {
        messageSent = new Message();
        messageSent.setOperation("logout");
        messageSent.setStatus("offline");

        Player player = new Player();
        player.setUsername(userName);
        messageSent.setPlayers(player);
        messageSentToServer = gson.toJson(messageSent);
        printStream.println(messageSentToServer);
        System.out.println("account logout successfully" + messageSent.getStatus() + " name = " + messageSent.getPlayers().get(0).getUsername());
    }

    public Player responseGame(boolean accept) {
        messageSent = new Message();
        messageSent.setOperation("responseGame");
        messageSent.setPlayers(playerOne);
        messageSent.setPlayers(playerTwo);

        System.out.println("playertwo  " + playerTwo);
        System.out.println("playersentre " + playerOne);

        System.out.println("responseGame:::server:" + messageSent);
        if (accept) {
            System.out.println("responseGame:::server:accept");

            messageSent.setStatus("accept");
        } else {
            System.out.println("responseGame:::server:reject");

            messageSent.setStatus("reject");
        }
        System.out.println("responseGame:::server:");

        messageSentToServer = gson.toJson(messageSent);
        printStream.println(messageSentToServer);
        System.out.println("requset done");
        return playerOne;
    }

    public void sendMove(Player firstPlayer, Player secondPlayer, List<Move> moves) {
        messageSent = new Message();
        System.out.println("send first player move to server" + moves);

        messageSent.setOperation("sendMove");
        messageSent.setPlayers(firstPlayer);
        messageSent.setPlayers(secondPlayer);
        messageSent.setMoves(moves);

        messageSentToServer = gson.toJson(messageSent);
        System.out.println("PLAYEDGAME::" + messageSentToServer);
        printStream.println(messageSentToServer);

    }

    public synchronized void updateScore(String userName, int score) {
        messageSent = new Message();
        messageSent.setOperation("updateScore");
        Player player = new Player();
        player.setUsername(userName);
        player.setScore(score);
        messageSent.setPlayers(player);
        messageSentToServer = gson.toJson(messageSent);
        printStream.println(messageSentToServer);
        System.out.println("Score of name = " + messageSent.getPlayers().get(0).getUsername() + " , " + messageSent.getPlayers().get(0).getScore());
    }

    @Override
    public void run() {

        while (true) {
            try {
                if (socket != null && socket.isConnected()) {

                    System.out.println("im online");
                    String messageReceivedFromServer = "";
                    System.out.println("messageReceivedFromServer: " + messageReceivedFromServer);
                    messageReceivedFromServer = dataInputStream.readLine();
                    messageReceivedFromServer = messageReceivedFromServer.replaceAll("\r?\n", "");
                    System.out.println(" " + messageReceivedFromServer);

                    if (!messageReceivedFromServer.isEmpty()) {

                        messageReceived = new Gson().fromJson(messageReceivedFromServer, Message.class
                        );
                        if (messageReceived.getOperation().equalsIgnoreCase("close")) {

                            try {
                                dataInputStream.close();
                                printStream.close();
                                socket.close();
                                thread.stop();
                            } catch (IOException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        } else if (messageReceived.getOperation().equalsIgnoreCase("Login")) {
                            if (messageReceived.getStatus() == "done") {

//                                System.out.println("Done login......." + messageReceived.getPlayers().get(0));
                                id = messageReceived.getPlayers().get(0).getId();

                                thread.sleep(100);
                            } else if (messageReceived.getStatus() == "wrong") {

//                                System.out.println("something wrong, check password or username..");
                                thread.sleep(100);
                            }

                        } else if (messageReceived.getOperation().equalsIgnoreCase("logout")) {
                            if (messageReceived.getStatus() == "done") {
                                thread.sleep(100);
                            } else if (messageReceived.getStatus() == "wrong") {
                                thread.sleep(100);
                            }
                        } else if (messageReceived.getOperation().equalsIgnoreCase("Edit")) {
                            if (messageReceived.getStatus() == "done") {

//                                System.out.println("Done login......." + messageReceived.getPlayers().get(0));
                            } else if (messageReceived.getStatus() == "wrong") {

//                                System.out.println("something wrong, check password or username..");
                            }

                        } else if (messageReceived.getOperation().equalsIgnoreCase("register")) {
                            if (messageReceived.getStatus() == "done") {
                                System.out.println("Done register......." + messageReceived.getPlayers().get(0));
                                thread.sleep(100);
                            } else if (messageReceived.getStatus() == "wrong") {

//                                System.out.println("something wrong, check password or username..");
                                thread.sleep(100);
                            }

                        } else if (messageReceived.getOperation().equals("getOnlineList")) {
                            if (messageReceived.getStatus() == "done") {
                                System.out.println("Done getOnlineList......." + messageReceived.getPlayers());

                            } else if (messageReceived.getStatus() == "wrong") {
                                System.out.println("something wrong in geting online list");
                            }

                        } else if (messageReceived.getOperation().equalsIgnoreCase("requestGame")) {
                            if (messageReceived.getStatus().equalsIgnoreCase("accept")) {

                                System.out.println("game request accepted");
                            } else if (messageReceived.getStatus().equalsIgnoreCase("reject")) {

                                System.out.println("game request rejected");
                            }

                        } else if (messageReceived.getOperation().equalsIgnoreCase("responseGame")) {
                            if (messageReceived.getStatus() == "done") {
                                System.out.println("game request accepted");
                            } else if (messageReceived.getStatus() == "wrong") {

                                System.out.println("game request rejected");
                            }
                        } else if (messageReceived.getOperation().equalsIgnoreCase("requestGameFeedback")) {
                            if (messageReceived.getStatus().equalsIgnoreCase("accept")) {

                                System.out.println("game request accepted");
                                flag = "accept";
                            } else if (messageReceived.getStatus().equalsIgnoreCase("reject")) {
                                flag = "reject";

                                System.out.println("game request rejected");
                            } else {
                                flag = "cancel";

                                System.out.println("No response for a game request");

                            }
                        } else if (messageReceived.getOperation().equalsIgnoreCase("askToPlay")) {
                            playerOne = messageReceived.getPlayers().get(0);
                            playerTwo = messageReceived.getPlayers().get(1);

                            OnlineListBase.dialog2.show();
                            System.out.println("game request.....");
                        } else if (messageReceived.getOperation().equalsIgnoreCase("sendMove")) {
                            GameBase.moves.add(messageReceived.getMoves().get(messageReceived.getMoves().size() - 1));
                        } else if (messageReceived.getOperation().equalsIgnoreCase("updateScore")) {
                            if (messageReceived.getStatus() == "done") {
                                System.out.println("Update Score done......." + messageReceived.getPlayers().get(0));

                            } else if (messageReceived.getStatus() == "wrong") {
                                System.out.println("something wrong...............");

                            }

                        }
                    }
                }

            } catch (IOException ex) {
                System.out.println("EX Error: " + ex.getLocalizedMessage());

            } catch (InterruptedException ex) {
                Logger.getLogger(Network.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public List<Player> getOnlineList() {
        messageSent = new Message();
        messageSent.setOperation("getOnlineList");
        messageSentToServer = gson.toJson(messageSent);
        printStream.println(messageSentToServer);
        try {
            thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (messageReceived.getPlayers().get(0).getUsername() != null) {

            List<Player> p = messageReceived.getPlayers();
            messageReceived.setStatus("nothing");
            messageReceived = null;
            return p;

        } else {
            return new ArrayList<Player>();
        }
    }

    public boolean isConnected() {
        return socket != null && socket.isConnected();
    }

}
