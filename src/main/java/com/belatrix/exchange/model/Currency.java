package com.belatrix.exchange.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class Currency implements Serializable {

	private static final long serialVersionUID = -5740370435599958663L;

	@Id
	@Column(name="id", unique=true, nullable=false)
	private String id;

	@Column(name="name", nullable=false, length=20)
	private String name;

	@Column(name="symbol", nullable=false, length=3)
	private String symbol;


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
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}
