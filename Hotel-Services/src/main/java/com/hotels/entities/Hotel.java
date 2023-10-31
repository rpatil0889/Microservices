package com.hotels.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "hotels")
@Data
public class Hotel {
	@Id
	private String hotelId;
	private String hotelName;
	private String hotelAddress;
	private String hotelCity;
	private String hotelState;
	private String hotelDescription;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
}
