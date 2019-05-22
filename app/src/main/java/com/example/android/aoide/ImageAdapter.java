package com.example.android.aoide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class ImageAdapter extends ArrayAdapter<AlbumGrid> {

    /**
     * Constructor
     * Context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists
     *
     * @param context    The current context. Used to inflate the layout file.
     * @param albumGrids A list of word objects to display in a list
     */

    public ImageAdapter(Context context, ArrayList<AlbumGrid> albumGrids) {
        // Sets the initial ArrayAdapters storage
        super(context, 0, albumGrids);
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
        View gridAlbumView = convertView;
        if (gridAlbumView == null) {
            gridAlbumView = LayoutInflater.from(getContext()).inflate
                    (R.layout.grid_album_view, parent, false);
        }

        // Get the data item for this position
        AlbumGrid currentAlbum = getItem(position);


        // Find the TextView in the grid_album_view.xml layout with ID grid_text_album
        TextView albumTextView = (TextView) gridAlbumView.findViewById(R.id.grid_text_album);

        // Find the TextView in the grid_album_view.xml layout with ID grid_text_artist
        TextView artistTextView = (TextView) gridAlbumView.findViewById(R.id.grid_text_artist);

        /*
         * Populates the data into the template view using the data object
         */

        // Gets the length of the album title
        int albumTextLength = currentAlbum.getAlbumText().length();
        // Checks if length of album title is longer than 20 CHAR and limits it true
        if (albumTextLength > 20) {
            String albumText = currentAlbum.getAlbumText().substring(0, 20);
            albumTextView.setText(albumText + "...");
        } else {
            albumTextView.setText(currentAlbum.getAlbumText());
        }

        // Gets the length of the artist's name
        int artistTextLength = currentAlbum.getArtistText().length();
        // Checks if length of artist's name is longer than 20 CHAR and limits it true
        if (artistTextLength > 20) {
            String artistText = currentAlbum.getArtistText().substring(0, 20);
            artistTextView.setText(artistText + "...");
        } else {
            artistTextView.setText(currentAlbum.getArtistText());
        }

        // Find the ImageView in the grid_album_view.xml layout with the ID list_item_icon
        ImageView albumImageView = (ImageView) gridAlbumView.findViewById(R.id.grid_album_image);
        // Get the image resource ID from the current album object and
        // set the image to albumImageView
        albumImageView.setImageResource(currentAlbum.getAlbumImageId());

        //Return the whole grid layout
        return gridAlbumView;

    }
}

