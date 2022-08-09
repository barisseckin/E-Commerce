package com.eCommerceProject.service;

import com.eCommerceProject.repository.ProductRepository;
import com.eCommerceProject.dto.createDto.ProductCreateDto;
import com.eCommerceProject.dto.viewDto.ProductViewDto;
import com.eCommerceProject.model.Product;
import com.eCommerceProject.service.product.ProductServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author barisseckin
 * @since 05.05.2022
 */

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @BeforeEach
    void setUp () {

    }

    @Test
    void testGetAll() {
        Product product = mock(Product.class);
        product.setId(1);
        product.setProductName("Test-Name");
        product.setProductBrand("Test-Brand");
        product.setProductDetails("Test-Details");
        product.setProductImageUrl("Test-Url");
        product.setStock(10);
        product.setProductPrice(1000);

        when(productRepository.findAll()).thenReturn(Collections.singletonList(product));
        List<Product> productList = productServiceImpl.getAll();

        assertEquals(productList.size(), 1);

    }

    @Test
    @DisplayName("product add test method")
    @Tag("addProduct")
    void testAdd() {
        ProductCreateDto productCreateDto = mock(ProductCreateDto.class);
        productCreateDto.setProductBrand("Test-Brand");
        productCreateDto.setProductName("Test-Name");
        productCreateDto.setProductDetails("Test-Details");
        productCreateDto.setProductPrice(1000);
        productCreateDto.setProductImageUrl("Test-Url");
        productCreateDto.setStock(10);
        Product product = mock(Product.class);

        when(productRepository.save(any(Product.class))).thenReturn(product);
        ProductCreateDto result = productServiceImpl.add(productCreateDto);

        assertEquals(result.getProductBrand(), productCreateDto.getProductBrand());

    }

    @Test
    @DisplayName("get product name test")
    @Tag("getByProductName")
    void testGetByproductName() {
        String productName = "Test-Name";
        productServiceImpl.getByproductName(productName);
        verify(productRepository).getByproductName(productName);

    }

    @Test
    @DisplayName("get product brand test")
    @Tag("getByProductBrand")
    void testGetByproductBrand() {
        String productBrand = "Test-Brand";
        productServiceImpl.getByproductBrand(productBrand);
        verify(productRepository).getByproductBrand(productBrand);

    }

    @Test
    @DisplayName("product delete by id")
    @Tag("deleteById")
    void testDeleteById() {
        int id = 1;
        productServiceImpl.deleteById(id);
        verify(productRepository).deleteById(id);
    }

    @Test
    void testSlice() {

    }

    @Test
    @DisplayName("product get dto test")
    void testGetDto() {
        Product product = mock(Product.class);
        product.setId(1);
        product.setProductName("Test-Name");
        product.setProductBrand("Test-Brand");
        product.setProductDetails("Test-Details");
        product.setProductImageUrl("Test-Url");
        product.setStock(10);
        product.setProductPrice(1000);

        when(productRepository.findAll()).thenReturn(Collections.singletonList(product));
        List<ProductViewDto> productViewDto = productServiceImpl.getDto();

        assertEquals(productViewDto.size(), 1);


    }
}