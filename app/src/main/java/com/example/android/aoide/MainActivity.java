package com.example.android.aoide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<AlbumGrid> albumGrids = new ArrayList<AlbumGrid>();

        // Create new word objects for the array list
        albumGrids.add(new AlbumGrid("Artist1Activity","All Love's Legal","Planningtorock",
                R.drawable.album1, R.drawable.lg_album1));
        albumGrids.add(new AlbumGrid("Artist2Activity","Wonder Where We Land","SBTRKT",
                R.drawable.album2, R.drawable.lg_album2));
        albumGrids.add(new AlbumGrid("Artist3Activity","Range of Light","S. Carey",
                R.drawable.album3, R.drawable.lg_album3));
        albumGrids.add(new AlbumGrid("Artist4Activity","Nabuma Rubberband","Little Dragon ",
                R.drawable.album4, R.drawable.lg_album4));
        albumGrids.add(new AlbumGrid("Artist5Activity","LP1","FKA Twigs",
                R.drawable.album5, R.drawable.lg_album5));
        albumGrids.add(new AlbumGrid("Artist6Activity","Do to the Beast","The Afghan Whigs",
                R.drawable.album8, R.drawable.lg_album8));

        // Adapter for grid of albums
        AlbumGridAdapter adapter = new AlbumGridAdapter(this, albumGrids);
        GridView gridView = (GridView) findViewById(R.id.gridview_albums);
        gridView.setAdapter(adapter);

        // Sets up on clicks for items in grid view
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                View v, int position, long id){
                // Finds current position in album array
                AlbumGrid currentAlbum = albumGrids.get(position);

                // Sets the name of the class for the intent
                String className = "com.example.android.aoide." + currentAlbum.getArtistId();

                // Intent for album grid items to open activity based on the current artist position
                Intent i = new Intent();
                i.setClassName("com.example.android.aoide", className);
                // Sends artistId, album titel, artist's name and large album image to next activity
                i.putExtra("artistId", currentAlbum.getArtistId());
                i.putExtra("albumText", currentAlbum.getAlbumText());
                i.putExtra("artistText", currentAlbum.getArtistText());
                i.putExtra("albumImageLarge", currentAlbum.getAlbumImageLargeId());
                startActivity(i);
            }
        });
    }
}
