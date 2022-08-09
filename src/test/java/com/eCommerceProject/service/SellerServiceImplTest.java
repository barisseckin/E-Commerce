package com.eCommerceProject.service;

import com.eCommerceProject.repository.SellerRepository;
import com.eCommerceProject.service.seller.SellerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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