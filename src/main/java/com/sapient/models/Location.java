package com.sapient.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "locations")

public class Location {

	@Id
	String id;

	String code;
	String description;
	Date createdDate;
	Date modifiedDate;
	boolean status;

	public Location() {
		System.out.println("default invoked ########");
		
	}
	
	public Location(String code, String description, Date createdDate, Date modifiedDate, boolean status) {
	//	super();
		
		System.out.println("parameterized invoked ########");
		this.code = code;
		this.description = description;
		this.createdDate = new Date();
		this.modifiedDate = new Date();
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
