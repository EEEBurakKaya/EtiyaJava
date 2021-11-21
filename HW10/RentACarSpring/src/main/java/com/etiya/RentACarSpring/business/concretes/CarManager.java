package com.etiya.RentACarSpring.business.concretes;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.RentACarSpring.business.abstracts.CarService;
import com.etiya.RentACarSpring.business.dtos.CarSearchListDto;
import com.etiya.RentACarSpring.business.requests.CreateCarRequest;
import com.etiya.RentACarSpring.business.requests.DeleteCarRequest;
import com.etiya.RentACarSpring.business.requests.UpdateCarRequest;
import com.etiya.RentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACarSpring.core.utilities.results.DataResult;
import com.etiya.RentACarSpring.core.utilities.results.Result;
import com.etiya.RentACarSpring.core.utilities.results.SuccessDataResult;
import com.etiya.RentACarSpring.core.utilities.results.SuccessResult;
import com.etiya.RentACarSpring.dataAccess.abstracts.CarDao;
import com.etiya.RentACarSpring.entities.Car;

@Service
public class CarManager implements CarService{

	private CarDao carDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CarManager(CarDao carDao, ModelMapperService modelMapperService) {
		super();
		this.carDao = carDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<CarSearchListDto>> getAll() {
        List<Car> result=this.carDao.findAll();
        List<CarSearchListDto> response = result.stream().map(car->modelMapperService.forDto()
        		.map(car,CarSearchListDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<CarSearchListDto>>(response, "Arabalar iistelendi");
        
	}

	@Override
	public Result save(CreateCarRequest createRequest) {
		Car car = modelMapperService.forRequest().map(createRequest, Car.class);
	    this.carDao.save(car);
		return new SuccessResult("Arabalar eklendi");
	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {
		Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);
	    carDao.save(car);
		return new SuccessResult("Araba Güncellendi");
	}

	@Override
	public Result delete(DeleteCarRequest deleteCarRequest) {
		Car car = modelMapperService.forRequest().map(deleteCarRequest, Car.class);
	    carDao.delete(car);
		return new SuccessResult("Araba silindi.");
	}

}
