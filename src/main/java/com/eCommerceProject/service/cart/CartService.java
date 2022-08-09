package com.eCommerceProject.service.cart;

import com.eCommerceProject.model.Cart;

import java.util.List;

public interface CartService {
    Cart getById(int id);
    void deleteById(int id);
    List<Cart> getAll();
    void add(Cart cart);
}
