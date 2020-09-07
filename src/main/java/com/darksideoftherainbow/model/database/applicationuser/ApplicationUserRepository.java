package com.darksideoftherainbow.model.database.applicationuser;

import com.darksideoftherainbow.model.user.ApplicationUser;

public interface ApplicationUserRepository {

    ApplicationUser addUser(ApplicationUser user);

    ApplicationUser findByUserName(String username);

}
