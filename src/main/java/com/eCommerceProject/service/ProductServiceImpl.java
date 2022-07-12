package com.eCommerceProject.service;

;
import com.eCommerceProject.model.*;
import com.eCommerceProject.repository.*;
import com.eCommerceProject.dto.createDto.ProductCreateDto;
import com.eCommerceProject.dto.viewDto.ProductViewDto;
import com.eCommerceProject.request.ConfirmCartRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CartRepository cartRepository;

    private final CreditCardRepository creditCardRepository;

    private final ConfirmedOrderRepository confirmedOrderRepository;

    private final PromoCodeRepository promoCodeRepository;

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
        cart.setSeller(product.getSeller());
        cart.setQuantity(0);

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

    @Override
    public ConfirmedOrder confirmCart(ConfirmCartRequest confirmCartRequest) {
        Optional<Cart> cart = cartRepository.findById(confirmCartRequest.getId());

        if (cart.isPresent()) {

            if (confirmCartRequest.getPromoCode().isPresent()) {
                PromoCode code = promoCodeRepository.findPromoCodeByCode(confirmCartRequest.getPromoCode().get());
                if (!code.getCode().isEmpty()) {

                    creditCardRepository.save(new CreditCard(confirmCartRequest.getCardNumber(), confirmCartRequest.getCvv(),
                            confirmCartRequest.getNameAndSurname(), confirmCartRequest.getExpirationDate()));

                    ConfirmedOrder confirmedOrder = new ConfirmedOrder();
                    confirmedOrder.setProductBrand(cart.get().getProductBrand());
                    confirmedOrder.setProductDetails(cart.get().getProductDetails());
                    confirmedOrder.setProductName(cart.get().getProductName());
                    confirmedOrder.setProductPrice(cart.get().getProductPrice() - code.getAmount());
                    confirmedOrder.setProductImageUrl(cart.get().getProductImageUrl());
                    confirmedOrder.setSeller(cart.get().getSeller());

                    confirmedOrderRepository.save(confirmedOrder);

                    cartRepository.deleteById(cart.get().getId());

                    return confirmedOrder;
                    }
                }
            }
        return null;
    }

    @Override
    public List<ConfirmedOrder> getAllConfirmedOrder() {
        List<ConfirmedOrder> confirmedOrders = confirmedOrderRepository.findAll();
        return confirmedOrders;
    }

    @Override
    public ConfirmedOrder getConfirmedOrderById(int id) {
        Optional<ConfirmedOrder> confirmedOrder = confirmedOrderRepository.findById(id);
        return confirmedOrder.orElse(null);
    }

    @Override
    public ConfirmedOrder getConfirmedOrderByOrderNumber(Long orderNumber) {
        ConfirmedOrder confirmedOrder = confirmedOrderRepository.findConfirmedOrderByOrderNumber(orderNumber);
        return confirmedOrder;
    }


    @Override
    public Map<Integer, Object> searchByProduct(String productName) {
        Map<Integer, Object> searchResult = new HashMap<>();
        List<Product> products = new ArrayList<>();

        for (Product product : productRepository.findAll()) {
            if (product.getProductName().contains(productName)) {
                products.add(product);
                searchResult.put(products.size(), products);
                return searchResult;
            }
        }
        return null;
    }
}
