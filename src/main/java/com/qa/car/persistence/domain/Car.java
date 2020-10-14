package com.qa.car.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String make;
	private String model;
	private String gearbox;
	private float engineSize;
	private String colour;
	private String postCodeLastSeen;
	private int year;
	private String contactNumber;
	private String email;
	private String description;

	public Car() {
		super();
	}

	public Car(String make, String model, String gearbox, float engineSize, String colour, String postCodeLastSeen,
			int year, String contactNumber, String email, String description) {
		super();
		this.make = make;
		this.model = model;
		this.gearbox = gearbox;
		this.engineSize = engineSize;
		this.colour = colour;
		this.postCodeLastSeen = postCodeLastSeen;
		this.year = year;
		this.contactNumber = contactNumber;
		this.email = email;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getGearbox() {
		return gearbox;
	}

	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}

	public float getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(float engineSize) {
		this.engineSize = engineSize;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getPostCodeLastSeen() {
		return postCodeLastSeen;
	}

	public void setPostCodeLastSeen(String postCodeLastSeen) {
		this.postCodeLastSeen = postCodeLastSeen;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
