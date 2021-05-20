package com.infy.infyShop.user.service;

import java.util.List;

import com.infy.infyShop.user.dto.CartDTO;

public interface CartService {

	String addCart(CartDTO cartDTO);

	String deleteCart(CartDTO cartDTO);

	List<CartDTO> getAllCarts();

	List<CartDTO> getAllCartByBuyerId(Integer buyerId);
	
}
