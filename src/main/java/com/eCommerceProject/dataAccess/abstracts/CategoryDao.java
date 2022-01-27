package com.eCommerceProject.dataAccess.abstracts;

import com.eCommerceProject.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
    List<Category> getByCategoryName(String categoryName);
}
