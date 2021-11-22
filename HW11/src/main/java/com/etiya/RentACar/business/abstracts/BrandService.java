package com.etiya.RentACar.business.abstracts;

import java.util.List;

import com.etiya.RentACar.business.dtos.BrandSearchListDto;
import com.etiya.RentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.RentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.RentACar.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.RentACar.core.utilities.results.DataResult;

public interface BrandService {
	
	List<BrandSearchListDto> getBrands();
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(DeleteBrandRequest deleteBrandRequest);
	DataResult<List<BrandSearchListDto>> getByBrandName(String brandName);

}