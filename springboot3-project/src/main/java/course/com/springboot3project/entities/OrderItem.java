package course.com.springboot3project.entities;

import course.com.springboot3project.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable
{

    @EmbeddedId
    private OrderItemPK id;

    private Integer quantity;
    private Double price;

    public OrderItem()
    {
    }

    public OrderItem(Order order, Product prod, Integer quantity, Double price)
    {
        id.setOrder(order);
        id.setProduct(prod);
        this.quantity = quantity;
        this.price = price;
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
