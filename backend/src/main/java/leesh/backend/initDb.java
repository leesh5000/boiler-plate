package leesh.backend;

import leesh.backend.entity.User;
import leesh.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class initDb {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner loadInitData() {
        return args -> {
            log.info("init db start...");

            List<User> users = new ArrayList<>();;

            for (int i=0; i<30; i++) {
                User user = User.createUser("test" + i, passwordEncoder.encode("1111"));
                users.add(user);
            }

            userRepository.saveAll(users);

            log.info("init db end...");
        };
    }
}
