package course.com.springboot3project;

import course.com.springboot3project.entities.enums.OrderStatus;
import course.com.springboot3project.resources.*;
import course.config.TestConfig;
import course.repositories.*;
import course.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {TestConfig.class, UserRepository.class, UserResource.class, UserService.class,
        OrderResource.class, OrderRepository.class, OrderService.class, OrderStatus.class,
        CategoryResource.class, CategoryService.class, CategoryRepository.class, ProductRepository.class, ProductResource.class, ProductService.class,
        PaymentRepository.class, PaymentService.class, PaymentResource.class})

public class Springboot3ProjectApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(Springboot3ProjectApplication.class, args);


    }

}
