package course.repositories;

import course.com.springboot3project.entities.OrderItem;
import course.com.springboot3project.entities.OrderItem2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository2 extends JpaRepository<OrderItem2, Long>
{
}
