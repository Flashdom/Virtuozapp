package com.laba.project.virtuozapp;


import android.os.Environment;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class NetworkConnector {
    private String IPaddress = "192.168.1.229";
    private int port = 8005;
    private Socket socket;
    private String text1;
    private static final String savedRecords = Environment.getExternalStorageDirectory().getPath();
    private DataOutputStream out1;
    private String text2;
    private DataInputStream in1;
    private DataInputStream in2;
    private DataOutputStream out2;

    private String s = "getData";

    public NetworkConnector() {

        try {
            socket = new Socket(IPaddress, port);
            out1 = new DataOutputStream(socket.getOutputStream());
            in1 = new DataInputStream(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getData() {

        try {
            out1.writeUTF(s);
            out1.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String s1) {
        try {
            socket = new Socket(IPaddress, port);
            out2 = new DataOutputStream(socket.getOutputStream());

            s1 += ";0,1";
            out2.writeUTF(s1);
            out2.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] receive() {


        byte[] datasong = new byte[1000000];
        byte[] datasong2 = new byte[1000000];
        try {
            in2 = new DataInputStream(socket.getInputStream());
            in2.read(datasong, 0, datasong.length);
            String x= new String(datasong, StandardCharsets.UTF_8);
            text2="ha";



        } catch (IOException e) {
            e.printStackTrace();
        }
        return datasong;


    }

    public String[] receiveInfo() {
        byte[] data = new byte[1000000];
        String[] strings = new String[100000];
        try {
            in1.read(data, 0, data.length);
            text1 = new String(data);
            strings = text1.split("[?]");


        } catch (IOException e) {
            e.printStackTrace();
        }


        return strings;
    }


}
