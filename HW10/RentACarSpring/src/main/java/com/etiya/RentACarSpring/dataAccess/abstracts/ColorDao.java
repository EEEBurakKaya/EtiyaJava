package com.etiya.RentACarSpring.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.RentACarSpring.entities.Color;

public interface ColorDao extends JpaRepository<Color, Integer>{

}
