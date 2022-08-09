package com.eCommerceProject.service.seller;

import com.eCommerceProject.model.SellerComment;

import java.util.List;

public interface SellerCommentService {
    SellerComment add(SellerComment sellerComment);
    void deleteById(int id);
    List<SellerComment> getAll();
    SellerComment getById(int id);
    List<SellerComment> getSellerCommentsBySeller(int id);
}
