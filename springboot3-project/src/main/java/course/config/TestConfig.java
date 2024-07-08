package course.config;

import course.com.springboot3project.entities.User;
import course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import java.util.Arrays;

@Configuration
@Profile("test")
@EnableJpaRepositories(basePackageClasses = UserRepository.class)

public class TestConfig implements CommandLineRunner
{
    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception
    {
        User user1 = new User(null, "maria", "maria@gmail.com", "2222-2222", "12345");
        User user2 = new User(null, "alex", "alex@gmail.com", "3333-3333", "2340");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}


