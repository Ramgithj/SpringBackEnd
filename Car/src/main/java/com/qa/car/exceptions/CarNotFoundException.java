package com.qa.car.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Car does not exist with that ID")
public class CarNotFoundException extends RuntimeException {

}
