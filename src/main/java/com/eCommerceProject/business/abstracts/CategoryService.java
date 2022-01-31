package com.eCommerceProject.business.abstracts;

import com.eCommerceProject.model.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);
    List<Category> getAll();
    List<Category> getByCategoryName(String categoryName);
}
