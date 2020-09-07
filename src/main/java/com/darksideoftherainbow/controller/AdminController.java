package com.darksideoftherainbow.controller;

import com.darksideoftherainbow.model.enums.Genre;
import com.darksideoftherainbow.model.music.Album;
import com.darksideoftherainbow.model.service.album.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin") //Start at /admin
public class AdminController {

    //Instance Data
    private final AlbumService albumService;

    //Constructor
    public AdminController(AlbumService albumService) {

        this.albumService = albumService;

    }

    //URL to page mapping

    //Add an album to the database
    @GetMapping("/albums/add")
    public String addForm(Model model) {

        return "add";

    }

    @PostMapping("/albums/add")
    public String addSubmit(Model model, @RequestParam("title") String title, @RequestParam("artist") String artist,
                            @RequestParam("release") int release, @RequestParam("genre") Genre genre,
                            @RequestParam("tracks") int tracks, @RequestParam("price") double price) {

        try {

            this.albumService.add(title, artist, release, genre, tracks, price);

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());
            return "add";

        }

        ArrayList<Album> albums = albumService.getAlbums();
        model.addAttribute("albums", albums);
        model.addAttribute("success", "The album has been successfully added.");
        return "view";

    }

    //Edit the album with a given id
    @GetMapping("/albums/edit/{ID}")
    public String editForm(Model model, @PathVariable int ID) {

        Album album = albumService.findID(ID);

        model.addAttribute("ID", album.getID());
        model.addAttribute("title", album.getTitle());
        model.addAttribute("artist", album.getArtist());
        model.addAttribute("release", album.getRelease());
        model.addAttribute("genre", album.getGenre());
        model.addAttribute("tracks", album.getTracks());
        model.addAttribute("price", album.getPrice());

        return "edit";

    }

    @PostMapping("/albums/edit")
    public String editSubmit(Model model, @RequestParam("ID") int ID, @RequestParam("title") String title, @RequestParam("artist") String artist,
                             @RequestParam("release")int release, @RequestParam("genre") Genre genre,
                             @RequestParam("tracks") int tracks, @RequestParam("price") double price) {

        try {

            this.albumService.edit(ID, title, artist, release, genre, tracks, price);

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());
            return "edit";

        }
        ArrayList<Album> albums = albumService.getAlbums();
        model.addAttribute("albums", albums);
        model.addAttribute("success", "The album has been successfully edited.");
        return "view";

    }

    @GetMapping("/albums/delete/{ID}")
    public String delete(@PathVariable int ID, Model model) {

        albumService.remove(ID);
        ArrayList<Album> albums = albumService.getAlbums();
        model.addAttribute("albums", albums);
        model.addAttribute("success", "The album has been successfully deleted.");
        return "view";

    }

    @GetMapping("/albums/view")
    public String view(Model model) {

        ArrayList<Album> albums = albumService.getAlbums();
        model.addAttribute("albums", albums);
        return "view";

    }

}
