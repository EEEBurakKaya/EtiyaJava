package com.etiya.RentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.RentACar.entities.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer> {

//	@Query(value = "Select new com.etiya.RentACar.entities.complexTypes.BrandDetail"
//			+ "(c.id,b.brandName,cl.colorName,c.modelYear,c.dailyPrice,c.description) "
//			+ "From Car c Inner Join c.brand b Inner Join c.color cl ", nativeQuery = true)

	List<Brand> getByBrandNameContains(String brandName);

}