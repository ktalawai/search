package com.sap.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.search.data.ProductData;
import com.sap.search.data.ProductResponse;
import com.sap.search.service.SearchService;

@RestController
@RequestMapping(value="/search")
public class SearchController {
	
	@Autowired
	SearchService service;
	
	@GetMapping(value="/product")
	public ProductResponse getAllProducts(){
		return service.getAllProducts();
	}
	
	@PostMapping(value="/product")
	public ProductResponse postProduct(@RequestBody ProductData productData){
		ProductResponse response = service.createProduct(productData);
		return response;
	}
	
	@GetMapping(value="/sku/{skuId}")
	public ProductResponse getBySkuId(@PathVariable String skuId) {
		ProductResponse response = service.getBySkU(skuId);
		return response;
	}
	
	@GetMapping(value="/brand/{brandId}")
	public ProductResponse getByBrand(@PathVariable String brandId) {
		ProductResponse response = service.getByBrand(brandId);
		return response;
	}
	
	@GetMapping(value="/seller/{sellerId}")
	public ProductResponse getBySeller(@PathVariable String sellerId) {
		ProductResponse response = service.getBySeller(sellerId);
		return response;
	}
	
	@GetMapping(value="/color/{color}")
	public ProductResponse getByColor(@PathVariable String color) {
		ProductResponse response = service.getByColor(color);
		return response;
	}
	
	@GetMapping(value="/price/{from}/{to}")
	public ProductResponse getByPrice(@PathVariable String from, @PathVariable String to) {
		ProductResponse response = service.getBypriceRange(from,to);
		return response;
	}
	
	@GetMapping(value="/size/{size}")
	public ProductResponse getBySize(@PathVariable String size) {
		ProductResponse response = service.getBySize(size);
		return response;
	}

	
	@GetMapping(value="/displayName/{displayName}")
	public ProductResponse getByDisplayName(@PathVariable String displayName) {
		ProductResponse response = service.getByDisplayName(displayName);
		return response;
	}
	
	@DeleteMapping(value="/product/{prodId}")
	public ProductResponse deleteProduct(@PathVariable String prodId) {
		ProductResponse response = service.deleteProduct(prodId);
		return response;
	}
}
