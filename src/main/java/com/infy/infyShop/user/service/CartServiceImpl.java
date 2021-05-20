package com.infy.infyShop.user.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.infyShop.user.dto.CartDTO;
import com.infy.infyShop.user.entity.Cart;
import com.infy.infyShop.user.repository.CartRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;
	
	@Override
	public String addCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		cart.setBuyerId(cartDTO.getBuyerId());
		cart.setProdId(cartDTO.getProdId());
		cart.setQuantity(cartDTO.getQuantity());
		cartRepository.save(cart);
		return "Cart added succesfully";
	}

	@Override
	public String deleteCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		cart.setBuyerId(cartDTO.getBuyerId());
		cart.setProdId(cartDTO.getProdId());
		cartRepository.delete(cart);
		return "Cart deleted succesfully";
	}

	@Override
	public List<CartDTO> getAllCarts() {
		List<CartDTO> cartsDTO = new ArrayList<CartDTO>();
		List<Cart> carts = (List<Cart>) cartRepository.findAll();
		for(Cart cart:carts) {
			CartDTO cartDTO = new CartDTO();
			cartDTO.setBuyerId(cart.getBuyerId());
			cartDTO.setProdId(cart.getProdId());
			cartDTO.setQuantity(cart.getQuantity());
			cartsDTO.add(cartDTO);
		}
		return cartsDTO;
	}

	@Override
	public List<CartDTO> getAllCartByBuyerId(Integer buyerId) {
		List<CartDTO> cartsDTO = new ArrayList<CartDTO>();
		List<Cart> carts = (List<Cart>) cartRepository.findByBuyerId(buyerId);
		for(Cart cart:carts) {
			CartDTO cartDTO = new CartDTO();
			cartDTO.setBuyerId(cart.getBuyerId());
			cartDTO.setProdId(cart.getProdId());
			cartDTO.setQuantity(cart.getQuantity());
			cartsDTO.add(cartDTO);
		}
		return cartsDTO;
	}
}