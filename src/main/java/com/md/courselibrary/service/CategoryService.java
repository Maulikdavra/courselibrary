package com.md.courselibrary.service;

import com.md.courselibrary.entity.Category;
import com.md.courselibrary.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("Category not found with id: " + id));
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("Category not found with id: " + id));
        categoryRepository.deleteById(category.getId());
    }

    public Category updateCategory(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("Category not found with id: " + id));
        existingCategory.setName(category.getName());
        return categoryRepository.save(existingCategory);
    }

    public Category findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }
}
