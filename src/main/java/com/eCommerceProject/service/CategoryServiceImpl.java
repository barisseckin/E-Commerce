package com.eCommerceProject.service;

import com.eCommerceProject.dataAccess.abstracts.CategoryRepository;
import com.eCommerceProject.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category add(Category category) {
        if(categoryRepository.findByCategoryName(category.getCategoryName()) != null) {
            return null;
        }

        this.categoryRepository.save(category);
        return category;
    }

    @Override
    public List<Category> getByCategoryName(String categoryName) {
        return this.categoryRepository.getByCategoryName(categoryName);
    }

}
