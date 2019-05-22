package com.example.android.aoide;

/**
 * {@link AlbumGrid} represents text on grid view for albums.
 * It contains a artist name, album title and image.
 */
public class AlbumGrid {
    /** Album title */
    private String mArtistId;
    /** Album title */
    private String mAlbumText;
    /** Artist's name */
    private String mArtistText;
    /** Album image - small */
    private int mAlbumImageId;
    /** Album image - large */
    private int mAlbumImageLargeId;

    /**
     * Create a new AlbumGrid object.
     * @param artistId    Artist's name
     * @param albumText     Album title
     * @param artistText    Artist's name
     * @param albumImageId     Album image - small
     * @param albumImageLargeId     Album image - large

     */
    public AlbumGrid(String artistId, String albumText, String artistText, int albumImageId, int albumImageLargeId){
        mArtistId = artistId;
        mAlbumText = albumText;
        mArtistText = artistText;
        mAlbumImageId = albumImageId;
        mAlbumImageLargeId = albumImageLargeId;
    }
    // Get the artist ID
    public String getArtistId(){
        return mArtistId;
    }
    // Get the album title
    public String getAlbumText(){
        return mAlbumText;
    }
    // Get the artist's name
    public String getArtistText(){
        return mArtistText;
    }
    // Get the small album image
    public int getAlbumImageId(){
        return mAlbumImageId;
    }
    // Get the large album image
    public int getAlbumImageLargeId(){
        return mAlbumImageLargeId;
    }

}
