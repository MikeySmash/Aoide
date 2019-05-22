package com.example.android.aoide;

/**
 * {@link Songs} represents songs displayed in the list view.
 * It contains a song title and length.
 */
public class Songs {

    /**
     * Song title
     */
    private String mSongText;
    /**
     * Song length
     */
    private String mLengthText;

    /**
     * Create a new ListView object.
     *
     * @param songText   Song title
     * @param lengthText Length of song
     */
    public Songs(String songText, String lengthText) {
        mSongText = songText;
        mLengthText = lengthText;
    }

    // Get the song title
    public String getSongText() {
        return mSongText;
    }

    // Get the song length
    public String getLengthText() {
        return mLengthText;
    }

}

