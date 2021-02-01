package com.sap.search.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductData {
	String id;

	String brandId;

	String sellerId;

	String skuId;

	String catgeoryId;

	int qty;

	double price;

	String displayName;

	String color;

	String size;
}
