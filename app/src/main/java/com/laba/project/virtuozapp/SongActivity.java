package com.laba.project.virtuozapp;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        guids = new Guids();
        textView=findViewById(R.id.song);
        play=findViewById(R.id.play);
        flat=findViewById(R.id.flat);
        sharp=findViewById(R.id.sharp);
        tv=findViewById(R.id.current_tone);
        tv.setText("0");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    nc= new NetworkConnector();
                    nc.getData();
                   strings=nc.receiveInfo();
                   assemble();

                }
            }).start();

        process=findViewById(R.id.process);
        textView.setText(getIntent().getExtras().getString("songname"));

        flat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = tv.getText().toString();
                int a=Integer.parseInt(s);
                a-=1;
                s=String.valueOf(a);
                tv.setText(s);

            }
        });
        sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = tv.getText().toString();
                int a=Integer.parseInt(s);
                a=a+1;
                s=String.valueOf(a);
                tv.setText(s);
            }
        });




        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (textView.getText().toString().equals(guids.wakemeupguid[1]))
                            nc.send(guids.wakemeupguid[0]);
                        if (textView.getText().toString().equals(guids.blackorwhiteguid[1]))
                            nc.send(guids.blackorwhiteguid[0]);
                        if (textView.getText().toString().equals(guids.sendmeanangelguid[1]))
                            nc.send(guids.sendmeanangelguid[0]);
                        if (textView.getText().toString().equals(guids.vihodanetguid[1]))
                            nc.send(guids.vihodanetguid[0]);
                        if (textView.getText().toString().equals(guids.etovseguid[1]))
                            nc.send(guids.etovseguid[0]);

                    }
                }).start();
            }
        });


    }


    public void assemble()
    {
        for(int i=1; i<strings.length-1; i++)
        {
            guids.guidsarr[i-1]=strings[i];


        }
        guids.processing();

    }
}
