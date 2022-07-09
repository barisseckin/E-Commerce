package com.eCommerceProject.repository;

import com.eCommerceProject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> getByproductName(String productName);
    List<Product> getByproductBrand(String productBrand);
    void deleteById(int id);
}
