package com.MonkCommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MonkCommerce.Model.Coupon;

public interface ICouponRepository extends JpaRepository<Coupon, Integer>{

	 List<Coupon> findByCouponType(String couponType);
}
