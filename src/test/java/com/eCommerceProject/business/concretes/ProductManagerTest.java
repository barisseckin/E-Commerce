package com.eCommerceProject.business.concretes;

import com.eCommerceProject.entities.concretes.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private final Product product1 = new Product(1 ,"Airpods", "Apple", "2. Nesil Airpods", 1500, 20);
    private final Product product2 = new Product(2 ,"Table", "IKEA", "Blue Color Launch Table", 400.99, 5);


    @Test
    void getAll() {
        assertEquals(new Product(2 ,"Table", "IKEA",
                "Blue Color Launch Table", 400.99, 5), product2);
    }

    @Test
    @DisplayName("Product Add Testing Code")
    void add() {
        assertEquals(new Product(1 ,"Airpods", "Apple",
                "2. Nesil Airpods", 1500, 20), product1);
    }

    @Test
    void getByproductName() {
        assertEquals("Table", product2.getProductName());
    }

    @Test
    void getByproductBrand() {
        assertEquals("Apple", product1.getProductBrand());
    }

    @Test
    void deleteById() {
    }
}