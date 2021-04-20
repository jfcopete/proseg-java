package org.uniandes.proseg.group6.service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.uniandes.proseg.group6.cypher.Cypher;
import org.uniandes.proseg.group6.dto.Coupon;
import org.uniandes.proseg.group6.repositories.CouponRepository;

@RestController
public class CouponService {
	@Autowired
	private CouponRepository couponRepository;
	
	private Cypher cypher = new Cypher();
	
	@GetMapping("/coupons")
	public List<Coupon> getAllCoupons()
	{
		return couponRepository.findAll();
	}
	
	@GetMapping("/coupons/{couponCypher}")
	public Coupon getCouponByCypher(@PathVariable String couponCypher)
	{
		Coupon coupon = couponRepository.findByCouponCypher(couponCypher);
		return coupon;
	}
	
	@PostMapping("/coupons")
	public ResponseEntity<Map<String, String>> createCoupon(@RequestBody Coupon coupon)
	{
		try {
			coupon.setCouponCypher(cypher.toHexString(cypher.getSHA(coupon.getName())));
			couponRepository.save(coupon);
			Map<String, String> body = new HashMap<>();
	        body.put("couponCypher", coupon.getCouponCypher());
	        return new ResponseEntity<>(body, HttpStatus.CREATED);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);


	}
}
