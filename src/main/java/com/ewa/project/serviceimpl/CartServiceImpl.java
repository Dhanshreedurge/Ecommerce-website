package com.ewa.project.serviceimpl;

import com.ewa.project.service.CartService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewa.project.converter.CartConverter;
import com.ewa.project.dao.CartRepository;
import com.ewa.project.entity.Cart;
import com.ewa.project.model.CartDto;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartConverter cartConverter;

	@Override
	public CartDto createCart(CartDto cartDto) {
		Cart cart = cartConverter.dtoToEntity(cartDto);
		cart = cartRepository.save(cart);
		return cartConverter.entityToDto(cart);
	}

	@Override
	public List<CartDto> getAllCarts() {
		List<Cart> carts = cartRepository.findAll();
		List<CartDto> cartDtos = new ArrayList<>();

		for (Cart cart : carts) {
			cartDtos.add(cartConverter.entityToDto(cart));
		}

		return cartDtos;
	}

	@Override
	public CartDto getCartById(Long cartId) {
	    Cart cart = cartRepository.findCartByCartId(cartId);
	    if (cart == null) {
	        throw new RuntimeException("Cart not found with ID: " + cartId);
	    }
	    return cartConverter.entityToDto(cart);    
	}

	@Override
	public CartDto updateCart(Long cartId, CartDto cartDto) {
		Cart existingCart = cartRepository.findCartByCartId(cartId);
		if (existingCart == null) {
			throw new RuntimeException("Cart not found with ID: " + cartId);
		}
		Cart updatedCart = cartConverter.dtoToEntity(cartDto);
		updatedCart.setCartId(existingCart.getCartId());
		cartRepository.save(updatedCart);
		return cartConverter.entityToDto(updatedCart);
	}

	@Override
	public String deleteCart(Long cartId) {
		Cart cart = cartRepository.findCartByCartId(cartId);
		if (cart == null) {
			throw new RuntimeException("Cart not found with ID: " + cartId);
		}
		cartRepository.delete(cart);
		return "Cart with ID " + cartId + " has been deleted successfully.";
	}
}
