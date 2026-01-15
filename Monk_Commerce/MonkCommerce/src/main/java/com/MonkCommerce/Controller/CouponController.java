package com.MonkCommerce.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MonkCommerce.Model.CartItem;
import com.MonkCommerce.Model.Coupon;
import com.MonkCommerce.Service.ICouponService;

@RestController
public class CouponController {
	
	@Autowired
	//@Qualifier("com.MonkCommerce.Service.CouponService") 
	private final ICouponService icouponservice;
	public CouponController(ICouponService icouponservice) { 
        this.icouponservice = icouponservice;
    }
	
	
//	//Retrive All Coupons
//	@GetMapping("/coupons")
//	public List<Coupon> getAllCoupons(){
//		return icouponservice.getAllCoupons();
//	}
	//Retrive All Coupons
		@GetMapping("/coupons")
		public ResponseEntity<List<Coupon>> getAllCoupons(){
			List<Coupon> list = icouponservice.getAllCoupons();
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		
	//Retrive Specific Coupon by Id
		@GetMapping("/coupons/{id}")
		public ResponseEntity<Coupon> getCouponById(@PathVariable("id") int couponId) {
		    return icouponservice.getCouponById(couponId)
		        .map(ResponseEntity::ok)
		        .orElse(ResponseEntity.notFound().build());
		}

	//Add coupons
	@PostMapping("/coupons")
	public Coupon createNewCoupon(@RequestBody Coupon coupon) {
		return icouponservice.createNewCoupon(coupon);
	}
	
	@PostMapping("/applicablecoupons")
	public List<Coupon> fetchApplicableCoupons(@RequestBody List<CartItem> cartItem) {
		return icouponservice.getApplicableCoupons(cartItem);
		
	}
	
	@PostMapping("/applycoupon/{id}")
	public Coupon applyCoupon(@PathVariable("id") int couponId) {
		return icouponservice.getApplyCoupon(couponId);
		
	}
	
	
	@DeleteMapping("/coupons/{id}")
	public String deleteCouponById(@PathVariable("id") int couponId) {
		icouponservice.deleteCouponById(couponId);
		return "Deleted Successfully";
		
	}
	
	//Update specific coupon by id
	@PutMapping("/coupons/{id}")
	public Coupon updateCouponById(@RequestBody Coupon coupon, @PathVariable("id") int couponId) {
		return icouponservice.updateCouponById(coupon,couponId);
	}
	

}
