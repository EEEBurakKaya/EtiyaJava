package com.etiya.RentACarSpring.business.abstracts;

import java.util.List;

import com.etiya.RentACarSpring.business.dtos.ColorSearchListDto;
import com.etiya.RentACarSpring.business.requests.CreateColorRequest;
import com.etiya.RentACarSpring.business.requests.DeleteColorRequest;
import com.etiya.RentACarSpring.business.requests.UpdateColorRequest;
import com.etiya.RentACarSpring.core.utilities.results.DataResult;
import com.etiya.RentACarSpring.core.utilities.results.Result;

public interface ColorService {

	DataResult<List<ColorSearchListDto>> getAll();
	Result save (CreateColorRequest createColoRequest);
	Result update (UpdateColorRequest updateColorRequest);
	Result delete (DeleteColorRequest deleteColorRequest);
	
}
