package com.example.android.aoide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaySongFragment extends Fragment {
    public int playPause = 1;

    public PlaySongFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Sets up fragment view to inflate
        View rootView = inflater.inflate(R.layout.fragment_play_song, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.song_text_fragment);

        //Switches between play and pause icons when clicked in playing song fragment
        final ImageView playImage = (ImageView) rootView.findViewById(R.id.play_pause);
        playImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (playPause == 1) {
                    playImage.setImageResource(R.drawable.ic_pause);
                    playPause = 2;
                } else if (playPause == 2) {
                    playImage.setImageResource(R.drawable.ic_play_arrow);
                    playPause = 1;
                }
            }
        });

        // Gets song name from list view
        if (getArguments() != null) {
            String song = getArguments().getString("currentSong");
            int songLength = song.length();
            if (songLength > 20) {
                song = song.substring(0, 20);
                textView.setText(song + "...");
            } else {
                textView.setText(song);
            }

        }

        // Inflate the layout for this fragment
        return rootView;
    }
}