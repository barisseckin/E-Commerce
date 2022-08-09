package com.eCommerceProject.service.product;

import com.eCommerceProject.dto.createDto.ProductCreateDto;
import com.eCommerceProject.dto.viewDto.ProductViewDto;
import com.eCommerceProject.model.Cart;
import com.eCommerceProject.model.ConfirmedOrder;
import com.eCommerceProject.model.CreditCard;
import com.eCommerceProject.model.Product;
import com.eCommerceProject.request.ConfirmCartRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();
    Product getById(int id);
    ProductCreateDto add(ProductCreateDto productCreateDto);
    List<Product> getByproductName(String productName);
    List<Product> getByproductBrand(String productBrand);
    void deleteById(int id);
    void updateByProductDetails(int productId, String productDetails);
    List<Product> slice(Pageable pageable);
    List<ProductViewDto> getDto();
    Cart addToCart(int id);
    List<Cart> getCart();
    void removeFromCart(int id);
    ConfirmedOrder confirmCart(ConfirmCartRequest confirmCartRequest);
    List<ConfirmedOrder> getAllConfirmedOrder();
    ConfirmedOrder getConfirmedOrderById(int id);
    ConfirmedOrder getConfirmedOrderByOrderNumber(Long orderNumber);
    Map<Integer, Object> searchByProduct(String productName);
    void addFavorite(int productId);
    int getNumberOfFavorite(int productId);
    void removeFromFavorites(int productId);
}
