package com.etiya.RentACarSpring.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.RentACarSpring.business.abstracts.BrandService;
import com.etiya.RentACarSpring.business.dtos.BrandSearchListDto;
import com.etiya.RentACarSpring.business.requests.CreateBrandRequest;
import com.etiya.RentACarSpring.business.requests.DeleteBrandRequest;
import com.etiya.RentACarSpring.business.requests.UpdateBrandRequest;
import com.etiya.RentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACarSpring.core.utilities.results.DataResult;
import com.etiya.RentACarSpring.core.utilities.results.Result;
import com.etiya.RentACarSpring.core.utilities.results.SuccessDataResult;
import com.etiya.RentACarSpring.core.utilities.results.SuccessResult;
import com.etiya.RentACarSpring.dataAccess.abstracts.BrandDao;
import com.etiya.RentACarSpring.entities.Brand;

@Service
public class BrandManager implements BrandService{

	private BrandDao brandDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public BrandManager(BrandDao brandDao, ModelMapperService modelMapperService) {
		super();
		this.brandDao = brandDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<BrandSearchListDto>> getAll() {
		List<Brand> result = this.brandDao.findAll();
		List<BrandSearchListDto> response = result.stream().map(brand->modelMapperService.forDto()
				.map(brand, BrandSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<BrandSearchListDto>>(response, "Marka Eklendi");
	}

	@Override
	public Result save(CreateBrandRequest createBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandDao.save(brand);
		return new SuccessResult("Marka eklendi.");
	}

	@Override
	public Result update(UpdateBrandRequest updateBrandResuest) {
		Brand brand = modelMapperService.forRequest().map(updateBrandResuest, Brand.class);
		this.brandDao.save(brand);
		return new SuccessResult("Marka güncellendi.");
	}

	@Override
	public Result delete(DeleteBrandRequest deleteBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(deleteBrandRequest, Brand.class);
		this.brandDao.delete(brand);
		return new SuccessResult("Marka Silindi");
	}
	


}
