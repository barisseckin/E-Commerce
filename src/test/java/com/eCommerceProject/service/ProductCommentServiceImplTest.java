package com.eCommerceProject.service;

import com.eCommerceProject.model.Product;
import com.eCommerceProject.model.ProductComment;
import com.eCommerceProject.repository.ProductCommentRepository;
import com.eCommerceProject.service.product.ProductCommentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductCommentServiceImplTest {

    @Mock
    private ProductCommentRepository productCommentRepository;

    @InjectMocks
    private ProductCommentServiceImpl productCommentService;

    @Test
    void add() {
    }

    @Test
    void deleteById() {
        int id = 1;
        productCommentService.deleteById(id);
        verify(productCommentRepository).deleteById(id);
    }

    @Test
    void getById() {
        int id = 1;
        productCommentService.getById(id);
        verify(productCommentRepository).findById(id);
    }

    @Test
    void getAll() {
        ProductComment productComment = mock(ProductComment.class);
        productComment.setId(1);
        productComment.setTitle("test-title");
        productComment.setBody("test-body");
        productComment.setRating(5);
        productComment.setCreateDate(new Date());
        productComment.setProduct(new Product());

        when(productCommentRepository.findAll()).thenReturn(Collections.singletonList(productComment));
        List<ProductComment> productCommentList = productCommentService.getAll();

        assertEquals(productCommentList.size(), 1);
    }

    @Test
    void getCommentsByProduct() {
    }
}