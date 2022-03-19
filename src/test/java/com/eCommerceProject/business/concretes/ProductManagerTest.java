package com.eCommerceProject.business.concretes;

import com.eCommerceProject.business.abstracts.ProductService;
import com.eCommerceProject.dto.createDto.ProductCreateDto;
import com.eCommerceProject.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductManagerTest {

    ProductService productService = mock(ProductService.class);

    @Test
    void getAll() {



    }

    @Test
    void add() {
        productService.add(new ProductCreateDto("testProduct", "testBrand",
                "testDetails", 100, 10, "testUrl"));

        verify(productService).add(new ProductCreateDto("testProduct", "testBrand",
                "testDetails", 100, 10, "testUrl"));
    }

    @Test
    void getByproductName() {
    }

    @Test
    void getByproductBrand() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void slice() {
    }

    @Test
    void getDto() {
    }
}