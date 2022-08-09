package com.eCommerceProject.api;

import com.eCommerceProject.service.product.ProductService;
import com.eCommerceProject.dto.createDto.ProductCreateDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest {

    private final static String CONTENT_TYPE = "application/json";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ProductService productService;

    @Test
    void add() throws Exception {
        ProductCreateDto productCreateDto = new ProductCreateDto();
        productCreateDto.setProductName("Test-Name");
        productCreateDto.setProductBrand("Test-Brand");
        productCreateDto.setProductDetails("Test-Details");
        productCreateDto.setStock(10);
        productCreateDto.setProductImageUrl("Test-Url");
        productCreateDto.setProductPrice(1000);

        ResultActions resultActions = mockMvc.perform(post("/api/products/add")
                .contentType(CONTENT_TYPE)
                .content(objectMapper.writeValueAsBytes(productCreateDto)));

        ArgumentCaptor<ProductCreateDto> captor = ArgumentCaptor.forClass(ProductCreateDto.class);
        verify(productService, times(1)).add(captor.capture());
        assertThat(captor.getValue().getProductBrand()).isEqualTo("Test-Brand");
        resultActions.andExpect(status().isOk());
    }

    @Test
    void getAll() {
    }

    @Test
    void getByproductName() {
    }

    @Test
    void getByproductBrand() {
    }

    @Test
    void slice() {
    }

    @Test
    void deleteByid() {
    }

    @Test
    void getDto() {
    }

    @Test
    void addToCart() {
    }

    @Test
    void getCart() {
    }

    @Test
    void removeFromCart() {
    }
}