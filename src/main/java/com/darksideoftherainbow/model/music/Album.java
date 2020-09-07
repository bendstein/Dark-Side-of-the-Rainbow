package com.darksideoftherainbow.model.music;

import com.darksideoftherainbow.model.enums.Genre;

import javax.persistence.*;

@Entity
@Table(name = "ALBUM")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALBUM_ID_SEQ")
    @SequenceGenerator(name = "ALBUM_ID_SEQ", sequenceName = "ALBUM_ID_SEQ", allocationSize = 100)
    private int ID; //The album's unique identifier
    private String title; //The name of the album

    @Column(name = "ARTISTNAME")
    private String artist; //The composer of the album

    private int release; //The year the album was released

    //http://dolszewski.com/java/save-enum-database-jpa/
    @Enumerated(EnumType.STRING)
    private Genre genre; //The main genre of the album

    private int tracks; //Number of tracks on the album
    private double price; //The price of the album

    //Constructor
    public Album() {

    }
    public Album(String title, String artist, int release, Genre genre,
                 int tracks, double price) {
        this.title = title;
        this.artist = artist;
        this.release = release;
        this.genre = genre;
        this.tracks = tracks;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getTracks() {
        return tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    //Other

}
