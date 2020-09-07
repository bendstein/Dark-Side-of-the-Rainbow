package com.darksideoftherainbow.model.service.applicationuser;

import com.darksideoftherainbow.model.user.ApplicationUser;

public interface ApplicationUserService {

    ApplicationUser findByUserName(String username);

}
