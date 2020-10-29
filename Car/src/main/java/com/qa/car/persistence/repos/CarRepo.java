package com.qa.car.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.car.persistence.domain.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {

}