package com.sucsoft.sample.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="BOOK")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Book implements Serializable{
	@Id
	@Column(name="ID")
	@GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @GeneratedValue(generator = "uuid-generator")
	private String id;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="BOOKSELF_ID")
	private Bookself bookself;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Bookself getBookself() {
		return bookself;
	}
	public void setBookself(Bookself bookself) {
		this.bookself = bookself;
	}
	
}
