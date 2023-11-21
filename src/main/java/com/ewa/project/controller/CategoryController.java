package com.ewa.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ewa.project.model.CategoryDto;
import com.ewa.project.service.CategoryService;

@RestController // The @RestController annotation indicates that this class is a spring MVC controller responsible for handling HTTP requests and returning data as response
@RequestMapping("/api/categories") // The @RequestMapping annotation sets the starting address ("/api/categories") for all the operations this controller handle and any operations in this class will be based on this address
public class CategoryController {
    @Autowired
    private CategoryService categoryService; // Automatically inject an instance of CategoryService

    @PostMapping("/createCategory")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto createdCategory = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/getAllCategories")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }


    @GetMapping("/{categoryId}")
    public CategoryDto getCategoryById(@PathVariable Long categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PutMapping("/{categoryId}")
    public CategoryDto updateCategory(@PathVariable Long categoryId, @RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(categoryId, categoryDto);
    }

    @DeleteMapping("/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) {
        return categoryService.deleteCategory(categoryId);
    }
}
