package com.eCommerceProject.service;

import com.eCommerceProject.dto.createDto.ProductCreateDto;
import com.eCommerceProject.dto.viewDto.ProductViewDto;
import com.eCommerceProject.model.Cart;
import com.eCommerceProject.model.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getAll();
    ProductCreateDto add(ProductCreateDto productCreateDto);
    List<Product> getByproductName(String productName);
    List<Product> getByproductBrand(String productBrand);
    void deleteById(int id);
    List<Product> slice(Pageable pageable);
    List<ProductViewDto> getDto();
    Cart addToCart(int id);
    List<Cart> getCart();
    void removeFromCart(int id);
    Map<Integer, Object> searchByProduct(String productName);
}
