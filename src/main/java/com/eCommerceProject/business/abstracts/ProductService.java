package com.eCommerceProject.business.abstracts;

import com.eCommerceProject.entities.concretes.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    void add(Product product);
    List<Product> getByproductName(String productName);
    List<Product> getByproductBrand(String productBrand);
    void deleteById(int id);
    List<Product> slice(Pageable pageable);
}
