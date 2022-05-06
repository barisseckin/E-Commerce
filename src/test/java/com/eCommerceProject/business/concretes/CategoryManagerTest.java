package com.eCommerceProject.business.concretes;

import com.eCommerceProject.dataAccess.abstracts.CategoryDao;
import com.eCommerceProject.model.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author barisseckin
 * @since 05.05.2022
 */

@ExtendWith(MockitoExtension.class)
class CategoryManagerTest {

    @Mock
    CategoryDao categoryDao;

    @InjectMocks
    CategoryManager categoryManager;

    @Test
    void getAll() {
        Category category = mock(Category.class);
        category.setId(1);
        category.setCategoryName("Test-Name");

        when(categoryDao.findAll()).thenReturn(Collections.singletonList(category));
        List<Category> categoryList = categoryManager.getAll();

        assertEquals(categoryList.size(), 1);
    }

    @Test
    @DisplayName("category add test")
    @Tag("addCategory")
    void add() {
        Category category = new Category();
        category.setId(1);
        category.setCategoryName("Home");

        Category result = categoryManager.add(category);
        verify(categoryDao).save(category);
        assertEquals(result.getCategoryName(), "Home");
    }

    @Test
    @DisplayName("category name get test")
    @Tag("getByCategoryName")
    void getByCategoryName() {
        String categoryName = "Home";
        categoryManager.getByCategoryName(categoryName);
        verify(categoryDao).getByCategoryName(categoryName);
    }
}