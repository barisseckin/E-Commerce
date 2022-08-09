package com.eCommerceProject.service.seller;

import com.eCommerceProject.model.Seller;

import java.util.List;

public interface SellerService {
    Seller add(Seller seller);
    void deleteById(int id);
    List<Seller> getAll();
    Seller getById(int id);
}
