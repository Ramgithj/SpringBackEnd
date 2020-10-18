package com.qa.car.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.car.persistence.domain.Car;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:car-schema.sql",
		"classpath:car-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class CarIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Car newCar = new Car("vw", "polo", "manual", (float) 1.6, "silver", "II9,Y76", 2014, "07470989984",
				"email@email.com", "this is a car");
		String requestBody = this.mapper.writeValueAsString(newCar);
		RequestBuilder request = post("/create").contentType(MediaType.APPLICATION_JSON).content(requestBody);

		ResultMatcher checkStatus = status().isCreated();

		Car savedCar = new Car("vw", "polo", "manual", (float) 1.6, "silver", "II9,Y76", 2014, "07470989984",
				"email@email.com", "this is a car");
		savedCar.setId(2L);

		String resultBody = this.mapper.writeValueAsString(savedCar);
		ResultMatcher checkBody = content().json(resultBody);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testUpdate() throws Exception {
		Car newCar = new Car("vw", "polo", "manual", (float) 1.6, "silver", "II9,Y76", 2014, "07470989984",
				"email@email.com", "this is a car");
		String requestBody = this.mapper.writeValueAsString(newCar);
		RequestBuilder request = put("/update?id=1").contentType(MediaType.APPLICATION_JSON).content(requestBody);

		ResultMatcher checkStatus = status().isAccepted();

		Car savedCar = new Car("vw", "polo", "manual", (float) 1.6, "silver", "II9,Y76", 2014, "07470989984",
				"email@email.com", "this is a car");
		savedCar.setId(1L);

		String resultBody = this.mapper.writeValueAsString(savedCar);
		ResultMatcher checkBody = content().json(resultBody);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testDelete() throws Exception {
		RequestBuilder request = delete("/remove/1");
		ResultMatcher checkStatus = status().is(200);

		this.mockMVC.perform(request).andExpect(checkStatus);
	}

	@Test
	void testRead() throws Exception {

		Car car = new Car("vw", "golf", "manual", (float) 1.6, "Red", "st9hj8", 2009, "07777777777", "email@email.com",
				"this is a car");
		car.setId(1L);
		List<Car> cars = new ArrayList<>();
		cars.add(car);
		String responseBody = this.mapper.writeValueAsString(cars);

		this.mockMVC.perform(get("/")).andExpect(status().isOk()).andExpect(content().json(responseBody));

	}
}
