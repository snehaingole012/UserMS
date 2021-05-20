package com.infy.infyShop.user.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class ProductDTO {
	
	private Integer prodId;
	@Pattern(regexp="[A-Za-z][ A-Za-z]{0,98}[A-Za-z]",message="Invalid Product Name")
	private String productName;
	@Min(value=200,message="Invalid Price")
	private Float price;
	@Min(value=10,message="Invalid Stock")
	private Integer stock;
	@Pattern(regexp=".{0,500}")
	private String description;
	@Pattern(regexp=".*[.](png|jpg)")
	private String image;
	private Integer SellerId;
	private String category;
	private String subcategory;
	private Integer productRating;
	
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getSellerId() {
		return SellerId;
	}
	public void setSellerId(Integer sellerId) {
		SellerId = sellerId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public Integer getProductRating() {
		return productRating;
	}
	public void setProductRating(Integer productRating) {
		this.productRating = productRating;
	}
}
