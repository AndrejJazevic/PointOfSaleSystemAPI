package com.prada.prada.eventhistory;

public class EventHistory {
	private int id;
	private String date;
	private String eventInformation;
	private int employeeId;
	
	public EventHistory(int id, String date, String eventInformation, int employeeId) {
		super();
		this.id = id;
		this.date = date;
		this.eventInformation = eventInformation;
		this.employeeId = employeeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEventInformation() {
		return eventInformation;
	}

	public void setEventInformation(String eventInformation) {
		this.eventInformation = eventInformation;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
}
