package com.md.courselibrary.controller;

import com.md.courselibrary.entity.Category;
import com.md.courselibrary.repository.CategoryRepository;
import com.md.courselibrary.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/add")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category()); // Provide an empty Category object for the form
        return "add-category";
    }

    // Handle saving a new category
    @PostMapping("/add")
    public void addAuthor(@ModelAttribute Category category) {
        Category existingCategory = categoryService.findCategoryByName(category.getName());
        if (existingCategory == null) {
            // Save the new author
            categoryService.saveCategory(category);
        } else {
            // Optionally log or notify about duplicate authors
            System.out.println("Category already exists: " + category.getId());
        }
    }

    @GetMapping("/all")
    public String findAllCategories(Model model) {
        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("view/{id}")
    public String findCategoryById(@PathVariable Long id, Model model){
        Category category = categoryService.findCategoryById(id);
        model.addAttribute("category", category);
        return "list-category";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id){
        Long categoryId = categoryService.findCategoryById(id).getId();
        categoryService.deleteCategory(categoryId);
        return "redirect:/category/all";
    }

    @GetMapping("/edit/{id}")
    public String updateCategory(@PathVariable Long id, Model model) {
        Category category = categoryService.findCategoryById(id);
        model.addAttribute("category", category);
        return "update-category";
    }

    @PostMapping("/update")
    public String saveUpdatedCategory(@ModelAttribute Category category) {
        Category existingCategory = categoryService.findCategoryById(category.getId());
        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            existingCategory.setDescription(category.getDescription());
            categoryService.saveCategory(existingCategory);
        }
        return "redirect:/category/all";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute Category category, Model model) {
        Category existingCategory = categoryService.findCategoryByName(category.getName());
        if (existingCategory != null) {
            model.addAttribute("error", "Category with name " + category.getName() + " already exists.");
            model.addAttribute("category", category);
            return "authors"; // Return to the form with an error message
        }
        categoryService.saveCategory(category);
        return "redirect:/publishers/add";
    }
}
