package com.prada.prada.shift;

public class Shift {
	private int id;
	private int employeeId;
	private String startDate;
	private String endDate;
	
	public Shift(int id, int employeeId, String startDate, String endDate) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
