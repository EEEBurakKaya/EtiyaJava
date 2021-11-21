package com.etiya.RentACarSpring.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.RentACarSpring.entities.Car;

public interface CarDao extends JpaRepository<Car, Integer> {

}
