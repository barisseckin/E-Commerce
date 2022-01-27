package com.eCommerceProject.api.controller;

import com.eCommerceProject.business.abstracts.CategoryService;
import com.eCommerceProject.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/categorys/")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("getAll")
    public List<Category> getAll() {
        return this.categoryService.getAll();
    }

    @PostMapping("add")
    public void add(Category category) {
        this.categoryService.add(category);
    }

    @GetMapping("getByCategoryName")
    public List<Category> getByCategoryName(String categoryName) {
        return this.categoryService.getByCategoryName(categoryName);
    }

}
