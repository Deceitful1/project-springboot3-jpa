package course.com.springboot3project.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import course.com.springboot3project.entities.pk.OrderItem2PK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order2")
public class OrderItem2 implements Serializable
{
    @EmbeddedId
    @JsonIgnore
    private OrderItem2PK id = new OrderItem2PK();

    private Integer quantity;
    private Double price;
    private String prodName;

    public OrderItem2(Order order, Product product, Integer quantity, Double price)
    {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
        prodName = id.getProduct().getName();
    }

    public OrderItem2()
    {
    }

    public OrderItem2PK getId()
    {
        return id;
    }

    public void setId(OrderItem2PK id)
    {
        this.id = id;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Product getProduct()
    {
        return id.getProduct();
    }

    public void setProduct(Product product)
    {
        id.setProduct(product);
    }
    @JsonIgnore
    public Order getOrder()
    {
        return id.getOrder();
    }
    public void setOrder(Order order)
    {
       this.id.setOrder(order);
    }

    public Double getSubTotal()
    {
        return price * quantity;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem2 that = (OrderItem2) o;
        return Objects.equals(id, that.id);
    }


    @Override
    public int hashCode()
    {
        return Objects.hashCode(id);
    }

    @Override
    public String toString()
    {
        return "OrderItem2{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", prodName='" + prodName + '\'' +
                '}';
    }
}
