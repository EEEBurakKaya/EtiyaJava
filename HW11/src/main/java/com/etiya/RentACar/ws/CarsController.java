package com.etiya.RentACar.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.RentACar.business.abstracts.CarService;
import com.etiya.RentACar.business.dtos.CarSearchListDto;

import com.etiya.RentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.RentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.RentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.RentACar.core.utilities.results.DataResult;
import com.etiya.RentACar.entities.complexTypes.CarDetail;

import lombok.Data;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

	private CarService carService;

	@Autowired
	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}

	@PostMapping(path  = "/add")
	public void add(@RequestBody CreateCarRequest carRequest) {
		this.carService.add(carRequest);

	}

	@PutMapping(path = "/update")
	public void update(@RequestBody UpdateCarRequest updateCarRequest) {
		this.carService.update(updateCarRequest);
	}

	@DeleteMapping(path = "/delete")
	public void delete(@RequestBody DeleteCarRequest deleteCarRequest) {
		this.carService.delete(deleteCarRequest);
	}

	@GetMapping(path = "/getCars")
	public List<CarSearchListDto> getCars() {

		return carService.getCars();
	}
	
	@GetMapping("getByDescription")
	public DataResult<List<CarSearchListDto>> getByDescription(@RequestParam("carDetails") String description) {
		return this.carService.getByDescription(description);
	}
	
	@GetMapping("detailedCars")
	public DataResult<List<CarDetail>> getDetailedCars() {
		return this.carService.getCarWithOtherDetails();
	}

}