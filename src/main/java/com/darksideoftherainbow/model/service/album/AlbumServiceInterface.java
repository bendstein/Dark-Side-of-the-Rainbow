package com.darksideoftherainbow.model.service.album;

import com.darksideoftherainbow.model.enums.Genre;
import com.darksideoftherainbow.model.music.Album;

import java.util.ArrayList;

public interface AlbumServiceInterface {

    ArrayList<Album> getAlbums();

    void add(String title, String artist, int release, Genre genre, int tracks, double price) throws Exception;

    ArrayList<Album> filterAlbum(String filter);

    ArrayList<Album> filterArtist(String filter);

    ArrayList<Album> findTitle(String s);

    ArrayList<Album> findArtist(String s);

    Album findID(int ID);

    ArrayList<Album> find(String s);

    void edit(int ID, String title, String artist, int release, Genre genre, int tracks, double price) throws Exception;

    void remove(Album album);

    void remove(int ID);

}
