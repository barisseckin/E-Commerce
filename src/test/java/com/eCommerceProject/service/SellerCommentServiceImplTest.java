package com.eCommerceProject.service;

import com.eCommerceProject.repository.SellerCommentRepository;
import com.eCommerceProject.service.seller.SellerCommentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SellerCommentServiceImplTest {

    @Mock
    private SellerCommentRepository sellerCommentRepository;

    @InjectMocks
    private SellerCommentServiceImpl sellerCommentService;

    @Test
    void add() {
    }

    @Test
    void deleteById() {
        int id = 1;
        sellerCommentService.deleteById(id);
        verify(sellerCommentRepository).deleteById(id);
    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
        int id = 1;
        sellerCommentService.getById(id);
        verify(sellerCommentRepository).findById(id);
    }

    @Test
    void getSellerCommentsBySeller() {
    }
}