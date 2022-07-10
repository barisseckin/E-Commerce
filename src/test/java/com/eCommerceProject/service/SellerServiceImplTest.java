package com.eCommerceProject.service;

import com.eCommerceProject.model.Seller;
import com.eCommerceProject.model.SellerComment;
import com.eCommerceProject.repository.SellerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SellerServiceImplTest {

    @Mock
    private SellerRepository sellerRepository;

    @InjectMocks
    private SellerServiceImpl sellerService;

    @Test
    void add() {
    }

    @Test
    void deleteById() {
        int id = 1;
        sellerService.deleteById(id);
        verify(sellerRepository).deleteById(id);
    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
        int id = 1;
        sellerService.getById(id);
        verify(sellerRepository).findById(id);
    }
}