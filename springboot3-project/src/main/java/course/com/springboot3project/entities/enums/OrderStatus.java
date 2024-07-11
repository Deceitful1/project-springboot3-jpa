package course.com.springboot3project.entities.enums;

import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import org.springframework.stereotype.Repository;

@Table(name = "status_do_pedido")
public enum OrderStatus
{
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int cod;

    private OrderStatus(int cod)
    {
        this.cod = cod;
    }

    public int getCod()
    {
        return cod;
    }

    public static OrderStatus valueOf(int cod)
    {
        for (OrderStatus o : OrderStatus.values()) {
            if (o.getCod() == cod) {
                return o;
            } else {
                throw new IllegalArgumentException("Invalid OrderStatus");
            }
        }
        return null;
    }


}
