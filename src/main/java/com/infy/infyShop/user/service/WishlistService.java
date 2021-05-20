package com.infy.infyShop.user.service;

import java.util.List;

import com.infy.infyShop.user.dto.WishlistDTO;

public interface WishlistService {
	public String addWishlist(WishlistDTO wishlistDTO);
	public String deleteWishlist(WishlistDTO wishlistDTO);
	public List<WishlistDTO> getAllWishlist();
	public List<WishlistDTO> getAllWishlistByBuyerId(Integer buyerId);
}