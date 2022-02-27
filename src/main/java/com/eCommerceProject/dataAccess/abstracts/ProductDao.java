package com.eCommerceProject.dataAccess.abstracts;

import com.eCommerceProject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    List<Product> getByproductName(String productName);
    List<Product> getByproductBrand(String productBrand);
    void deleteById(int id);
}
