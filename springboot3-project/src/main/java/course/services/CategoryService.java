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

    public Category insert(Category category)
    {
        return categoryRepository.save(category);
    }

    public Category update(Long id, Category category)
    {
        Category cat = categoryRepository.getReferenceById(id);
        updateData(cat,category);
        return categoryRepository.save(cat);
    }
    public void delete(Long id)
    {
        categoryRepository.deleteById(id);
    }



    private void updateData(Category cat, Category category)
    {
      cat.setName(category.getName());
    }


}
