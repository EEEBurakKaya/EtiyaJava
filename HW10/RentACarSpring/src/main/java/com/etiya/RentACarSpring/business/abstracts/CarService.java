package com.etiya.RentACarSpring.business.abstracts;

import java.util.List;

import com.etiya.RentACarSpring.business.dtos.CarSearchListDto;
import com.etiya.RentACarSpring.business.requests.CreateCarRequest;
import com.etiya.RentACarSpring.business.requests.DeleteCarRequest;
import com.etiya.RentACarSpring.business.requests.UpdateCarRequest;
import com.etiya.RentACarSpring.core.utilities.results.DataResult;
import com.etiya.RentACarSpring.core.utilities.results.Result;


public interface CarService {
	DataResult<List<CarSearchListDto>> getAll();
	Result save(CreateCarRequest createCarRequest);
	Result update(UpdateCarRequest updateCarRequest);
	Result delete(DeleteCarRequest DeleteCarRequest);
}
