package com.etiya.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etiya.RentACar.business.abstracts.BrandService;
import com.etiya.RentACar.business.dtos.BrandSearchListDto;
import com.etiya.RentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.RentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.RentACar.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.RentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACar.core.utilities.results.DataResult;
import com.etiya.RentACar.core.utilities.results.SuccessDataResult;
import com.etiya.RentACar.dataAccess.abstracts.BrandDao;
import com.etiya.RentACar.dataAccess.abstracts.ColorDao;
import com.etiya.RentACar.entities.Brand;

import net.bytebuddy.asm.Advice.This;

@Service
public class BrandManager implements BrandService {

	private BrandDao brandDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public BrandManager(BrandDao brandDao, ModelMapperService modelMapperService) {
		super();
		this.brandDao = brandDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<BrandSearchListDto> getBrands() {

		List<Brand> result = this.brandDao.findAll();
		List<BrandSearchListDto> response = result.stream()
				.map(product -> modelMapperService.forDto().map(product, BrandSearchListDto.class))
				.collect(Collectors.toList());
		return response;

	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandDao.save(brand);

	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandDao.save(brand);

	}

	@Override
	public void delete(DeleteBrandRequest deleteBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(deleteBrandRequest, Brand.class);
		this.brandDao.delete(brand);

	}

	@Override
	public DataResult<List<BrandSearchListDto>> getByBrandName(String brandName) {
		List<BrandSearchListDto> result = this.brandDao.getByBrandNameContains(brandName).stream()
				.map(brand -> modelMapperService.forDto().map(brand, BrandSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<BrandSearchListDto>>(result);
	}

}
