package course.services;

import course.com.springboot3project.entities.Category;
import course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService
{
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll()
    {
        return categoryRepository.findAll();
    }
    public Category findById(Long id)
    {
        Optional<Category> cat = categoryRepository.findById(id);
        return cat.orElse(null);
    }

}
