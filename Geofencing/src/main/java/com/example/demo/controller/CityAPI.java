package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CityVendor;



@RestController
@RequestMapping(value = "/CityVendor", produces = "application/json")
public class CityAPI 
{
    
	@GetMapping("/{CityId}")
	public CityVendor getCityVendorDetails(@PathVariable("CityId") String cityId)
	{
		return new CityVendor( "C1", "chennai",  13.08,  80.27);
	}
}
