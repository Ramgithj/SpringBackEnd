package com.qa.car.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.car.persistence.domain.Car;
import com.qa.car.services.CarService;

@RestController
public class CarController {

	private CarService service;

	public CarController(CarService service) {
		super();
		this.service = service;
	}

	@GetMapping("/greeting")
	public String greeting() {
		return "Hello, World!";
	}

	@PostMapping("/create")
	public ResponseEntity<Car> createCar(@RequestBody Car car) {
		System.out.println(car);
		return new ResponseEntity<Car>(this.service.createCar(car), HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<Car>> getCar() {
		return ResponseEntity.ok(this.service.getCar());
	}

	@PutMapping("/update")
	public ResponseEntity<Car> updateCar(@RequestBody Car car, @PathParam("id") Long id) {
//		this.service..remove(id);
//		this.carDB.add(id, car);
		return new ResponseEntity<Car>(this.service.updateCar(car, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> deleteCar(@PathVariable Long id) {
		if (this.service.deleteCar(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
