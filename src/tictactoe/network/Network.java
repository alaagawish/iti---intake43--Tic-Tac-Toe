package tictactoe.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Network implements Runnable {

    Socket socket;
    String messages;
    Thread thread;
    OutputStream outputStream;
    ObjectOutputStream objectOutputStream;
    InputStream inputStream;
    ObjectInputStream objectInputStream;

    List<String> sendMessages;
    List<String> recievedMessages;

    public Network() {

        sendMessages = new ArrayList<>();

        sendMessages.add("Login");
        sendMessages.add("Alaa");
        sendMessages.add("23458");

        try {
            socket = new Socket("127.0.0.1", 5005);

            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);

            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        thread = new Thread(this);
        thread.start();

    }

    public void closeConnection() throws IOException {
        List<String> close = new ArrayList<>();

        close.add("close");
        close.add("close");

        objectOutputStream.writeObject(close);

        try {
            objectOutputStream.close();
            objectInputStream.close();
            inputStream.close();
            outputStream.close();
            socket.close();
            thread.stop();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    @Override
    public void run() {

        while (true) {
            try {
                if (socket.isConnected()) {

                    objectOutputStream.writeObject(sendMessages);
                    System.out.println(sendMessages);
                    while (true) {
                        recievedMessages = (List<String>) objectInputStream.readObject();
                        if (recievedMessages.size() > 0) {
                            break;
                        }
                    }
                    System.out.println(recievedMessages);

                    if (recievedMessages.size() > 0) {
                        if (recievedMessages.get(0).equals("Login")) {
                            System.out.println("Received [" + recievedMessages.size() + "]");
                            recievedMessages.forEach((msg) -> System.out.println(msg));
                        }

                    }
                    recievedMessages.clear();
                    sendMessages.clear();

                    sendMessages.add("Login");
                    sendMessages.add("Alaa");
                    sendMessages.add("2345");

//                    System.out.println(sendMessages);
//                    sendMessages.clear();
//                    sendMessages.add("Login");
//                    sendMessages.add("Alaa");
//                    sendMessages.add("23456");
//                    sendMessages.add("Login");
//                     sendMessages.clear();
//                    sendMessages.add("Login");
//                    sendMessages.add("Nada");
//                    sendMessages.add("1234");
//                    sendMessages.add("Login");
                }

            } catch (IOException ex) {
                System.out.println("EX Error: " + ex.getLocalizedMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println("EX Error: " + ex.getLocalizedMessage());

            }
        }

    }

}
