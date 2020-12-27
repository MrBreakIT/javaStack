package com.johnpike.games.models;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class DateExample {

	@NotEmpty(message = "What type of party is Null?")
	@Size(min = 3, message = "Party must be 3 characters or longer.")
	private String party;

//	@NotEmpty(message = "You need to set a start date!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start;

	// this is the zero arg Constructor
	public DateExample() {
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

}
