package com.eCommerceProject.business.concretes;

import com.eCommerceProject.business.abstracts.CategoryService;
import com.eCommerceProject.dataAccess.abstracts.CategoryDao;
import com.eCommerceProject.model.Category;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class CategoryManagerTest {

    @Mock
    CategoryDao categoryDao;

    @InjectMocks
    CategoryService categoryService;

    void getAll() {
    }

    @Test
    void add() {
    }

    @Test
    void getByCategoryName() {

    }
}