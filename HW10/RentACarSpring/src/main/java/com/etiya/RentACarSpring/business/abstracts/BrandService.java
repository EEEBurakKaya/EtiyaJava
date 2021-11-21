package com.etiya.RentACarSpring.business.abstracts;

import java.util.List;

import com.etiya.RentACarSpring.business.dtos.BrandSearchListDto;
import com.etiya.RentACarSpring.business.requests.CreateBrandRequest;
import com.etiya.RentACarSpring.business.requests.DeleteBrandRequest;
import com.etiya.RentACarSpring.business.requests.UpdateBrandRequest;
import com.etiya.RentACarSpring.core.utilities.results.DataResult;
import com.etiya.RentACarSpring.core.utilities.results.Result;


public interface BrandService {
    DataResult<List<BrandSearchListDto>> getAll();
	Result save(CreateBrandRequest createBrandRequest);
	Result update(UpdateBrandRequest updateBrandResuest);
	Result delete (DeleteBrandRequest deleteBrandRequest);
}
