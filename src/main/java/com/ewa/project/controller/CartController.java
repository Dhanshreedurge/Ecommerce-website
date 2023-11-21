package com.ewa.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ewa.project.model.CartDto;
import com.ewa.project.service.CartService;

@RestController 
@RequestMapping("/api/carts") 				
public class CartController {

	@Autowired
	private CartService cartService; // Automatically inject an object of CartService

	@PostMapping("/createCart")
	public ResponseEntity<CartDto> createCart(@RequestBody CartDto cartDto) {
	    CartDto createdCart = cartService.createCart(cartDto);
	    return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
	}

	@GetMapping("/getAllCarts")
	public List<CartDto> getAllCarts() {
		return cartService.getAllCarts();
	}

	@GetMapping("/{cartId}")
	public CartDto getCartById(@PathVariable Long cartId) {
		return cartService.getCartById(cartId);
	}

	@PutMapping("/{cartId}")
	public CartDto updateCart(@PathVariable Long cartId, @RequestBody CartDto cartDto) {
		return cartService.updateCart(cartId, cartDto);
	}

	@DeleteMapping("/{cartId}")
	public String deleteCart(@PathVariable Long cartId) {
		return cartService.deleteCart(cartId);
	}
}
