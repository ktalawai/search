package com.sap.search.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "seller")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Seller {

	@Id
	int id;

	String sellerName;

}
