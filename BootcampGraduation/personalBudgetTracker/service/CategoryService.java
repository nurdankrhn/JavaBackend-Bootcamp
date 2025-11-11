package budgettracker.service;

import budgettracker.model.Category;
import budgettracker.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // Constructor Injection
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Find all categories
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    // Save a category entity
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}
