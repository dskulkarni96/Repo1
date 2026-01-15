package com.MonkCommerce.Service;

import java.util.List;
import java.util.Optional;

import com.MonkCommerce.Model.CartItem;
import com.MonkCommerce.Model.Coupon;

public interface ICouponService {
	
	public List<Coupon> getAllCoupons() ;
	public Optional<Coupon> getCouponById(int couponId);
	public Coupon createNewCoupon(Coupon coupon);
	public Coupon updateCouponById(Coupon coupon, int couponId);
	public void deleteCouponById(int couponId) ;
	public Coupon getApplyCoupon(int couponId);
	public List<Coupon> getApplicableCoupons(List<CartItem> cartItem);

}
