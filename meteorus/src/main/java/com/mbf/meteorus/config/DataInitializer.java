package com.mbf.meteorus.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mbf.meteorus.model.UserEntity;
import com.mbf.meteorus.repository.UserRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("user").isEmpty()) {
                UserEntity admin = new UserEntity();
                admin.setUsername("user");
                admin.setPassword(passwordEncoder.encode("123"));
                admin.setRole("ROLE_USER");
                admin.setEnabled(true);

                userRepository.save(admin);
                System.out.println(">>> Usuário 'admin' criado no PostgreSQL!");
            }
        };
    }
}