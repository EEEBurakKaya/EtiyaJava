package com.etiya.RentACarSpring.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.RentACarSpring.entities.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer> {

}
