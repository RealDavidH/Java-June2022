package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {

	

	// Inside class:
	private Integer employeeID;
	private String role;
	private ArrayList<String> securityIncidents = new ArrayList<String>();;

	// TO DO: Implement a constructor that takes an ID and a role
	// TO DO: Implement HIPAACompliantUser!
	// TO DO: Implement HIPAACompliantAdmin!
	public AdminUser() {
		super();
	}
	public AdminUser(Integer id, String role) {
		super(id);
		this.employeeID = id;
		this.role = role;
	}

	public void newIncident(String notes) {
		String report = String.format("Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", new Date(),
				this.id, notes);
		securityIncidents.add(report);
	}

	public void authIncident() {
		String report = String.format("Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", new Date(), this.id,
				"AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
		securityIncidents.add(report);
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		
		return this.securityIncidents;
	}

	@Override
	public boolean assignPin(int pin) {
		int length = String.valueOf(pin).length();
		System.out.println(length);
		System.out.println(pin);
		System.out.println(length >= 6);
		if(length >= 6) {
			this.pin = pin;
			return true;
		} else {
			
			return false;
		}
		
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(this.employeeID == confirmedAuthID) {
			return true;
		} else {
			authIncident();
			return false;
		}
		
	}

	// TO DO: Setters & Getters
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}

}
