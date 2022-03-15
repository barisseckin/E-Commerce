package com.eCommerceProject.business.concretes;

import com.eCommerceProject.business.abstracts.CategoryService;
import com.eCommerceProject.model.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryManagerTest {

    @Test
    void getAll() {
        CategoryService categoryService = mock(CategoryService.class);
        List<Category> categories = categoryService.getAll();

    }

    @Test
    void add() {

        CategoryService categoryService = mock(CategoryService.class);
        categoryService.add(new Category("Home"));
        categoryService.add(new Category("Computer"));

        verify(categoryService).add(new Category("Home" ));
        verify(categoryService).add(new Category("Computer" ));

    }

    @Test
    void getByCategoryName() {
    }
}