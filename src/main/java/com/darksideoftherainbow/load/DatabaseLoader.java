package com.darksideoftherainbow.load;

import com.darksideoftherainbow.model.database.album.AlbumDatabase;
import com.darksideoftherainbow.model.database.applicationuser.ApplicationUserRepository;
import com.darksideoftherainbow.model.enums.Genre;
import com.darksideoftherainbow.model.music.Album;
import com.darksideoftherainbow.model.user.ApplicationUser;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    //Instance data
    private final AlbumDatabase albumRepo;
    private final ApplicationUserRepository applicationUserRepo;

    public DatabaseLoader(AlbumDatabase albumRepo, ApplicationUserRepository applicationUserRepo) {

        this.albumRepo = albumRepo;
        this.applicationUserRepo = applicationUserRepo;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        try {

            //Initializes the album database.
            this.albumRepo.add(new Album("Desperado", "Eagles", 1973,
                    Genre.Rock, 11, 12.99));
            this.albumRepo.add(new Album("Sgt Peppers Lonely Hearts Club Band", "The Beatles", 1967,
                    Genre.Rock, 13, 14.99));
            this.albumRepo.add(new Album("American Idiot", "Green Day", 2004,
                    Genre.Rock, 9, 10.99));
            this.albumRepo.add(new Album("Nevermind", "Nirvana", 1991,
                    Genre.Rock, 13, 14.99));

        } catch (Exception e) {

            e.printStackTrace();

        }



        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        ApplicationUser admin = new ApplicationUser("admin", encoder.encode("123456"), true);
        this.applicationUserRepo.addUser(admin);

    }
}
