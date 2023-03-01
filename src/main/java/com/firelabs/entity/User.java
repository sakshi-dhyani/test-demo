package com.firelabs.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private long creationTime;
	private long modificationTime;
	private byte active;
	private byte isEmailVerified;
	@Column(name = "IS_LOGGED_IN")
	private byte isLoggedIn;
	private long lastLoggedInTime;
	private long lastLoggedOutTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}
	public long getModificationTime() {
		return modificationTime;
	}
	public void setModificationTime(long modificationTime) {
		this.modificationTime = modificationTime;
	}
	public byte getActive() {
		return active;
	}
	public void setActive(byte active) {
		this.active = active;
	}
	public byte getIsEmailVerified() {
		return isEmailVerified;
	}
	public void setIsEmailVerified(byte isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}
	public byte getIsLoggedIn() {
		return isLoggedIn;
	}
	public void setIsLoggedIn(byte isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public long getLastLoggedInTime() {
		return lastLoggedInTime;
	}
	public void setLastLoggedInTime(long lastLoggedInTime) {
		this.lastLoggedInTime = lastLoggedInTime;
	}
	public long getLastLoggedOutTime() {
		return lastLoggedOutTime;
	}
	public void setLastLoggedOutTime(long lastLoggedOutTime) {
		this.lastLoggedOutTime = lastLoggedOutTime;
	}
	
	
	 

}
