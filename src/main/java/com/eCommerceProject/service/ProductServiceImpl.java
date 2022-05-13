package com.eCommerceProject.service;

;
import com.eCommerceProject.dataAccess.abstracts.CartRepository;
import com.eCommerceProject.dataAccess.abstracts.ProductRepository;
import com.eCommerceProject.dto.createDto.ProductCreateDto;
import com.eCommerceProject.dto.viewDto.ProductViewDto;
import com.eCommerceProject.model.Cart;
import com.eCommerceProject.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CartRepository cartRepository;

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public ProductCreateDto add(ProductCreateDto productCreateDto) {
        this.productRepository.save(new Product(productCreateDto.getProductName(), productCreateDto.getProductBrand(),
                productCreateDto.getProductDetails(), productCreateDto.getProductPrice(), productCreateDto.getStock(), productCreateDto.getProductImageUrl()));
        return productCreateDto;
    }

    @Override
    public List<Product> getByproductName(String productName) {
        return this.productRepository.getByproductName(productName);
    }

    @Override
    public List<Product> getByproductBrand(String productBrand) {
       return this.productRepository.getByproductBrand(productBrand);
    }

    @Override
    public void deleteById(int id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public List<Product> slice(Pageable pageable) {
        final List<Product> products = this.productRepository.findAll(pageable).stream().collect(Collectors.toList());
        return products;
    }

    @Override
    public List<ProductViewDto> getDto() {
        final List<ProductViewDto> products = this.productRepository.findAll().stream().map(ProductViewDto :: of).collect(Collectors.toList());
        return products;
    }

    @Override
    public Cart addToCart(int id) {
        Product product = productRepository.getById(id);
        Cart cart = new Cart();
        cart.setId(product.getId());
        cart.setProductBrand(product.getProductBrand());
        cart.setProductName(product.getProductName());
        cart.setProductDetails(product.getProductDetails());
        cart.setProductPrice(product.getProductPrice());
        cart.setProductImageUrl(product.getProductImageUrl());

        cart.setQuantity(cart.getQuantity() + 1);
        product.setStock(product.getStock() - 1);

        if(product.getStock() == 0) {
            productRepository.deleteById(product.getId());
        }
        cartRepository.save(cart);

        return cart;
    }

    @Override
    public List<Cart> getCart() {
        return cartRepository.findAll();
    }

    @Override
    public void removeFromCart(int id) {
        Cart cart = cartRepository.getById(id);
        cartRepository.deleteById(cart.getId());
    }

}
