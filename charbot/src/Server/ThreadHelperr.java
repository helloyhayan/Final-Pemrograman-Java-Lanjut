/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.DataInputStream;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author Yayan Riadi Nusman
 */
public class ThreadHelperr extends Thread{
    Socket s;
    JTextArea textArea;
    public ThreadHelperr(Socket s, JTextArea textArea){
        this.s = s;
        this.textArea = textArea;
    }
    
    @Override
    public void run(){
        while (true) {
            try {
                DataInputStream dis = new DataInputStream(s.getInputStream());
                textArea.append(dis.readUTF()+"\n");
            } catch (Exception e) {
            }
        }
    }
    
    public Socket getSocket(){
        return s;
    }
}
