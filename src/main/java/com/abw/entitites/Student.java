package com.abw.entitites;

import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="STUDENTS")
public class Student {
	@Id
	@Column(name="RNO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer rno;

	@Column(name="NAME")
	private String name;

	@Column(name="PER")
	private Double per;

	@Column(name="CITY")
	private String city;

	@Column(name="DATE_CREATED")
	@CreationTimestamp
	private LocalDateTime dateCreated;

	@Column(name="DATE_UPDATED")
	@UpdateTimestamp
	private LocalDateTime lastUpdated;

	public Integer getRno() {
		return rno;
	}

	public void setRno(Integer rno) {
		this.rno=rno;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}

	public Double getPer()
	{
		return per;
	}
	public void setPer(Double per) {
		this.per=per;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city)
	{
		this.city=city;
	}

	public LocalDateTime getDateCreated()
	{
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated=dateCreated;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated=lastUpdated;
	}

}
