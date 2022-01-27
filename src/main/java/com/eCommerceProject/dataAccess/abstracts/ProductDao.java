package com.eCommerceProject.dataAccess.abstracts;

import com.eCommerceProject.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.crypto.Data;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    List<Product> getByproductName(String productName);
    List<Product> getByproductBrand(String productBrand);
    void deleteById(int id);
}
