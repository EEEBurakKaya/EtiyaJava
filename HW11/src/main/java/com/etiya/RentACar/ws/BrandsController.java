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

import com.etiya.RentACar.business.abstracts.BrandService;
import com.etiya.RentACar.business.dtos.BrandSearchListDto;
import com.etiya.RentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.RentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.RentACar.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.RentACar.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		super();
		this.brandService = brandService;

	}

	@GetMapping("getByBrandName")
	public DataResult<List<BrandSearchListDto>> getByBrandName(@RequestParam("brandName") String brandName) {
		return this.brandService.getByBrandName(brandName);

	}

	@PostMapping(path = "/add")
	public void add(@RequestBody CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}

	@PutMapping(path = "/update")
	public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}

	@DeleteMapping(path = "/delete")
	public void delete(@RequestBody DeleteBrandRequest brandRequest) {
		this.brandService.delete(brandRequest);
	}

	@GetMapping(path = "/getBrands")
	public List<BrandSearchListDto> getBrands() {
		return brandService.getBrands();

	}

}