package com.darksideoftherainbow.controller;

import com.darksideoftherainbow.model.music.Album;
import com.darksideoftherainbow.model.service.album.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class IndexController {

    //Instance Data
    private final AlbumService albumService;

    //Constructor
    public IndexController(AlbumService albumService) {

        this.albumService = albumService;

    }

    //URL to page mapping

    //Go to site index

    @GetMapping("/")
    public String index(Model model) {
        ArrayList<Album> albums = albumService.getAlbums();
        model.addAttribute("albums", albums);
        return "index";

    }

    @GetMapping("/index")
    public String index_redirect() {

        return "redirect:/";

    }

    //Search the album database
    @GetMapping("/search_album")
    public String indexAlbumFiltered(Model model, @RequestParam("term") String term) {

        ArrayList<Album> albums = albumService.filterAlbum(term);
        model.addAttribute("albums", albums);
        return "index";

    }

    @GetMapping("/search_artist")
    public String indexArtistFiltered(Model model, @RequestParam("term") String term) {

        ArrayList<Album> albums = albumService.filterArtist(term);
        model.addAttribute("albums", albums);
        return "index";

    }

    //Success page
    @GetMapping("/success")
    public String indexSuccess(Model model) {

        ArrayList<Album> albums = albumService.getAlbums();
        model.addAttribute("albums", albums);
        model.addAttribute("success", "Your changes have been successfully saved.");
        return "index";

    }

    @GetMapping("/login_success")
    public String loginSuccess(Model model) {
        ArrayList<Album> albums = albumService.getAlbums();
        model.addAttribute("albums", albums);
        model.addAttribute("success", "You have been successfully logged in.");
        return "index";
    }

    @GetMapping("/logout_success")
    public String logoutSuccess(Model model) {
        ArrayList<Album> albums = albumService.getAlbums();
        model.addAttribute("albums", albums);
        model.addAttribute("success", "You have been successfully logged out.");
        return "index";
    }


}
