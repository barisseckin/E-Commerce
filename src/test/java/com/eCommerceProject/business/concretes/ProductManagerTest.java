package com.eCommerceProject.business.concretes;

import com.eCommerceProject.dataAccess.abstracts.ProductDao;
import com.eCommerceProject.dto.createDto.ProductCreateDto;
import com.eCommerceProject.dto.viewDto.ProductViewDto;
import com.eCommerceProject.model.Product;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author barisseckin
 * @since 05.05.2022
 */

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ProductManager productManager;

    @BeforeEach
    void setUp () {

    }

    @Test
    void testGetAll() {
        Product product = new Product();
        product.setId(1);
        product.setProductName("Test-Name");
        product.setProductBrand("Test-Brand");
        product.setProductDetails("Test-Details");
        product.setProductImageUrl("Test-Url");
        product.setStock(10);
        product.setProductPrice(1000);

        when(productDao.findAll()).thenReturn(Collections.singletonList(product));
        List<Product> productList = productManager.getAll();

        assertEquals(productList.size(), 1);

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
    @DisplayName("get product name test")
    @Tag("getByProductName")
    void testGetByproductName() {
        String productName = "Test-Name";
        productManager.getByproductName(productName);
        verify(productDao).getByproductName(productName);

    }

    @Test
    @DisplayName("get product brand test")
    @Tag("getByProductBrand")
    void testGetByproductBrand() {
        String productBrand = "Test-Brand";
        productManager.getByproductBrand(productBrand);
        verify(productDao).getByproductBrand(productBrand);

    }

    @Test
    @DisplayName("product delete by id")
    @Tag("deleteById")
    void testDeleteById() {
        int id = 1;
        productManager.deleteById(id);
        verify(productDao).deleteById(id);
    }

    @Test
    void testSlice() {

    }

    @Test
    @DisplayName("product get dto test")
    void testGetDto() {
        Product product = new Product();
        product.setId(1);
        product.setProductName("Test-Name");
        product.setProductBrand("Test-Brand");
        product.setProductDetails("Test-Details");
        product.setProductImageUrl("Test-Url");
        product.setStock(10);
        product.setProductPrice(1000);

        when(productDao.findAll()).thenReturn(Collections.singletonList(product));
        List<ProductViewDto> productViewDtos = productManager.getDto();

        assertEquals(productViewDtos.size(), 1);


    }
}