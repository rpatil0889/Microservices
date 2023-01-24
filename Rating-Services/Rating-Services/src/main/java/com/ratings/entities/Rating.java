package com.ratings.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "ratings")
@Data
public class Rating {
	@Id
	private String ratinId;
	private String userId;
	private String hotelId;
	private double ratings;
	private String feedback;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date created;
}
