package com.sap.search.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
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
