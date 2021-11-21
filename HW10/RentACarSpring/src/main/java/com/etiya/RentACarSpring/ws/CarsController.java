package com.etiya.RentACarSpring.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.etiya.RentACarSpring.business.abstracts.CarService;
import com.etiya.RentACarSpring.business.dtos.CarSearchListDto;
import com.etiya.RentACarSpring.business.requests.CreateCarRequest;
import com.etiya.RentACarSpring.business.requests.DeleteCarRequest;
import com.etiya.RentACarSpring.business.requests.UpdateCarRequest;
import com.etiya.RentACarSpring.core.utilities.results.DataResult;
import com.etiya.RentACarSpring.core.utilities.results.Result;

@RestController
@RequestMapping("api/cars")
public class CarsController {

	private CarService carService;
    
	@Autowired
	private CarsController(CarService carService) {
		super();
		this.carService = carService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<CarSearchListDto>> getAll() {
		return this.carService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody CreateCarRequest createCarRequest) {
		return this.carService.save(createCarRequest);
	}
    @PutMapping("update")
    public Result update(@RequestBody UpdateCarRequest updateCarRequest) {
    	return this.carService.update(updateCarRequest);
    }
	@DeleteMapping
	public Result delete(@RequestBody DeleteCarRequest deleteCarRequest) {
		return this.carService.delete(deleteCarRequest);
	}
}
