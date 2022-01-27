package com.eCommerceProject.business.abstracts;

import com.eCommerceProject.core.concretes.DataResult;
import com.eCommerceProject.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    void add(Product product);
    List<Product> getByproductName(String productName);
    List<Product> getByproductBrand(String productBrand);
    void deleteById(int id);
}
