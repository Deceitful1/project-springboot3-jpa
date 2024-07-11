package course.com.springboot3project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import course.com.springboot3project.entities.pk.OrderItemPK;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable
{

    @EmbeddedId
    @JsonIgnore
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private Double price;
    private String productName;


    public OrderItem()
    {
    }

    public OrderItem(Order order, Product prod, Integer quantity, Double price)
    {
        id.setOrder(order);
        id.setProduct(prod);
        this.quantity = quantity;
        this.price = price;
        productName = prod.getName();
    }

    public OrderItemPK getId()
    {
        return id;
    }
    public Order getOrder(Order order)
    {
        return id.getOrder();
    }
    public void setOrder(Order order)
    {
        this.id.setOrder(order);
    }
    @JsonIgnore
    public Product getProduct(Product product)
    {
     return id.getProduct();
    }
    public void setProduct(Product product)
    {
        id.setProduct(product);
    }




    public void setId(OrderItemPK id)
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(id);
    }

    @Override
    public String toString()
    {
        return "OrderItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
