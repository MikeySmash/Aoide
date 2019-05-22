package com.example.android.aoide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Artist6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        // Set playing song fragment to not visible
        View tv_msg = (View) findViewById(R.id.play_song_fragment);
        tv_msg.setVisibility(View.GONE);

        //collect our intent data to populate our layout
        Intent intent = getIntent();
        final String albumText = intent.getStringExtra("albumText");
        final String artistText = intent.getStringExtra("artistText");
        final Integer albumImageLg = intent.getExtras().getInt("albumImageLarge");

        // Sets album image
        ImageView albumImageLarge = (ImageView) findViewById(R.id.album_image_large);
        albumImageLarge.setImageResource(albumImageLg);

        // Sets artist name
        TextView artistName = (TextView) findViewById(R.id.artist_name);
        artistName.setText(artistText);

        // Sets album name
        TextView albumName = (TextView) findViewById(R.id.album_name);
        albumName.setText(albumText);

        // Songs in album array
        final ArrayList<Songs> songArrays = new ArrayList<>();

        // Create new songs objects for the array list
        songArrays.add(new Songs("1. Parked Outside", "4:37"));
        songArrays.add(new Songs("2. Matamoros", "2:43"));
        songArrays.add(new Songs("3. It Kills", "3:33"));
        songArrays.add(new Songs("4. Algiers", "4:03"));
        songArrays.add(new Songs("5. Lost in the Woods", "4:54"));
        songArrays.add(new Songs("6. The Lottery", "4:05"));
        songArrays.add(new Songs("7. Can Rova", "3:44"));
        songArrays.add(new Songs("8. Royal Cream", "4:33"));
        songArrays.add(new Songs("9. I Am Fire", "2:51"));
        songArrays.add(new Songs("10. These Sticks", "5:49"));


        // Adapter for songs list view
        SongsAdapter adapter = new SongsAdapter(this, songArrays);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Sets on click for each song in list to open playing song fragment
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {

                // Gets current positing in songs array
                Songs currentSong = songArrays.get(position);
                // Sets name of song in current position
                String songName = currentSong.getSongText();

                // Sets playing song fragment to visible
                View playFragment = (View) findViewById(R.id.play_song_fragment);
                playFragment.setVisibility(View.VISIBLE);

                // Bundles data for PlaySong fragment
                Bundle bundle = new Bundle();
                bundle.putString("currentSong", songName);

                // Sets up fragment for playing song layout and sends song name
                PlaySongFragment playSong = new PlaySongFragment();
                FragmentManager manager = getSupportFragmentManager();
                playSong.setArguments(bundle);
                manager.beginTransaction()
                        .replace(R.id.play_song_fragment, playSong, playSong.getTag())
                        .commit();
            }
        });
    }
}

