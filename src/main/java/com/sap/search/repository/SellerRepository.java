package com.sap.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sap.search.entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer>{

}
