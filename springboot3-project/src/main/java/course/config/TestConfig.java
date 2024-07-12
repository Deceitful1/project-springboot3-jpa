package course.config;

import course.com.springboot3project.entities.*;
import course.com.springboot3project.entities.enums.OrderStatus;
import course.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
@EnableJpaRepositories(basePackageClasses = {UserRepository.class, OrderRepository.class})

public class TestConfig implements CommandLineRunner
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository2 orderItemRepository2;
    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public void run(String... args)
    {
        Category cat1 = new Category(null, "Books");
        Category cat2 = new Category(null, "Electronics");
        Category cat3 = new Category(null, "Fashion");
        Category cat4 = new Category(null, "Food");
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        p1.getCategories().add(cat1);
        p2.getCategories().add(cat2);
        p3.getCategories().add(cat2);
        p4.getCategories().add(cat2);
        p5.getCategories().add(cat1);
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));


        User user1 = new User(null, "maria", "maria@gmail.com", "2222-2222", "12345");
        User user2 = new User(null, "alex", "alex@gmail.com", "3333-3333", "2340");
        Order order = new Order(null, Instant.parse("2022-05-21T12:35:00Z"), user1, OrderStatus.CANCELED);
        Order order2 = new Order(null, Instant.parse("2024-06-21T22:10:00Z"), user1, OrderStatus.CANCELED);
        Order order3 = new Order(null, Instant.parse("2024-06-21T22:10:00Z"), user2, OrderStatus.SHIPPED);


        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order, order2, order3));
        Category category = new Category(null, "electronics");


        OrderItem2 oi1 = new OrderItem2(order, p1, 2, p1.getPrice());
        OrderItem2 oi2 = new OrderItem2(order2, p3, 1, p3.getPrice());
        OrderItem2 oi3 = new OrderItem2(order3, p3, 2, p3.getPrice());
        OrderItem2 oi4 = new OrderItem2(order2, p5, 2, p5.getPrice());

        userRepository.findAll();
        orderRepository.findAll();
        orderItemRepository2.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));


        Payment payment = new Payment(null, Instant.parse("2024-06-21T22:10:00Z"), order2);
        order2.setPayment(payment);

        orderRepository.save(order2);

    }
}


