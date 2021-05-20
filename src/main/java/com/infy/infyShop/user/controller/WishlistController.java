package com.infy.infyShop.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.infyShop.user.dto.ProductDTO;
import com.infy.infyShop.user.dto.WishlistDTO;
import com.infy.infyShop.user.service.WishlistService;

@RestController
@RequestMapping("wishlist")
public class WishlistController {
	
	@Autowired
	WishlistService wishlistService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<String> addWishlist(@RequestBody WishlistDTO wishlistDTO) {
		return new ResponseEntity<>(wishlistService.addWishlist(wishlistDTO),HttpStatus.OK);
	}
	
	@PostMapping(value = "/delete")
	public ResponseEntity<String> deleteWishlist(@RequestBody WishlistDTO wishlistDTO) {
		return new ResponseEntity<>(wishlistService.deleteWishlist(wishlistDTO),HttpStatus.OK);
	}
	
	@GetMapping(value="/view")
	public ResponseEntity<List<WishlistDTO>> getAllWishlist(){
		return new ResponseEntity<>(wishlistService.getAllWishlist(),HttpStatus.OK);
	}
	
	@GetMapping(value="/view/{buyerId}")
	public ResponseEntity<List<ProductDTO>> getAllWishListByBuyerId(@PathVariable Integer buyerId){
		List<WishlistDTO> wishlistsDTO = wishlistService.getAllWishlistByBuyerId(buyerId);
		List<ProductDTO> productsDTO = new ArrayList<>();
		for(WishlistDTO wishlistDTO : wishlistsDTO) {
			ProductDTO productDTO = new RestTemplate().getForObject("http://localhost:9200/api/productid/"+wishlistDTO.getProdId(), ProductDTO.class);
			productsDTO.add(productDTO);
		}
		return new ResponseEntity<>(productsDTO,HttpStatus.OK);
	}
}
