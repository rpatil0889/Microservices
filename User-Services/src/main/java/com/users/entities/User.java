package com.users.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
	@Id
	private String userId;
	private String userName;
	@Column(unique = true,nullable = false)
	private String userEmail;
	@Column(unique = true,nullable = false)
	private String userMobile;
	private String userCity;
	private String userState;
	private String userAbout;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date userCreated;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdated;
}
