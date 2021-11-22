package com.etiya.RentACar.business.abstracts;

import java.util.List;

import com.etiya.RentACar.business.dtos.BrandSearchListDto;
import com.etiya.RentACar.business.dtos.CarSearchListDto;
import com.etiya.RentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.RentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.RentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.RentACar.core.utilities.results.DataResult;
import com.etiya.RentACar.entities.complexTypes.BrandDetail;
import com.etiya.RentACar.entities.complexTypes.CarDetail;

public interface CarService {
	
	List<CarSearchListDto> getCars();
	void add(CreateCarRequest createCarRequest);
	void update(UpdateCarRequest updateCarRequest);
	void delete(DeleteCarRequest deleteCarRequest);
	DataResult<List<CarSearchListDto>> getByDescription(String description);
	DataResult<List<CarDetail>> getCarWithOtherDetails();

}