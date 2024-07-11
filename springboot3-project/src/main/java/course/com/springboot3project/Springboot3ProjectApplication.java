package course.com.springboot3project;

import course.com.springboot3project.entities.enums.OrderStatus;
import course.com.springboot3project.resources.CategoryResource;
import course.com.springboot3project.resources.OrderResource;
import course.com.springboot3project.resources.ProductResource;
import course.com.springboot3project.resources.UserResource;
import course.config.TestConfig;
import course.repositories.CategoryRepository;
import course.repositories.OrderRepository;
import course.repositories.ProductRepository;
import course.repositories.UserRepository;
import course.services.CategoryService;
import course.services.OrderService;
import course.services.ProductService;
import course.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {TestConfig.class, UserRepository.class, UserResource.class, UserService.class,
        OrderResource.class, OrderRepository.class, OrderService.class, OrderStatus.class,
        CategoryResource.class, CategoryService.class, CategoryRepository.class, ProductRepository.class, ProductResource.class, ProductService.class})

public class Springboot3ProjectApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(Springboot3ProjectApplication.class, args);


    }

}
