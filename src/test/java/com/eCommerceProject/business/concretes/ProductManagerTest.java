package com.eCommerceProject.business.concretes;

import com.eCommerceProject.dataAccess.abstracts.ProductDao;
import com.eCommerceProject.dto.createDto.ProductCreateDto;
import com.eCommerceProject.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ProductManager productManager;

    @Test
    void testGetAll() {
    }

    @Test
    @DisplayName("product add test method")
    @Tag("addProduct")
    void testAdd() {
        ProductCreateDto productCreateDto = new ProductCreateDto();
        productCreateDto.setProductBrand("Test-Brand");
        productCreateDto.setProductName("Test-Name");
        productCreateDto.setProductDetails("Test-Details");
        productCreateDto.setProductPrice(1000);
        productCreateDto.setProductImageUrl("Test-Url");
        productCreateDto.setStock(10);

        Product product = mock(Product.class);

        when(productDao.save(any(Product.class))).thenReturn(product);
        ProductCreateDto result = productManager.add(productCreateDto);

        assertEquals(result.getProductBrand(), "Test-Brand");
        assertEquals(result.getProductBrand(), productCreateDto.getProductBrand());

    }

    @Test
    void testGetByproductName() {
    }

    @Test
    void testGetByproductBrand() {
    }

    @Test
    void testDeleteById() {
    }

    @Test
    void testSlice() {
    }

    @Test
    void testGetDto() {
    }
}