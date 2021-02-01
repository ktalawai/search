package com.sap.search.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sap.search.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

	Optional<List<Product>> findBySkuId(String skuId);

	Optional<List<Product>> findByBrandId(String brandId);

	Optional<List<Product>> findBySize(String size);

	Optional<List<Product>> findByColor(String color);

	Optional<List<Product>> findBySellerId(String sellerId);

	Optional<List<Product>> findByPriceBetween(Double double1, Double double2);

	Optional<List<Product>> findByDisplayNameContaining(String displayName);

	void deleteById(String prodId);
	

}
