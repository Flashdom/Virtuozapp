package com.laba.project.virtuozapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button musicButton;
    Button lessonButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        musicButton=findViewById(R.id.musicButton);
        lessonButton=findViewById(R.id.lessonButton);
        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MusicActivity.class);
                startActivity(intent);
            }
        });
        lessonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LessonsActivity.class);
                startActivity(intent);
            }
        });
    }
}
