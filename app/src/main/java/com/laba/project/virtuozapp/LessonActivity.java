package com.laba.project.virtuozapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LessonActivity extends AppCompatActivity {
        TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        textView = findViewById(R.id.lesson);
        textView.setText(getText(R.string.Lesson1context));
        if (getIntent().getExtras().getString("lessonname").equals(getResources().getString(R.string.Lesson1)))
        textView.setText(getText(R.string.Lesson1context));

    }
}
