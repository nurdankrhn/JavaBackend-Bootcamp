package budgettracker.controller;

import budgettracker.model.Category;
import budgettracker.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Get all categories
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    // Add a new category
    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.saveCategory(category);
        return ResponseEntity.ok(savedCategory);
    }
}
