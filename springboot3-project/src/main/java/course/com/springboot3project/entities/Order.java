package course.com.springboot3project.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable
{
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data")
    private Instant data;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order()
    {
    }

    public Order(Long id, Instant data, User client)
    {
        this.id = id;
        this.data = data;
        this.client = client;
    }

    public Long getId()
    {
        return id;
    }

    public Instant getData()
    {
        return data;
    }

    public User getClient()
    {
        return client;
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
