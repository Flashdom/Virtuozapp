package com.laba.project.virtuozapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity implements MyRecyclerViewAdapterForSongs.ItemClickListener {
    RecyclerView recyclerView;
    MyRecyclerViewAdapterForSongs adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ArrayList<String> songList = new ArrayList<>();
        songList.add("Wake me up");
        songList.add("Black or white");
        songList.add("Send me an angel");
        songList.add("Это все");
        songList.add("Выхода нет");
        songList.add("ДАДАЯ");
        recyclerView = findViewById(R.id.bandsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapterForSongs(this, songList);
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
