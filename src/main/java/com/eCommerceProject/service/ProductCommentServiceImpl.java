package com.eCommerceProject.service;

import com.eCommerceProject.model.Product;
import com.eCommerceProject.model.ProductComment;
import com.eCommerceProject.repository.ProductCommentRepository;
import com.eCommerceProject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCommentServiceImpl implements ProductCommentService{

    private final ProductCommentRepository productCommentRepository;

    private final ProductRepository productRepository;

    @Override
    public ProductComment add(ProductComment productComment) {

        if(productComment.getRating() < 1) {
            return null;
        } else  {
            return productCommentRepository.save(productComment);
        }
    }

    @Override
    public void deleteById(int id) {
        productCommentRepository.deleteById(id);
    }

    @Override
    public ProductComment getById(int id) {
        Optional<ProductComment> productComment = productCommentRepository.findById(id);
        return productComment.orElse(null);
    }

    @Override
    public List<ProductComment> getAll() {
        return productCommentRepository.findAll();
    }

    @Override
    public List<ProductComment> getCommentsByProduct(int id) {
        Product product = productRepository.getById(id);
        List<ProductComment> responseComment = new ArrayList<>();

        for (ProductComment productComment : product.getProductComment()) {
            responseComment.add(productComment);
            return responseComment;
        }
        return null;
    }
}
