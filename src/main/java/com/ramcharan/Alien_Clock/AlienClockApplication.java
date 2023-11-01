package com.ramcharan.Alien_Clock;

import com.ramcharan.Alien_Clock.entity.UserContent;
import com.ramcharan.Alien_Clock.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AlienClockApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlienClockApplication.class, args);
	}

	@Bean
	public CommandLineRunner initUsers(UserRepo userRepo){
		System.out.println("added to repo");

		return args -> {
			userRepo.save(new UserContent(101,"user1", "pw1", "user1@gmail.com"));
			userRepo.save(new UserContent(102,"user2", "pw2","user2@gmail.com"));
			userRepo.save(new UserContent(103,"user3", "pw3","user3@gmail.com"));
			userRepo.save(new UserContent(104,"user4", "pw4","user4@gmail.com"));
			userRepo.save(new UserContent(105,"user5", "pw5","user5@gmail.com"));
		};
	}

}
