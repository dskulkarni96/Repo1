package com.MonkCommerce.Model;

import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="coupon")
public class Coupon {
	
	@Id
	@Column(name="coupon_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int couponId;
	
	@Column(name="coupon_type")
	private String couponType; //CART_WISE, PRODUCT_WISE, BXGY
	
	@Column(name="discount_percentage")
	private int discountPercentage;

	
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public String getCouponType() {
		return couponType;
	}
	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}
	public int getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponType=" + couponType + ", discountPercentage="
				+ discountPercentage + ", getCouponId()=" + getCouponId() + ", getCouponType()=" + getCouponType()
				+ ", getDiscountPercentage()=" + getDiscountPercentage() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(couponId, couponType, discountPercentage);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coupon other = (Coupon) obj;
		return couponId == other.couponId && Objects.equals(couponType, other.couponType)
				&& discountPercentage == other.discountPercentage;
	}

	
}
