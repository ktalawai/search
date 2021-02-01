package com.sap.search.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "brand")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

	@Id
	int id;

	String brandName;
}
