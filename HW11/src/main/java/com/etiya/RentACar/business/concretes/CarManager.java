package com.etiya.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.RentACar.business.abstracts.CarService;
import com.etiya.RentACar.business.dtos.CarSearchListDto;

import com.etiya.RentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.RentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.RentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.RentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACar.core.utilities.results.DataResult;
import com.etiya.RentACar.core.utilities.results.SuccessDataResult;
import com.etiya.RentACar.dataAccess.abstracts.CarDao;
import com.etiya.RentACar.entities.Car;
import com.etiya.RentACar.entities.complexTypes.CarDetail;

@Service
public class CarManager implements CarService {

	private CarDao carDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public CarManager(CarDao carDao, ModelMapperService modelMapperService) {
		super();
		this.carDao = carDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<CarSearchListDto> getCars() {

		List<Car> result = this.carDao.findAll();
		List<CarSearchListDto> response = result.stream()
				.map(Car -> modelMapperService.forDto().map(Car, CarSearchListDto.class)).collect(Collectors.toList());

		return response;

	}

	@Override
	public void add(CreateCarRequest createCarRequest) {

		Car result = modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carDao.save(result);

	}

	@Override
	public void update(UpdateCarRequest updateCarRequest) {
		Car result = modelMapperService.forRequest().map(updateCarRequest, Car.class);
		this.carDao.save(result);

	}

	@Override
	public void delete(DeleteCarRequest deleteCarRequest) {
		Car result = modelMapperService.forRequest().map(deleteCarRequest, Car.class);
		this.carDao.delete(result);

	}

		@Override
	public DataResult<List<CarSearchListDto>> getByDescription(String description) {
		List<CarSearchListDto> result = this.carDao.getByDescriptionContains(description).stream()
				.map(product -> modelMapperService.forDto().map(product, CarSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<CarSearchListDto>>(result);
	}

	@Override
	public DataResult<List<CarDetail>> getCarWithOtherDetails() {
		List<CarDetail> result = this.carDao.getCarWithOtherDetails();
		return new SuccessDataResult<List<CarDetail>>(result);

	}

}