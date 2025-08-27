package com.skillstorm.music.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.music.models.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>{

    // allow us to search for users by username
    public Optional<AppUser> findByUsername(String username);
}
