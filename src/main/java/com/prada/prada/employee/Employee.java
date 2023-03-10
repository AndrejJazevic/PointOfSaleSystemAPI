package com.prada.prada.employee;

public class Employee {
	private int id;
	private String name;
	private String lastname;
	private String email;
	private String employeeCardCode;
	
	public Employee(int id, String name, String lastname, String email, String employeeCardCode) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.employeeCardCode = employeeCardCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeCardCode() {
		return employeeCardCode;
	}

	public void setEmployeeCardCode(String employeeCardCode) {
		this.employeeCardCode = employeeCardCode;
	}
	
}
