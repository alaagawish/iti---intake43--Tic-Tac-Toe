/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;

/**
 *
 * @author moazk
 */
public class Network implements Runnable{
    
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
    
    String msg;
    
    Thread th;


    public Network() {
        
        try {
            mySocket = new Socket("127.0.0.1", 5005);
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        th = new Thread(this);
        th.start();
        
        
    }
    
    public void closeConnection() {

        try {
            ps.close();
            dis.close();
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
                if(mySocket.isConnected())
                 msg = dis.readLine();
                if(msg != null)
                {
                       System.out.println("Message: " + msg);
                }
                //Thread.sleep(2000);
            } catch (IOException ex) {
                    System.out.println("Error: "+ex.getMessage());  
            }
        }
        
    }
    
    
    
    
}
