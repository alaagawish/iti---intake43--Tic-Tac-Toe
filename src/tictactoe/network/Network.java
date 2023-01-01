/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moazk
 */
public class Network implements Runnable{
    
    Socket mySocket;
    
    String msg;
    
    Thread th;
    
    OutputStream outputStream ;
    ObjectOutputStream objectOutputStream;
    
    InputStream inputStream;
    ObjectInputStream objectInputStream;
    
    
    List<String> sendMessages;
    
    
    public Network() {
        
        sendMessages = new ArrayList<>();
        
        sendMessages.add("Login");
        sendMessages.add("192.168.0.22");
        sendMessages.add("moaz");
        sendMessages.add("123456789");
        
        try {
            mySocket = new Socket("127.0.0.1", 5005);
            
            outputStream = mySocket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            
            
            inputStream = mySocket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        th = new Thread(this);
        th.start();
        
        
    }
    
    public void closeConnection() {

        try {
            //ps.close();
            //dis.close();
            objectOutputStream.close();
            objectInputStream.close();
            mySocket.close();
            th.stop();
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());            
        }

    }

    @Override
    public void run() {
        
        while(true){
            try {
                if(mySocket.isConnected()){
                    objectOutputStream.writeObject(sendMessages);
                    
                    List<String> recievedMessages = (List<String>) objectInputStream.readObject();
                
                    if(recievedMessages.size() > 0){
                        System.out.println("Received [" + recievedMessages.size() + "]");
                        System.out.println("All messages:");
                        recievedMessages.forEach((msg)-> System.out.println(msg));
                    }
                    recievedMessages.clear();
                }
                
                sendMessages.clear();
                //Thread.sleep(2000);
            } catch (IOException ex) {
                    System.out.println("Error: "+ex.getMessage());  
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    
    
}
