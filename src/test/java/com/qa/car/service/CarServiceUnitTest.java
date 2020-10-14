package com.qa.car.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.car.persistence.domain.Car;
import com.qa.car.persistence.repos.CarRepo;
import com.qa.car.services.CarService;

@SpringBootTest
public class CarServiceUnitTest {

	@Autowired
	private CarService service;

	@MockBean
	private CarRepo repo;

	@Test
	void testCreate() {
		// given

		Long id = 1L;
		Car newCar = new Car("audi", "a3", "auto", 2.0f, "blue", "e12 7lw", 2012, "07879888729", "email@email.com",
				"This is a car description");
		Car savedCar = new Car("audi", "a3", "auto", 2.0f, "blue", "e12 7lw", 2012, "07879888729", "email@email.com",
				"This is a car description");
		// when

		Mockito.when(this.repo.save(newCar)).thenReturn(savedCar);

		// then

		assertThat(this.service.createCar(newCar)).isEqualTo(savedCar);
		Mockito.verify(this.repo, Mockito.times(1)).save(newCar);
	}

	@Test
	void testUpdate() {
		// GIVEN

		Long id = 1L;

		// will be passed in
		Car newCar = new Car("ford", "focus", "auto", 1.8f, "silver", "nw9 7lw", 2012, "07879888729", "email@email.com",
				"This is a new car description");
		// will be found by findById()
		Car oldCar = new Car("audi", "a3", "auto", 2.0f, "blue", "e12 7lw", 2012, "07879888729", "email@email.com",
				"This is a car description");
		// will be saved back to db and returned by method
		Car updatedCar = new Car("ford", "focus", "auto", 1.8f, "silver", "nw9 7lw", 2012, "07879888729",
				"email@email.com", "This is a new car description");
		updatedCar.setId(id);

		// WHEN
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(oldCar));
		Mockito.when(this.repo.save(updatedCar)).thenReturn(updatedCar);

		// THEN
		assertThat(this.service.updateCar(newCar, id)).isEqualTo(updatedCar);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(updatedCar);
	}

	@Test
	void testGet() {
		// given

		Car car = new Car("vw", "golf", "manual", 1.6f, "Red", "st9hj8", 2009, "07777777777", "email@email.com",
				"this is a car");
		car.setId(1L);
		List<Car> cars = new ArrayList<>();
		cars.add(car);

		// when
		Mockito.when(this.repo.findAll()).thenReturn(cars);

		// then

		assertThat(this.service.getCar()).isEqualTo(cars);
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	void testDelete() {
		// given
		Long id = 1L;
		boolean found = false;

		// when
		Mockito.when(this.repo.existsById(id)).thenReturn(found);

		// then
		assertThat(this.service.deleteCar(id)).isEqualTo(!found);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}

}
