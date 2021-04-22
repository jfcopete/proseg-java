package org.uniandes.proseg.group6.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uniandes.proseg.group6.dto.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer>{
	Coupon findByCouponCypher(String couponCypher);
}
