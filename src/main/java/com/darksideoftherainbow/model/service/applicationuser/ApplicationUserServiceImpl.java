package com.darksideoftherainbow.model.service.applicationuser;

import com.darksideoftherainbow.model.database.applicationuser.ApplicationUserRepository;
import com.darksideoftherainbow.model.user.ApplicationUser;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    //Instance data
    private final ApplicationUserRepository applicationUserRepository;

    public ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository) {

        this.applicationUserRepository = applicationUserRepository;

    }

    @Override
    public ApplicationUser findByUserName(String username) {

        return applicationUserRepository.findByUserName(username);

    }
}
