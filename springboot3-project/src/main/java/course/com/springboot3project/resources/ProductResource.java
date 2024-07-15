package course.com.springboot3project.resources;

import course.com.springboot3project.entities.Product;
import course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource
{
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts()
    {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id)
    {
        return ResponseEntity.ok().body(productService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product product)
    {
        product = productService.insert(product);
        return ResponseEntity.ok().body(product);
    }



}
