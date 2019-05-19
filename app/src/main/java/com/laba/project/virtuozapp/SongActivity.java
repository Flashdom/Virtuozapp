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
    Button process;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        textView=findViewById(R.id.song);
        play=findViewById(R.id.play);
        flat=findViewById(R.id.flat);
        sharp=findViewById(R.id.sharp);
        tv=findViewById(R.id.current_tone);
        tv.setText("0");



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
                        nc= new NetworkConnector();
                        nc.send();
                        nc.receive();
                    }
                }).start();
            }
        });


    }
}
