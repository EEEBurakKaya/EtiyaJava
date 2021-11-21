package com.etiya.RentACarSpring.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.RentACarSpring.business.abstracts.ColorService;
import com.etiya.RentACarSpring.business.dtos.ColorSearchListDto;
import com.etiya.RentACarSpring.business.requests.CreateColorRequest;
import com.etiya.RentACarSpring.business.requests.DeleteColorRequest;
import com.etiya.RentACarSpring.business.requests.UpdateColorRequest;
import com.etiya.RentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACarSpring.core.utilities.results.DataResult;
import com.etiya.RentACarSpring.core.utilities.results.Result;
import com.etiya.RentACarSpring.core.utilities.results.SuccessDataResult;
import com.etiya.RentACarSpring.core.utilities.results.SuccessResult;
import com.etiya.RentACarSpring.dataAccess.abstracts.ColorDao;
import com.etiya.RentACarSpring.entities.Color;

@Service
public class ColorManager implements ColorService{

	private ColorDao colorDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public ColorManager(ColorDao colorDao, ModelMapperService modelMapperService) {
		super();
		this.colorDao = colorDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<ColorSearchListDto>> getAll() {
		List<Color> result = this.colorDao.findAll();
		List<ColorSearchListDto> response = result.stream()
				.map(color->modelMapperService.forDto()
				.map(color, ColorSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ColorSearchListDto>>(response, "Renkler Eklendi");
		
	}

	@Override
	public Result save(CreateColorRequest createColoRequest) {
		Color color = modelMapperService.forRequest().map(createColoRequest, Color.class);
        this.colorDao.save(color); 
        return new SuccessResult("Renk eklendi.");
	}
	

	@Override
	public Result update(UpdateColorRequest updateColorRequest) {
		Color color = modelMapperService.forRequest().map(updateColorRequest, Color.class);
		this.colorDao.save(color);
		return new SuccessResult("Renk güncellendi.");
	}

	@Override
	public Result delete(DeleteColorRequest deleteColorRequest) {
		Color color = modelMapperService.forRequest().map(deleteColorRequest, Color.class);
		this.colorDao.delete(color);
		return new SuccessResult("Renk silindi.");
	}
	

}
