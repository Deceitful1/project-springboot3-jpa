package course.config;

import course.com.springboot3project.entities.Order;
import course.com.springboot3project.entities.User;
import course.com.springboot3project.resources.OrderResource;
import course.repositories.OrderRepository;
import course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
@EnableJpaRepositories(basePackageClasses = {UserRepository.class, OrderResource.class})

public class TestConfig implements CommandLineRunner
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception
    {
        User user1 = new User(null, "maria", "maria@gmail.com", "2222-2222", "12345");
        User user2 = new User(null, "alex", "alex@gmail.com", "3333-3333", "2340");
        Order order = new Order(null, Instant.parse("2022-05-21T12:35:00Z"), user1);
        Order order2 = new Order(null, Instant.parse("2024-06-21T22:10:00Z"), user1);
        Order order3 = new Order(null, Instant.parse("2024-06-21T22:10:00Z"), user2);

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order,order2,order3));

        userRepository.findAll();
        orderRepository.findAll();
    }
}


