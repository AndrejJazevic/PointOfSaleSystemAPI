package com.prada.prada.order;

public class Order {
	private int id;
	private int status;
	private String creationDate;
	private String complitionDate;
	private int discount;
	private int employeeId;
	private int customerId;
	
	public Order(int id, int status, String creationDate, String complitionDate, int discount, int employeeId,
			int customerId) {
		super();
		this.id = id;
		this.status = status;
		this.creationDate = creationDate;
		this.complitionDate = complitionDate;
		this.discount = discount;
		this.employeeId = employeeId;
		this.customerId = customerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getComplitionDate() {
		return complitionDate;
	}

	public void setComplitionDate(String complitionDate) {
		this.complitionDate = complitionDate;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}
