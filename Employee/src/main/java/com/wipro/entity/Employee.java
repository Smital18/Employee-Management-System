package com.wipro.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity


public class Employee {
	@Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @NotNull

    @Size(min=3,message ="Valid Name (atleast 3 characters) is required")

    private String firstName;

    @NotNull

    @Size(min=3,message ="Valid Name (atleast 3 characters) is required")

    private String lastName;

    @NotNull
    @Size(min=5,message ="Valid Email is required")

    private String email;

    @NotNull

    @Size(min=8,message ="password must contain atleast 8 characters")

    private String password;

    @NotNull
    @Size(min=3,message ="Valid Location is required")
    

    private String location;

    @NotNull

    @Size(min=10,message ="Enter valid phone number")

    private String phone;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String firstName,
			String lastName, String email,
			 String password, String location,
			String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.location = location;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", location=" + location + ", phone=" + phone + "]";
	}
	
    
   
	

}
