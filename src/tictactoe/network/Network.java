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
import tictactoe.models.Message;
import tictactoe.models.Move;
import tictactoe.models.Player;
import tictactoe.screens.dualmode.OnlineListBase;

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
    public List<Move> resultMoves;

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
            resultMoves = new ArrayList<>();
        } catch (IOException ex) {
            ex.printStackTrace();
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
            thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (messageReceived.getPlayers().get(0).getUsername() != null) {
            messageReceived.setStatus("nothing");
            Player p = messageReceived.getPlayers().get(0);
            messageReceived = null;
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
        printStream.println(messageSentToServer);
        try {
            thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (messageReceived.getPlayers().get(0).getUsername() != null) {
            messageReceived.setStatus("nothing");
//            messageReceived = null;
            return messageReceived.getPlayers().get(0);
        } else {
            messageReceived = null;

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
//        try {
        messageSent = new Message();
        messageSent.setOperation("logout");
        messageSent.setStatus("offline");

        Player player = new Player();
        player.setUsername(userName);
        messageSent.setPlayers(player);
        messageSentToServer = gson.toJson(messageSent);
        printStream.println(messageSentToServer);
        System.err.println("in logout" + messageSent.getStatus() + " name = " + messageSent.getPlayers().get(0).getUsername());

        System.out.println("==================");
//        System.err.println("result: " + messageReceived.getPlayers().get(0).getStatus());
//        if (messageReceived.getPlayers().get(0).getStatus().equalsIgnoreCase("offline")) {
//            System.out.println("done logout"
//                    + messageReceived.getPlayers().get(0) + "\n" + messageReceived.getStatus());
//
//            return true;
//        } else {
//            System.err.println("logout failed from Network class in client side");
//            return false;
//        }

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

    public List<Move> createMoveFirstPlayer(Player firstPlayer, Player secondPlayer, List<Move> moves) {
        messageSent = new Message();
//        resultMoves = moves;
        System.out.println("send first player move to server" + moves);
        
        messageSent.setOperation("firstPlayerMove");
        messageSent.setPlayers(firstPlayer);
        messageSent.setPlayers(secondPlayer);
        messageSent.setMoves(moves);
        messageSentToServer = gson.toJson(messageSent);
        System.out.println("playedGame::" + messageSentToServer);
        printStream.println(messageSentToServer);

        if (messageReceived.getOperation().equalsIgnoreCase("secondPlayerMove")) {
            resultMoves = messageReceived.getMoves();
            System.out.println("received moves from server" + resultMoves);
        }

        return resultMoves;
    }

    public List<Move> createMoveSecondPlayer(Player firstPlayer, Player secondPlayer, List<Move> moves) {
        System.out.println("inside createMoveSecondPlayer");
        if (messageReceived.getOperation().equalsIgnoreCase("secondPlayerMove")) {
//            resultMoves = messageReceived.getMoves();

            System.out.println("received moves" + messageReceived.getMoves());

        }

        
        messageSent = new Message();

        messageSent.setOperation("firstPlayerMove");
        messageSent.setPlayers(firstPlayer);
        messageSent.setPlayers(secondPlayer);
        messageSent.setMoves(moves);
        messageSentToServer = gson.toJson(messageSent);
        resultMoves = moves;
        System.out.println("playedGame::" + messageSentToServer);
        printStream.println(messageSentToServer);

        return resultMoves;
    }

    @Override
    public void run() {

        while (true) {
            try {
                if (socket.isConnected()) {
                    System.out.println("im online");
                    String messageReceivedFromServer = "";
                    System.out.println("messageReceivedFromServer: " + messageReceivedFromServer);
                    messageReceivedFromServer = dataInputStream.readLine();
                    messageReceivedFromServer = messageReceivedFromServer.replaceAll("\r?\n", "");
                    System.out.println("meeeee:::" + messageReceivedFromServer);

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

                                System.out.println("Done login......." + messageReceived.getPlayers().get(0));
                                id = messageReceived.getPlayers().get(0).getId();

                                thread.sleep(100);
                            } else if (messageReceived.getStatus() == "wrong") {

                                System.out.println("something wrong, check password or username..");
                                thread.sleep(100);
                            }

                        } else if (messageReceived.getOperation().equalsIgnoreCase("logout")) {
                            if (messageReceived.getStatus() == "done") {
                                System.err.println(messageReceived.getStatus() + "From network in client side");
                                System.err.println("Done Logout.........." + messageReceived.getPlayers().get(0));
                                thread.sleep(100);
                            } else if (messageReceived.getStatus() == "wrong") {
                                System.err.println("something wrong, in Logout");
                                thread.sleep(100);
                            }
                        } else if (messageReceived.getOperation().equalsIgnoreCase("Edit")) {
                            if (messageReceived.getStatus() == "done") {

                                System.out.println("Done login......." + messageReceived.getPlayers().get(0));
                            } else if (messageReceived.getStatus() == "wrong") {

                                System.out.println("something wrong, check password or username..");
                            }

                        } else if (messageReceived.getOperation().equalsIgnoreCase("register")) {
                            if (messageReceived.getStatus() == "done") {
                                System.out.println("Done register......." + messageReceived.getPlayers().get(0));
                                thread.sleep(100);
                            } else if (messageReceived.getStatus() == "wrong") {

                                System.out.println("something wrong, check password or username..");
                                thread.sleep(100);
                            }

                        } else if (messageReceived.getOperation().equals("getOnlineList")) {
                            if (messageReceived.getStatus() == "done") {
                                System.out.println("Done getOnlineList.......");
                                System.out.println(messageReceived.getPlayers());

                            } else if (messageReceived.getStatus() == "wrong") {
                                System.out.println("something wrong");
                            }

                        } else if (messageReceived.getOperation().equalsIgnoreCase("requestGame")) {
                            if (messageReceived.getStatus().equalsIgnoreCase("accept")) {

                                System.out.println("game request accepted");

                            } else if (messageReceived.getStatus().equalsIgnoreCase("reject")) {

                                System.out.println("game request rejected");
                            } else {
                                System.out.println("No response for a game request");

                            }

                        } else if (messageReceived.getOperation().equalsIgnoreCase("responseGame")) {
                            if (messageReceived.getStatus() == "done") {
                                System.out.println("game request accepted");
                            } else if (messageReceived.getStatus() == "wrong") {

                                System.out.println("game request rejected");
                            } else {
                                System.out.println("No response for a game request");

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
                        } else if (messageReceived.getOperation().equalsIgnoreCase("firstPlayerMove")) {
//                            playerOne = messageReceived.getPlayers().get(0);
//                            playerTwo = messageReceived.getPlayers().get(1);
//
//                            OnlineListBase.dialog2.show();
                            System.out.println("first player move");
                        } else if (messageReceived.getOperation().equalsIgnoreCase("secondPlayerMove")) {
//                            playerOne = messageReceived.getPlayers().get(0);
//                            playerTwo = messageReceived.getPlayers().get(1);
//
//                            OnlineListBase.dialog2.show();
                            System.out.println("second player move.");
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
            return null;
        }
    }

}
