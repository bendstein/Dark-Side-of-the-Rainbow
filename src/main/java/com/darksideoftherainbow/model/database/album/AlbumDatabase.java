package com.darksideoftherainbow.model.database.album;

import com.darksideoftherainbow.jpa.JpaAlbumRepository;
import com.darksideoftherainbow.jpa.JpaArtistRepository;
import com.darksideoftherainbow.model.enums.Genre;
import com.darksideoftherainbow.model.music.Album;
import com.darksideoftherainbow.model.music.Artist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class AlbumDatabase implements AlbumDatabaseInterface {

    //Instance data
    private final JpaAlbumRepository jpaAlbumRepository;
    private final JpaArtistRepository jpaArtistRepository;

    //Constructors
    public AlbumDatabase(JpaAlbumRepository jpaAlbumRepository, JpaArtistRepository jpaArtistRepository) {
        this.jpaAlbumRepository = jpaAlbumRepository;
        this.jpaArtistRepository = jpaArtistRepository;
    }

    //Other

    @Override
    public ArrayList<Album> getDatabase() {

        return (ArrayList<Album>) jpaAlbumRepository.findAll();

    }

    @Override
    //Add an album to the end of the database
    public void add(Album album) {

        jpaAlbumRepository.save(album);

        ArrayList<Artist> searchResults = new ArrayList<>();

        //Only save artist to database if they're not already there
        ((ArrayList<Artist>)jpaArtistRepository.findAll()).forEach(s -> {
            if(s.getArtist().equals(album.getArtist())) searchResults.add(s);
        });

        if(searchResults.isEmpty()) jpaArtistRepository.save(new Artist(album.getArtist()));

    }

    @Override
    //Remove an album and refactor IDs
    public void remove(Album album) {

        jpaAlbumRepository.delete(album);

        //Remove artist from database if no other albums by same artist
        ArrayList<Album> searchResults = findArtist(album.getArtist());
        if(searchResults.isEmpty()){
            ((ArrayList<Artist>)jpaArtistRepository.findAll()).forEach(s -> {
                if(s.getArtist().equals(album.getArtist())) jpaArtistRepository.delete(s);
            });
        }
    }

    @Override
    //Remove an album and refactor IDs
    public void remove(int ID) {

        if(jpaAlbumRepository.findById(ID).isPresent()) {

            Album album = jpaAlbumRepository.findById(ID).get();
            remove(album);

        }

    }

    @Override
    //Edits a given album
    public void edit(int ID, String title, String artist, int release, Genre genre, int tracks, double price) throws Exception {

        if(title == null || title.isEmpty()) throw new Exception("Title cannot be null!");
        if(artist == null || artist.isEmpty()) throw new Exception("Artist cannot be null!");
        if(release < 1900 || release > 3000) throw new Exception("Invalid year");
        if(genre == null) throw new Exception("Invalid Genre!");
        if(tracks < 0) throw new Exception("Cannot have a negative track count!");
        if(price < 0) throw new Exception("Price can't be negative!");

        Album current = findID(ID);

        String old_artist = current.getArtist(); //The name of the artist before changing

        current.setTitle(title);
        current.setArtist(artist);
        current.setRelease(release);
        current.setGenre(genre);
        current.setTracks(tracks);
        current.setPrice(price);

        add(current);

        //Remove old artist from database if no other albums by same artist
        ArrayList<Album> searchResults = findArtist(old_artist);
        if(searchResults.isEmpty()){
            ((ArrayList<Artist>)jpaArtistRepository.findAll()).forEach(s -> {
                if(s.getArtist().equals(old_artist)) jpaArtistRepository.delete(s);
            });
        }

    }

    @Override
    //Returns all albums with the given title
    public ArrayList<Album> findTitle(String album_name) {

        ArrayList<Album> searchResults = new ArrayList<>();

        ((ArrayList<Album>)jpaAlbumRepository.findAll()).forEach(s -> {
            if(s.getTitle().equals(album_name))searchResults.add(s);
        });

        return searchResults;

    }

    @Override
    //Returns all albums with the given artist
    public ArrayList<Album> findArtist(String artist) {

        ArrayList<Album> searchResults = new ArrayList<>();

        ((ArrayList<Album>)jpaAlbumRepository.findAll()).forEach(s -> {
            if(s.getArtist().equals(artist))searchResults.add(s);
        });

        return searchResults;

    }

    @Override
    //Returns the album with the given ID
    public Album findID(int ID) {


        Optional<Album> album = jpaAlbumRepository.findById(ID);
        if (album.isPresent()) {
            return album.get();
        }
        throw new IllegalStateException("No album with ID " + ID + "!");

    }

    @Override
    //Tries all of the above search methods
    public ArrayList<Album> find(String s) {

        ArrayList<Album> searchResults = new ArrayList<>();
        searchResults.addAll(findTitle(s));
        searchResults.addAll(findArtist(s));

        //If the search term is an int, add corresponding album ID
        try {

            //searchResults.addAll(findID(Integer.parseInt(s)));
            searchResults.add(findID(Integer.parseInt(s)));

        } catch (NumberFormatException e) {

            System.out.println("The search term is not an ID.");

        }

        return searchResults;

    }
}
