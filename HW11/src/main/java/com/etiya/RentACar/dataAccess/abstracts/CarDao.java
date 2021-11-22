package com.etiya.RentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.RentACar.entities.Car;
import com.etiya.RentACar.entities.complexTypes.CarDetail;


public interface CarDao extends JpaRepository<Car, Integer> {
	
	
	List<Car> getByDescriptionContains(String description);
	
	@Query(value="Select new com.etiya.RentACar.entities.complexTypes.CarDetail"
            + "(c.id,b.brandName,cl.colorName,c.modelYear,c.dailyPrice,c.description) "
            + "From Car c Inner Join c.brand b Inner Join c.color cl ",nativeQuery = true)	
	List<CarDetail> getCarWithOtherDetails();
	
//	@Query("Select new com.etiya.northwindSpring.entities.complexTypes.ProductDetail" // JPQL
//			+ "(p.id, p.productName, c.categoryName, p.unitPrice, p.unitsInStock)"
//			+ "From Category c Inner Join c.products p")
//	List<ProductDetail> getProductWithCategoryDetails();


}