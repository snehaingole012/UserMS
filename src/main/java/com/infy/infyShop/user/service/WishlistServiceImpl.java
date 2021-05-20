package com.infy.infyShop.user.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.infyShop.user.dto.WishlistDTO;
import com.infy.infyShop.user.entity.Wishlist;
import com.infy.infyShop.user.repository.WishlistRepository;

@Service
@Transactional
public class WishlistServiceImpl implements WishlistService{

	@Autowired
	WishlistRepository wishlistRepository;
	
	@Override
	public String addWishlist(WishlistDTO wishlistDTO) {
		Wishlist wishlist = new Wishlist();
		wishlist.setBuyerId(wishlistDTO.getBuyerId());
		wishlist.setProdId(wishlistDTO.getProdId());
		wishlistRepository.save(wishlist);
		return "Wishlist added succesfully";
	}

	@Override
	public String deleteWishlist(WishlistDTO wishlistDTO) {
		Wishlist wishlist = new Wishlist();
		wishlist.setBuyerId(wishlistDTO.getBuyerId());
		wishlist.setProdId(wishlistDTO.getProdId());
		wishlistRepository.delete(wishlist);
		return "Wishlist deleted succesfully";
	}

	@Override
	public List<WishlistDTO> getAllWishlist() {
		List<WishlistDTO> wishlistsDTO = new ArrayList<WishlistDTO>();
		List<Wishlist> wishlists = (List<Wishlist>) wishlistRepository.findAll();
		for(Wishlist wishlist:wishlists) {
			WishlistDTO wishlistDTO = new WishlistDTO();
			wishlistDTO.setBuyerId(wishlist.getBuyerId());
			wishlistDTO.setProdId(wishlist.getProdId());
			wishlistsDTO.add(wishlistDTO);
		}
		return wishlistsDTO;
	}

	@Override
	public List<WishlistDTO> getAllWishlistByBuyerId(Integer buyerId) {
		List<WishlistDTO> wishlistsDTO = new ArrayList<WishlistDTO>();
		List<Wishlist> wishlists = (List<Wishlist>) wishlistRepository.findByBuyerId(buyerId);
		for(Wishlist wishlist:wishlists) {
			WishlistDTO wishlistDTO = new WishlistDTO();
			wishlistDTO.setBuyerId(wishlist.getBuyerId());
			wishlistDTO.setProdId(wishlist.getProdId());
			wishlistsDTO.add(wishlistDTO);
		}
		return wishlistsDTO;
	}
	
}