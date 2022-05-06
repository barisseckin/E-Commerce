package com.eCommerceProject.dataAccess.abstracts;

import com.eCommerceProject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> getByCategoryName(String categoryName);
}
