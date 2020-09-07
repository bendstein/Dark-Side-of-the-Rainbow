package com.darksideoftherainbow.jpa;

import com.darksideoftherainbow.model.user.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface JpaApplicationUserRepository extends CrudRepository<ApplicationUser, Integer> {
    ApplicationUser findByUsername(String username);
}
