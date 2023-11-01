package com.ramcharan.Alien_Clock.repository;

import com.ramcharan.Alien_Clock.entity.UserContent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<UserContent,Integer> {
    UserContent findByUserName(String username);
}
