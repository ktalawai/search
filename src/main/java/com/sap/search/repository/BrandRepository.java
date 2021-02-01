package com.sap.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sap.search.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
