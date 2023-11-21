package com.ewa.project.serviceimpl;

import com.ewa.project.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewa.project.converter.CategoryConverter;
import com.ewa.project.dao.CategoryRepository;
import com.ewa.project.entity.Category;
import com.ewa.project.model.CategoryDto;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = categoryConverter.dtoToEntity(categoryDto);
        category = categoryRepository.save(category);
        return categoryConverter.entityToDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();

        for (Category category : categories) {
            categoryDtos.add(categoryConverter.entityToDto(category));
        }

        return categoryDtos;
    }

    
    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Category category = categoryRepository.findByCategoryId(categoryId);
        if (category == null) {
            throw new RuntimeException("Category not found with ID: " + categoryId);
        }
        return categoryConverter.entityToDto(category);
    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto) {
        Category existingCategory = categoryRepository.findByCategoryId(categoryId);
        if (existingCategory == null) {
            throw new RuntimeException("Category not found with ID: " + categoryId);
        }
        Category updatedCategory = categoryConverter.dtoToEntity(categoryDto);
        updatedCategory.setCategoryId(existingCategory.getCategoryId());
        categoryRepository.save(updatedCategory);
        return categoryConverter.entityToDto(updatedCategory);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findByCategoryId(categoryId);
        if (category == null) {
            throw new RuntimeException("Category not found with ID: " + categoryId);
        }
        categoryRepository.delete(category);
        return "Category with ID " + categoryId + " has been deleted successfully.";
    }
}
