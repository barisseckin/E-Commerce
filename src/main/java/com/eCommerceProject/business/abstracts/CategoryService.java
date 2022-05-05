package com.eCommerceProject.business.abstracts;

import com.eCommerceProject.model.Category;

import java.util.List;

public interface CategoryService {
    Category add(Category category);
    List<Category> getAll();
    List<Category> getByCategoryName(String categoryName);
}
