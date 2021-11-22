package com.etiya.RentACar.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
//	@Column(name = "brand_id")
//	private int brandId;
//	@Column(name = "color_id")
//	private int colorId;
	@Column(name = "year")
	private int year;
	@Column(name = "daily_price")
	private double dailyPrice;
	@Column(name = "description")
	private String description;
	
//	@Column(name = "car_name")
//	private String carName;
	
	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

}