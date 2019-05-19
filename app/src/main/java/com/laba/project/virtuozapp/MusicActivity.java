package com.laba.project.virtuozapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Wake me up");
        animalNames.add("Black or white");
        animalNames.add("Send me an angel");
        animalNames.add("Это все");
        animalNames.add("Выхода нет");
        animalNames.add("ДАДАЯ");
        recyclerView = findViewById(R.id.bandsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }
    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(MusicActivity.this, SongActivity.class);
        intent.putExtra("songname", adapter.getItem(position));
        startActivity(intent);
    }
}
