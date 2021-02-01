package com.sap.search.service;

import com.sap.search.data.ProductData;
import com.sap.search.data.ProductResponse;

public interface SearchService {

	ProductResponse getAllProducts();
	
	ProductResponse createProduct(ProductData data);
	
	ProductResponse getBySkU(String skuId);

	ProductResponse getByBrand(String brandId);

	ProductResponse getBySeller(String sellerId);

	ProductResponse getByColor(String color);

	ProductResponse getBypriceRange(String from, String to);

	ProductResponse getBySize(String size);

	ProductResponse getByDisplayName(String displayName);

	ProductResponse deleteProduct(String prodId);

}
