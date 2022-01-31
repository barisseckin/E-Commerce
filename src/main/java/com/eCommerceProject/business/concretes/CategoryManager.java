package com.eCommerceProject.business.concretes;

import com.eCommerceProject.business.abstracts.CategoryService;
import com.eCommerceProject.dataAccess.abstracts.CategoryDao;
import com.eCommerceProject.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryManager implements CategoryService {

    private final CategoryDao categoryDao;

    @Override
    public List<Category> getAll() {
        return this.categoryDao.findAll();
    }

    @Override
    public void add(Category category) {
        this.categoryDao.save(category);
    }

    @Override
    public List<Category> getByCategoryName(String categoryName) {
        return this.categoryDao.getByCategoryName(categoryName);
    }

}
