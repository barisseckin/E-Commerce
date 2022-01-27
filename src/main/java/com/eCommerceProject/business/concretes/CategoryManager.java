package com.eCommerceProject.business.concretes;

import com.eCommerceProject.business.abstracts.CategoryService;
import com.eCommerceProject.dataAccess.abstracts.CategoryDao;
import com.eCommerceProject.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryManager(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

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
