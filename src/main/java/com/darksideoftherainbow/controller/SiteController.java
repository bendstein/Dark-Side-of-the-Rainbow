package com.darksideoftherainbow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    //Instance Data
    //Constructor
    public SiteController() {

    }

    //URL to page mapping

    //Contact the owners of the store via email
    @GetMapping("/contact_us")
    public String contactUs(Model model) {

        return "contact_us";

    }

    //Log in as admin
    @GetMapping("/login")
    public String login(Model model) {

        return "login";

    }

    @GetMapping("/login_failure")
    public String loginFail(Model model) {

        model.addAttribute("failure", "Incorrect credentials.");
        return "login";

    }


}
