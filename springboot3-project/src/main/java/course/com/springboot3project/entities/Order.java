package course.com.springboot3project.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import course.com.springboot3project.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable
{
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    @Column(name = "data")
    private Instant data;


    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem2> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL )
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public Order()
    {
    }

    public Order(Long id, Instant data, User client, OrderStatus status)
    {
        this.id = id;
        this.data = data;
        this.client = client;
        this.orderStatus = status;
    }

    public Set<OrderItem2> getItems()
    {
        return items;
    }


    public Long getId()
    {
        return id;
    }

    public Instant getData()
    {
        return data;
    }

    public void setData(Instant data)
    {
        this.data = data;
    }

    public User getClient()
    {
        return client;
    }

    public OrderStatus getStatus()
    {
        return orderStatus;
    }

    public void setStatus(OrderStatus status)
    {
        this.orderStatus = status;
    }


    public Payment getPayment()
    {
        return payment;
    }

    public void setPayment(Payment payment)
    {
        this.payment = payment;
    }
    public Double getTotal()
    {
        Double total = 0.0;
        for (OrderItem2 x : this.items) {
            total += x.getSubTotal();
        }
        return total;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(id);
    }

    @Override
    public String toString()
    {
        return "Order{" +
                "id=" + id +
                ", data=" + data +
                ", client=" + client +
                '}';
    }
}
