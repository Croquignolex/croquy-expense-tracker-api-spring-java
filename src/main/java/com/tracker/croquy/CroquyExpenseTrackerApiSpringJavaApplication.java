package com.tracker.croquy;

import com.tracker.croquy.v1.enums.Role;
import com.tracker.croquy.v1.repositories.UserRepository;
import com.tracker.croquy.v1.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class CroquyExpenseTrackerApiSpringJavaApplication {
	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CroquyExpenseTrackerApiSpringJavaApplication.class, args);
	}

	@GetMapping(path = "/ping")
	public String ping() {
		return "pong";
	}

	@Bean
	public CommandLineRunner run() {
		return (String[] args) -> {
			if(userRepository.findByUsername("user100").isEmpty()) {
				List<User> users = new ArrayList<>();

				User user = userRepository.save(seedUsers(100, Role.OWNER));

				for(int i = 0; i < 10; i++){
					users.add(seedUsers(i + 200, Role.USER));
					users.add(seedUsers(i + 300, Role.WATCHER));
				}

				userRepository.saveAll(users);
			}
		};
	}

	private User seedUsers(int i, Role role) {
		User user = new User();
		user.setEmail("user" + i + "@croquextra.com");
		user.setFirstName("User " + i);
		user.setUsername("user" + i);
		user.setPassword("user");
		user.setRole(role);
		return user;
	}
}
