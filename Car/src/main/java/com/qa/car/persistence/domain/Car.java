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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + Float.floatToIntBits(engineSize);
		result = prime * result + ((gearbox == null) ? 0 : gearbox.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((postCodeLastSeen == null) ? 0 : postCodeLastSeen.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (contactNumber == null) {
			if (other.contactNumber != null)
				return false;
		} else if (!contactNumber.equals(other.contactNumber))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (Float.floatToIntBits(engineSize) != Float.floatToIntBits(other.engineSize))
			return false;
		if (gearbox == null) {
			if (other.gearbox != null)
				return false;
		} else if (!gearbox.equals(other.gearbox))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (postCodeLastSeen == null) {
			if (other.postCodeLastSeen != null)
				return false;
		} else if (!postCodeLastSeen.equals(other.postCodeLastSeen))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

}
