package com.eCommerceProject.service.cart;

import com.eCommerceProject.exception.NotFoundException;
import com.eCommerceProject.model.Cart;
import com.eCommerceProject.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    
    private final CartRepository cartRepository;
    
    @Override
    public Cart getById(int id) {
        Optional<Cart> cart = cartRepository.findById(id);

        return cart.orElseThrow(() -> new NotFoundException("cart couldn't be found by following id: " + id));
    }

    @Override
    public void deleteById(int id) {
        cartRepository.deleteById(id);
    }

    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    @Override
    public void add(Cart cart) {
        cartRepository.save(cart);
    }
}
