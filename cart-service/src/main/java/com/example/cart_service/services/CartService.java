package com.example.cart_service.services;

import com.example.cart_service.entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cart_service.repositories.CartRepository;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart UpdateCart(Long id,Cart cart) {
        Cart existingCart = cartRepository.findById(id).orElse(null);
        if (existingCart != null) {
            existingCart.setTotalPrice(cart.getTotalPrice());
            existingCart.setStatus(cart.getStatus());
            existingCart.setCreatedAt(cart.getCreatedAt());
            existingCart.setUpdatedAt(cart.getUpdatedAt());
            existingCart.setItems(cart.getItems());
            return cartRepository.save(existingCart);
        }
        return null;
    }
    public Cart deleteCart(Long id) {
        Cart cart = cartRepository.findById(id).orElse(null);
        if (cart != null) {
            cartRepository.delete(cart);
        }
        return cart;
    }
}
