package com.darksideoftherainbow.model.database.applicationuser;

import com.darksideoftherainbow.jpa.JpaApplicationUserRepository;
import com.darksideoftherainbow.model.user.ApplicationUser;
import org.springframework.stereotype.Repository;

@Repository
public class ApplicationUserRepositoryImpl implements ApplicationUserRepository {

    private final JpaApplicationUserRepository jpaApplicationUserRepository;

    public ApplicationUserRepositoryImpl(JpaApplicationUserRepository jpaApplicationUserRepository) {

        this.jpaApplicationUserRepository = jpaApplicationUserRepository;

    }

    @Override
    public ApplicationUser addUser(ApplicationUser user) {

        return jpaApplicationUserRepository.save(user);

    }

    @Override
    public ApplicationUser findByUserName(String username) {

        return jpaApplicationUserRepository.findByUsername(username);

    }
}
