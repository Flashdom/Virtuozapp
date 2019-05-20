package com.laba.project.virtuozapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class SongActivity extends AppCompatActivity {

    TextView textView;
    Button play;
    Button flat;
    Button sharp;
    NetworkConnector nc;
    Guids guids;
    Button process;
    String strings[];
    TextView tv;
    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        guids = new Guids();
        textView = findViewById(R.id.song);
        play = findViewById(R.id.play);
        flat = findViewById(R.id.flat);
        sharp = findViewById(R.id.sharp);
        final byte[] byteArray = new byte[100000];
        ;
        tv = findViewById(R.id.current_tone);
        tv.setText("0");

        new Thread(new Runnable() {
            @Override
            public void run() {
                nc = new NetworkConnector();
                nc.getData();
                strings = nc.receiveInfo();
                assemble();
            }
        }).start();

        process = findViewById(R.id.process);
        textView.setText(getIntent().getExtras().getString("songname"));

        flat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = tv.getText().toString();
                int a = Integer.parseInt(s);
                a -= 1;
                s = String.valueOf(a);
                tv.setText(s);

            }
        });
        sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = tv.getText().toString();
                int a = Integer.parseInt(s);
                a = a + 1;
                s = String.valueOf(a);
                tv.setText(s);
            }
        });


        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (textView.getText().toString().equals(guids.wakemeupguid[1])) {
                            nc.send(guids.wakemeupguid[0]);
                            nc.receive();


                        }
                        if (textView.getText().toString().equals(guids.blackorwhiteguid[1])) {
                            nc.send(guids.blackorwhiteguid[0]);


                            try {
                                // create temp file that will hold byte array
                                File tempMp3 = File.createTempFile("tmp", "wav", getCacheDir());
                                tempMp3.deleteOnExit();
                                FileOutputStream fos = new FileOutputStream(tempMp3);
                                fos.write(nc.receive());
                                fos.close();

                                // resetting mediaplayer instance to evade problems
                                mediaPlayer.reset();

                                // In case you run into issues with threading consider new instance like:
                                // MediaPlayer mediaPlayer = new MediaPlayer();

                                // Tried passing path directly, but kept getting
                                // "Prepare failed.: status=0x1"
                                // so using file descriptor instead
                                FileInputStream fis = new FileInputStream(tempMp3);
                                mediaPlayer.setDataSource(fis.getFD());

                                mediaPlayer.prepare();
                                mediaPlayer.start();
                            } catch (IOException ex) {
                                String s = ex.toString();
                                ex.printStackTrace();
                            }


                        }
                        if (textView.getText().toString().equals(guids.sendmeanangelguid[1]))
                            nc.send(guids.sendmeanangelguid[0]);
                        if (textView.getText().toString().equals(guids.vihodanetguid[1]))
                            nc.send(guids.vihodanetguid[0]);
                        if (textView.getText().toString().equals(guids.etovseguid[1]))
                            nc.send(guids.etovseguid[0]);
                        if (textView.getText().toString().equals(guids.dadayaguid[1]))
                            nc.send(guids.dadayaguid[0]);

                    }
                }).start();
            }
        });


    }


    public void assemble() {
        for (int i = 1; i < strings.length - 1; i++) {
            guids.guidsarr[i - 1] = strings[i];


        }
        guids.processing();

    }
}
