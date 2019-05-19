package com.laba.project.virtuozapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class NetworkConnector {
    private String IPaddress = "192.168.1.229";
    private int port = 8005;
    private Socket socket;
    private String text;
    private DataOutputStream out;
    private DataInputStream in;
    private String s = "getData";

    public NetworkConnector() {

        try {
            socket = new Socket(IPaddress, port);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getData()
    {

        try {
            out.writeUTF(s);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String s1) {
        try {
            out.writeUTF(s1);
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String[] receiveInfo() {
        byte[] data = new byte[1000000];
        String[] strings = new String[100000];
        try {
            in.read(data, 0, data.length);
            text = new String(data);
            strings = text.split("[?]");


        } catch (IOException e) {
            e.printStackTrace();
        }


        return strings;
    }


}
