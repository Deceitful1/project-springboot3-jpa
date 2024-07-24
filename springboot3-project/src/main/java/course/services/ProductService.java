package course.services;

import course.com.springboot3project.entities.Product;
import course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;
    public List<Product> findAll()
    {
        return productRepository.findAll();
    }

    public Product findById(Long id)
    {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }
    public Product insert(Product product)
    {
        return productRepository.save(product);
    }
    public void delete(Long id)
    {
        productRepository.deleteById(id);
    }

    public Product update(Long id, Product product)
    {
        Product prod = productRepository.getReferenceById(id);
        updateData(prod,product);
        return productRepository.save(prod);
    }


    public void updateData(Product product,Product newProducto)
    {
        product.setName(new String(newProducto.getName()));
        product.setDescription(newProducto.getDescription());
    }






}
