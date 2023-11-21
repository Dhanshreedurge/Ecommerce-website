package com.ewa.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewa.project.entity.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	Cart findCartByCartId(Long cartId);

}
