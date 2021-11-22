package com.etiya.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.RentACar.business.abstracts.ColorService;
import com.etiya.RentACar.business.dtos.ColorSearchListDto;
import com.etiya.RentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.RentACar.business.requests.colorRequests.DeleteColorRequest;
import com.etiya.RentACar.business.requests.colorRequests.UpdateColorRequest;
import com.etiya.RentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACar.core.utilities.results.DataResult;
import com.etiya.RentACar.core.utilities.results.SuccessDataResult;
import com.etiya.RentACar.dataAccess.abstracts.ColorDao;
import com.etiya.RentACar.entities.Color;

@Service
public class ColorManager implements ColorService {

	private ColorDao colorDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public ColorManager(ColorDao colorDao, ModelMapperService modelMapperService) {
		super();
		this.colorDao = colorDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<ColorSearchListDto> getColors() {

		List<Color> result = this.colorDao.findAll();
		List<ColorSearchListDto> response = result.stream()
				.map(Color -> modelMapperService.forDto().map(Color, ColorSearchListDto.class))
				.collect(Collectors.toList());
		return response;

	}

	@Override
	public void add(CreateColorRequest createColorRequest) {
		Color color = modelMapperService.forRequest().map(createColorRequest, Color.class);
		this.colorDao.save(color);

	}

	@Override
	public void update(UpdateColorRequest updateColorRequest) {
		Color color = modelMapperService.forRequest().map(updateColorRequest, Color.class);
		this.colorDao.save(color);

	}

	@Override
	public void delete(DeleteColorRequest deleteColorRequest) {
		Color color = modelMapperService.forRequest().map(deleteColorRequest, Color.class);
		this.colorDao.delete(color);

	}

	@Override
	public DataResult<List<ColorSearchListDto>> getByColorName(String colorName) {
		List<ColorSearchListDto> result = this.colorDao.getByColorName(colorName).stream()
				.map(product -> modelMapperService.forDto().map(product, ColorSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ColorSearchListDto>>(result);
	}

}