package com.eCommerceProject.service;

import com.eCommerceProject.model.ProductComment;

import java.util.List;

public interface ProductCommentService {
    ProductComment add(ProductComment productComment);
    void deleteById(int id);
    List<ProductComment> getAll();
    List<ProductComment> getCommentsByProduct(int id);
}
