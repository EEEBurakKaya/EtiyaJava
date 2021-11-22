package com.etiya.RentACar.ws;

import java.util.ArrayList;
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

import com.etiya.RentACar.business.abstracts.ColorService;
import com.etiya.RentACar.business.dtos.BrandSearchListDto;
import com.etiya.RentACar.business.dtos.ColorSearchListDto;
import com.etiya.RentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.RentACar.business.requests.colorRequests.DeleteColorRequest;
import com.etiya.RentACar.business.requests.colorRequests.UpdateColorRequest;
import com.etiya.RentACar.core.utilities.results.DataResult;
import com.etiya.RentACar.entities.Color;

@RestController
@RequestMapping("/api/colors")
public class ColorsController {

	private ColorService colorService;

	@Autowired
	public ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}

	@GetMapping(path = "/getColors")
	public List<ColorSearchListDto> getColors() {

		return colorService.getColors();

	}

	@PostMapping(path = "/add")
	public void add(@RequestBody CreateColorRequest createColorRequest) {
		this.colorService.add(createColorRequest);
	}

	@PutMapping(path = "/update")
	public void update(@RequestBody UpdateColorRequest updateColorRequest) {
		this.colorService.update(updateColorRequest);
	}

	@DeleteMapping(path = "/delete")
	public void delete(@RequestBody DeleteColorRequest deleteColorRequest) {
		this.colorService.delete(deleteColorRequest);
	}

	@GetMapping(path = "/getByColorName")
	public DataResult<List<ColorSearchListDto>> getByBrandName(@RequestParam("colorName") String colorName) {
		return this.colorService.getByColorName(colorName);

	}

}