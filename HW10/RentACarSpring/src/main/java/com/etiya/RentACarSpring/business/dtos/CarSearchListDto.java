package com.etiya.RentACarSpring.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarSearchListDto {

	private int id;
	private int ModelYear;
	private int DailyPrice;
	private String description;
}
