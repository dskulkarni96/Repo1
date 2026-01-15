package com.MonkCommerce.Model;

import java.math.BigDecimal;

public class CartItem {
    private Long productId;
    private String productName;
    private Integer quantity;
    private Integer unitPrice;
	public CartItem(Long productId, String productName, Integer quantity, Integer unitPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
    
    
}
