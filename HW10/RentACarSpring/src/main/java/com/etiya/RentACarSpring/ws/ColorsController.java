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

import com.etiya.RentACarSpring.business.abstracts.ColorService;
import com.etiya.RentACarSpring.business.dtos.ColorSearchListDto;
import com.etiya.RentACarSpring.business.requests.CreateColorRequest;
import com.etiya.RentACarSpring.business.requests.DeleteColorRequest;
import com.etiya.RentACarSpring.business.requests.UpdateColorRequest;
import com.etiya.RentACarSpring.core.utilities.results.DataResult;
import com.etiya.RentACarSpring.core.utilities.results.Result;

@RestController
@RequestMapping("api/colors")

public class ColorsController {

	private ColorService colorService;

	@Autowired
	public ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<ColorSearchListDto>> getAll() {
		return this.colorService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody CreateColorRequest createColorRequest) {
		return this.colorService.save(createColorRequest);
	}
    @PutMapping("update")
    public Result update(@RequestBody UpdateColorRequest updateColorRequest) {
    	return this.colorService.update(updateColorRequest);
    }
	@DeleteMapping
	public Result delete(@RequestBody DeleteColorRequest deleteColorRequest) {
		return this.colorService.delete(deleteColorRequest);
	}
	
}
