package com.sap.search.data;

import java.time.Instant;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductResponse {
	
	int errorCode;
	String msg;
	Instant timestamp;
	List<ProductData> productData;

}
