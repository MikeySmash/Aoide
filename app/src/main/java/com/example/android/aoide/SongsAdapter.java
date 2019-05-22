package com.example.android.aoide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class SongsAdapter extends ArrayAdapter<Songs> {

    /**
     * Constructor
     * Context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists
     *
     * @param context    The current context. Used to inflate the layout file.
     * @param songArrays A list of song objects to display in a list
     */

    public SongsAdapter(Context context, ArrayList<Songs> songArrays) {
        // Sets the initial ArrayAdapters storage
        super(context, 0, songArrays);
    }

    /**
     * Provides a view for an AdapterView
     *
     * @param position    The position in the list of data that should be
     *                    displayed in the list item view.
     * @param convertView The recylced view to populate
     * @param parent      The parent ViewGroup that is used for the inflation
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check if the existing view is being reused, otherwise inflate the view
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate
                    (R.layout.songs_list_view, parent, false);
        }

        // Get the data item for this position
        Songs currentSong = getItem(position);

        // Find the TextView in the songs_list_view.xml layout with ID song_title
        TextView songTitleView = (TextView) listView.findViewById(R.id.song_title);

        // Find the TextView in the songs_list_view.xml layout with ID song_length
        TextView songLengthView = (TextView) listView.findViewById(R.id.song_length);

        /*
         * Populates the data into the template view using the data object
         */

        // Gets the length of the song title
        int songTextLength = currentSong.getSongText().length();
        // Checks if length of song title is longer than 35 CHAR and limits it true
        if (songTextLength > 35) {
            String songText = currentSong.getSongText().substring(0, 35);
            songTitleView.setText(songText + "...");
        } else {
            songTitleView.setText(currentSong.getSongText());
        }

        // Sets the time for the song
        songLengthView.setText(currentSong.getLengthText());

        //Return the whole grid layout
        return listView;

    }
}

