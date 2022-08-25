package org.test.tp01.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthConfig {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthConfig(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner initUser() {
        return args -> {
            User user_admin = userRepository.save(new User("admin",passwordEncoder.encode("admin")));
            User user_manager = userRepository.save(new User("manager",passwordEncoder.encode("manager")));

            Authority authority_write = authorityRepository.save(new Authority("product:write"));
            Authority authority_read = authorityRepository.save(new Authority("product:read"));
            Authority authority_delete = authorityRepository.save(new Authority("product:delete"));
            Authority role_admin = authorityRepository.save(new Authority("ROLE_ADMIN"));
            Authority role_manager = authorityRepository.save(new Authority("ROLE_MANAGER"));

            role_admin.getUsers().add(user_admin);
            authorityRepository.save(role_admin);
            role_manager.getUsers().add(user_manager);
            authorityRepository.save(role_manager);

            authority_write.getUsers().add(user_admin);
            authority_write.getUsers().add(user_manager);
            authorityRepository.save(authority_write);

            authority_read.getUsers().add(user_admin);
            authority_read.getUsers().add(user_manager);
            authorityRepository.save(authority_read);

            authority_delete.getUsers().add(user_admin);
            authorityRepository.save(authority_delete);
        };
    }
}
