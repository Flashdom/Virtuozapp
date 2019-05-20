package com.laba.project.virtuozapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class LessonsActivity extends AppCompatActivity implements MyRecyclerViewAdapterForLessons.ItemClickListener {

    RecyclerView recyclerView;
    MyRecyclerViewAdapterForLessons adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);
        ArrayList<String> lessonsList = new ArrayList<>();
        lessonsList.add(getResources().getString(R.string.Lesson1));
        lessonsList.add(getResources().getString(R.string.Lesson2));
        lessonsList.add(getResources().getString(R.string.Lesson3));
        lessonsList.add(getResources().getString(R.string.Lesson4));
        lessonsList.add(getResources().getString(R.string.Lesson5));
        recyclerView=findViewById(R.id.lessonsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapterForLessons(this, lessonsList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
