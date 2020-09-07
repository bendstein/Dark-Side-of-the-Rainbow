package com.darksideoftherainbow.jpa;

import com.darksideoftherainbow.model.music.Album;
import org.springframework.data.repository.CrudRepository;

public interface JpaAlbumRepository extends CrudRepository<Album, Integer> {
}
