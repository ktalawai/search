package com.sap.search.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sap.search.data.ProductData;
import com.sap.search.data.ProductResponse;
import com.sap.search.entity.Product;
import com.sap.search.repository.ProductRepository;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	@CacheEvict(value = "prodInfo", allEntries = true)
	@Transactional
	public ProductResponse createProduct(ProductData data) {
		Product product = Product.builder().brandId(data.getBrandId()).id(data.getId()).catgeoryId(data.getCatgeoryId())
				.skuId(data.getSkuId()).color(data.getColor()).price(data.getPrice()).sellerId(data.getSellerId())
				.qty(data.getQty()).displayName(data.getDisplayName()).size(data.getSize()).build();
		productRepository.save(product);
		return null;
	}

	@Cacheable(value = "prodInfo")
	@Override
	public ProductResponse getAllProducts() {
		ProductResponse response = null;
		List<ProductData> prodList = new ArrayList<>();
		List<Product> products = productRepository.findAll();
		if (CollectionUtils.isEmpty(products)) {
			response = ProductResponse.builder().productData(prodList).timestamp(Instant.now()).msg("failure")
					.errorCode(999).build();
		} else {
			products.forEach(product -> createResponse(prodList, product));
			response = ProductResponse.builder().productData(prodList).timestamp(Instant.now()).msg("success")
					.errorCode(0).build();
		}
		return response;
	}
	
	@Override
	public ProductResponse getByDisplayName(String displayName) {
		Optional<List<Product>> prodOpt = productRepository.findByDisplayNameContaining(displayName);
		ProductResponse response = null;
		List<ProductData> prodList = new ArrayList<>();
		if (prodOpt.isPresent()) {
			List<Product> productList = prodOpt.get();
			productList.forEach(product -> createResponse(prodList, product));
			response = ProductResponse.builder().productData(prodList).timestamp(Instant.now()).msg("success")
					.errorCode(0).build();
		} else {
			response = ProductResponse.builder().productData(prodList).timestamp(Instant.now()).msg("failure")
					.errorCode(999).build();
		}
		return response;

	}
	
	@Override
	public ProductResponse getBypriceRange(String from, String to) {
		Optional<List<Product>> prodOpt = productRepository.findByPriceBetween(Double.valueOf(from),
				Double.valueOf(to));
		ProductResponse response = null;
		List<ProductData> prodList = new ArrayList<>();
		if (prodOpt.isPresent()) {
			List<Product> productList = prodOpt.get();
			productList.forEach(product -> createResponse(prodList, product));
			response = ProductResponse.builder().productData(prodList).timestamp(Instant.now()).msg("success")
					.errorCode(0).build();
		} else {
			response = ProductResponse.builder().productData(prodList).timestamp(Instant.now()).msg("failure")
					.errorCode(999).build();
		}
		return response;

	}

	@Override
	public ProductResponse getBySkU(String skuId) {
		Optional<List<Product>> prodOpt = productRepository.findBySkuId(skuId);
		ProductResponse response = null;
		List<ProductData> prodList = new ArrayList<>();
		if (prodOpt.isPresent()) {
			List<Product> productList = prodOpt.get();
			productList.forEach(product -> createResponse(prodList, product));
			response = ProductResponse.builder().productData(prodList).timestamp(Instant.now()).msg("success")
					.errorCode(0).build();
		} else {
			response = ProductResponse.builder().productData(prodList).timestamp(Instant.now()).msg("failure")
					.errorCode(999).build();
		}
		return response;
	}

	private void createResponse(List<ProductData> prodList, Product product) {
		ProductData prodData = ProductData.builder().brandId(product.getBrandId()).id(product.getId())
				.catgeoryId(product.getCatgeoryId()).skuId(product.getSkuId()).color(product.getColor())
				.price(product.getPrice()).sellerId(product.getSellerId()).qty(product.getQty())
				.displayName(product.getDisplayName()).size(product.getSize()).build();
		prodList.add(prodData);
	}

	@Override
	public ProductResponse getByBrand(String brandId) {
		Optional<List<Product>> prodOpt = productRepository.findByBrandId(brandId);
		ProductResponse response = null;
		List<ProductData> prodList = new ArrayList<>();
		if (prodOpt.isPresent()) {
			List<Product> productList = prodOpt.get();
			productList.forEach(product -> createResponse(prodList, product));
			response = ProductResponse.builder().productData(prodList).timestamp(Instant.now()).msg("success")
					.errorCode(0).build();
		} else {
			response = ProductResponse.builder().productData(prodList).timestamp(Instant.now()).msg("failure")
					.errorCode(999).build();
		}
		return response;

	}

	@Override
	public ProductResponse getBySeller(String sellerId) {

		Optional<List<Product>> prodOpt = productRepository.findBySellerId(sellerId);
		ProductResponse response = null;
		List<ProductData> prodList = new ArrayList<>();
		if (prodOpt.isPresent()) {
			List<Product> productList = prodOpt.get();
			productList.forEach(product -> createResponse(prodList, product));
			response = ProductResponse.builder().productData(prodList).timestamp(Instant.now()).msg("success")
					.errorCode(0).build();
		} else {
			response = ProductResponse.builder().productData(prodList).timestamp(Instant.now()).msg("failure")
					.errorCode(999).build();
		}
		return response;

	}

	@Override
	public ProductResponse getByColor(String color) {
		Optional<List<Product>> prodOpt = productRepository.findByColor(color);
		ProductResponse response = null;
		List<ProductData> prodList = new ArrayList<>();
		if (prodOpt.isPresent()) {
			List<Product> productList = prodOpt.get();
			productList.forEach(product -> createResponse(prodList, product));
			response = ProductResponse.builder().productData(prodList).timestamp(Instant.now()).msg("success")
					.errorCode(0).build();
		} else {
			response = ProductResponse.builder().productData(prodList).timestamp(Instant.now()).msg("failure")
					.errorCode(999).build();
		}
		return response;

	}

	

	@Override
	public ProductResponse getBySize(String size) {
		Optional<List<Product>> prodOpt = productRepository.findBySize(size);
		ProductResponse response = null;
		List<ProductData> prodList = new ArrayList<>();
		if (prodOpt.isPresent()) {
			List<Product> productList = prodOpt.get();
			productList.forEach(product -> createResponse(prodList, product));
			response = ProductResponse.builder().productData(prodList).timestamp(Instant.now()).msg("success")
					.errorCode(0).build();
		} else {
			response = ProductResponse.builder().productData(prodList).timestamp(Instant.now()).msg("failure")
					.errorCode(999).build();
		}
		return response;

	}

	@Override
	@Transactional
	public ProductResponse deleteProduct(String prodId) {
		productRepository.deleteById(prodId);
		return ProductResponse.builder().productData(new ArrayList<>()).timestamp(Instant.now()).msg("success")
				.errorCode(0).build();
	}
	
	

}
