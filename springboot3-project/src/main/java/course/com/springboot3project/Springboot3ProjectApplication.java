package course.com.springboot3project;

import course.com.springboot3project.resources.UserResource;
import course.config.TestConfig;
import course.repositories.UserRepository;
import course.services.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {TestConfig.class, UserRepository.class, UserResource.class, UserService.class})
public class Springboot3ProjectApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(Springboot3ProjectApplication.class, args);
        /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testdb");
        EntityManager em = emf.createEntityManager();

         */

    }

}
