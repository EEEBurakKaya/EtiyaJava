package com.etiya.RentACarSpring.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {
 
	public ErrorDataResult(T data, String message) {
		super(false, message, data);
	}

	public ErrorDataResult(T data) {
		super(false, data);
	}
}
