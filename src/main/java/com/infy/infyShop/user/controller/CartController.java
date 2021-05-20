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

import com.infy.infyShop.user.dto.CartDTO;
import com.infy.infyShop.user.dto.ProductDTO;
import com.infy.infyShop.user.service.CartService;

@RestController
@RequestMapping(value="cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<String> addCart(@RequestBody CartDTO cartDTO) {
		return new ResponseEntity<>(cartService.addCart(cartDTO),HttpStatus.OK);
	}
	
	@PostMapping(value = "/delete")
	public ResponseEntity<String> deleteCart(@RequestBody CartDTO cartDTO) {
		return new ResponseEntity<>(cartService.deleteCart(cartDTO),HttpStatus.OK);
	}
	
	@GetMapping(value = "/view")
	public ResponseEntity<List<CartDTO>> getAllCarts() {
		return new ResponseEntity<>(cartService.getAllCarts(),HttpStatus.OK);
	}
	
	@GetMapping(value="/view/{buyerId}")
	public ResponseEntity<List<ProductDTO>> getAllWishListByBuyerId(@PathVariable Integer buyerId){
		List<CartDTO> cartsDTO = cartService.getAllCartByBuyerId(buyerId);
		List<ProductDTO> productsDTO = new ArrayList<>();
		for(CartDTO cartDTO : cartsDTO) {
			ProductDTO productDTO = new RestTemplate().getForObject("http://localhost:9200/api/productid/"+cartDTO.getProdId(), ProductDTO.class);
			productsDTO.add(productDTO);
		}
		return new ResponseEntity<>(productsDTO,HttpStatus.OK);
	}
}
