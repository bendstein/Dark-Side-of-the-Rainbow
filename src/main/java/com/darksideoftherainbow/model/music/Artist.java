
package com.darksideoftherainbow.model.music;

import javax.persistence.*;

@Entity
@Table(name = "ARTIST")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTIST_ID_SEQ")
    @SequenceGenerator(name = "ARTIST_ID_SEQ", sequenceName = "ARTIST_ID_SEQ", allocationSize = 100)
    @Column(name = "ARTISTID")
    private int artistID;

    @Column(name = "ARTISTNAME")
    private String artist;

    //Constructor

    public Artist() {

    }

    public Artist(String artist) {
        this.artist = artist;
    }

    //Getters and Setters
    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}

