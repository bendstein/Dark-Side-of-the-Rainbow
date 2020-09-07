package com.darksideoftherainbow.model.database.album;

import com.darksideoftherainbow.model.enums.Genre;
import com.darksideoftherainbow.model.music.Album;

import java.util.ArrayList;

public interface AlbumDatabaseInterface {

    public ArrayList<Album> getDatabase();

    void add(Album album);

    void remove(Album album);

    void remove(int ID);

    void edit(int ID, String title, String artist, int release, Genre genre, int tracks, double price) throws Exception;

    ArrayList<Album> findTitle(String s);

    ArrayList<Album> findArtist(String s);

    Album findID(int ID);

    ArrayList<Album> find(String s);
}
