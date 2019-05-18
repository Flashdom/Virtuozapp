package com.laba.project.virtuozapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class NetworkConnector {
    private String IPaddress = "192.168.1.101";
    private int port = 8005;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String s = "44fb5855-29cf-4e95-82f6-d328a76cd610";

    public NetworkConnector() {

        /*try {
            socket = new Socket(IPaddress, port);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    }


    public void send()
    {

        s=s+";"+"0,1";
        try {
            socket = new Socket(IPaddress, port);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            out.writeUTF(s);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
