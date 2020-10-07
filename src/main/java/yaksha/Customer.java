package yaksha;

import java.util.*;

public class Customer implements Comparable<Customer> {
	private Integer id;
	private String name;
	private Character gender;
	private String email;
	private String contactNumber;
	private Date createdOn;
	private Address address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer(Integer id, String name, Character gender, String email, String contactNumber, Date createdOn,
			Address address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.contactNumber = contactNumber;
		this.createdOn = createdOn;
		this.address = address;
	}

	// @Override
	public int compareTo(Customer arg0) {
		// TODO Auto-generated method stub
		return this.getAddress().getState().compareTo(arg0.getAddress().getState());
	}
}
