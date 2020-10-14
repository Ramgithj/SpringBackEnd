package com.qa.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.car.exceptions.CarNotFoundException;
import com.qa.car.persistence.domain.Car;
import com.qa.car.persistence.repos.CarRepo;

//@Component
@Service
public class CarService {

//	@Autowired
	private CarRepo repo;

	public CarService(CarRepo repo) {
		super();
		this.repo = repo;
	}

	public Car createCar(Car car) {
		System.out.println(car);
		return this.repo.save(car);
	}

	public List<Car> getCar() {
		return this.repo.findAll();
	}

	public Car updateCar(Car car, Long id) {
		Optional<Car> optCar = this.repo.findById(id);
		Car oldCar = this.repo.findById(id).orElseThrow(() -> new CarNotFoundException());

		oldCar.setColour(car.getColour());
		oldCar.setContactNumber(car.getContactNumber());
		oldCar.setDescription(car.getDescription());
		oldCar.setEmail(car.getEmail());
		oldCar.setEngineSize(car.getEngineSize());
		oldCar.setGearbox(car.getGearbox());
		oldCar.setMake(car.getMake());
		oldCar.setModel(car.getModel());
		oldCar.setPostCodeLastSeen(car.getPostCodeLastSeen());
		oldCar.setYear(car.getYear());

		Car saved = this.repo.save(oldCar);

		return saved;
	}

	public boolean deleteCar(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}