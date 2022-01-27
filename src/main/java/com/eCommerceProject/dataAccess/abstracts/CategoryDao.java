package com.eCommerceProject.dataAccess.abstracts;

import com.eCommerceProject.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, Integer> {
    List<Category> getByCategoryName(String categoryName);
}
