package course.com.springboot3project;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
