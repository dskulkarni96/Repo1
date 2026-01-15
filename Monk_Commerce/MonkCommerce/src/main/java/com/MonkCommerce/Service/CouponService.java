package com.MonkCommerce.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.MonkCommerce.Exception.ResourceNotFoundException;
import com.MonkCommerce.Model.CartItem;
import com.MonkCommerce.Model.Coupon;
import com.MonkCommerce.Repository.ICouponRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CouponService implements ICouponService {
	
	@Autowired
	//@Qualifier("com.MonkCommerce.Service.CouponRepository") 
     ICouponRepository icouponrepo;
	
	@Override
	public List<Coupon> getAllCoupons(){
		// TODO Auto-generated method stub
		List<Coupon> list =icouponrepo.findAll();
		if(list.isEmpty()) {
			throw new ResourceNotFoundException("No Coupons Are Present, Please Insert Coupons");
		}
		 return list;
		
	}

	@Override
	public Optional<Coupon> getCouponById(int couponId) {
	    return icouponrepo.findById(couponId); 
	}


	@Override
	public Coupon createNewCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		Coupon coup = icouponrepo.save(coupon);
		return coup;
	}

	@Override
	public Coupon updateCouponById(Coupon coupon, int couponId) {
		// TODO Auto-generated method stub
	
		Coupon coup = icouponrepo.save(coupon);
		return coup;
		
	}

	@Override
	public void deleteCouponById(int couponId) {
		// TODO Auto-generated method stub
		if (!icouponrepo.existsById(couponId)) {
            throw new ResourceNotFoundException("Coupon not found with id = " + couponId);
        }
		icouponrepo.deleteById(couponId);
	}

	@Override
	public Coupon getApplyCoupon(int couponId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coupon> getApplicableCoupons(List<CartItem> cartItem) {
		// TODO Auto-generated method stub
		int total = cartItem.stream()
		        .mapToInt(item -> item.getQuantity() * item.getUnitPrice())
		        .sum();		
		if (total > 100) {
			 List<Coupon> coupons =  icouponrepo.findByCouponType("CART_WISE");
			 return coupons;
	    }
		
		return null;
	}

	
}
