package com.darksideoftherainbow.model.service.album;

import com.darksideoftherainbow.model.database.album.AlbumDatabase;
import com.darksideoftherainbow.model.enums.Genre;
import com.darksideoftherainbow.model.music.Album;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class AlbumService implements AlbumServiceInterface {

    //Instance Data
    private final AlbumDatabase albumDatabase;

    //Constructor
    public AlbumService(AlbumDatabase albumDatabase) {

        this.albumDatabase = albumDatabase;

    }

    @Override
    public ArrayList<Album> getAlbums() {
        return albumDatabase.getDatabase();
    }

    @Override
    public void add(String title, String artist, int release, Genre genre, int tracks, double price) throws Exception {

        Album current;

        if(title == null || title.isEmpty()) throw new Exception("Title cannot be null!");
        if(artist == null || artist.isEmpty()) throw new Exception("Artist cannot be null!");
        if(release < 1700 || release > 3000) throw new Exception("Invalid year");
        if(genre == null) throw new Exception("Invalid Genre!");
        if(tracks < 0) throw new Exception("Cannot have a negative track count!");
        if(price < 0) throw new Exception("Price can't be negative!");

        current = new Album(title, artist, release, genre, tracks, price);

        albumDatabase.add(current);

    }

    @Override
    public ArrayList<Album> filterAlbum(String filter) {
        return (ArrayList<Album>)albumDatabase.getDatabase().stream().filter(a -> a.getTitle().toLowerCase().contains(filter.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public ArrayList<Album> filterArtist(String filter) {
        return (ArrayList<Album>)albumDatabase.getDatabase().stream().filter(a -> a.getArtist().toLowerCase().contains(filter.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public ArrayList<Album> findTitle(String s) {
        return albumDatabase.findTitle(s);
    }

    @Override
    public ArrayList<Album> findArtist(String s) {
        return albumDatabase.findArtist(s);
    }

    @Override
    public Album findID(int ID) {
        return albumDatabase.findID(ID);
    }

    @Override
    public ArrayList<Album> find(String s) {
        return albumDatabase.find(s);
    }

    @Override
    public void edit(int ID, String title, String artist, int release, Genre genre, int tracks, double price) throws Exception {

        albumDatabase.edit(ID, title, artist, release, genre, tracks, price);

    }

    @Override
    public void remove(Album album) {

        albumDatabase.remove(album);

    }

    @Override
    public void remove(int ID) {

        albumDatabase.remove(ID);

    }
}
