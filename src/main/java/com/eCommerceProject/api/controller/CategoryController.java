package com.eCommerceProject.api.controller;

import com.eCommerceProject.business.abstracts.CategoryService;
import com.eCommerceProject.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categorys/")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("getAll")
    public List<Category> getAll() {
        return this.categoryService.getAll();
    }

    @PostMapping("add")
    public void add(@RequestBody Category category) {
        this.categoryService.add(category);
    }

    @GetMapping("getByCategoryName")
    public List<Category> getByCategoryName(String categoryName) {
        return this.categoryService.getByCategoryName(categoryName);
    }

}
