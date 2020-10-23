package com.springboot.cursomc.entitys;

import javax.persistence.Entity;

import com.springboot.cursomc.entitys.enums.PaymentStatus;

@Entity
public class CardPayment extends Payment {
	private static final long serialVersionUID = 1L;
	
	private Integer plotsNumber;

	public CardPayment() {
	}
	
	

	
	
	public CardPayment(Integer id, PaymentStatus status, Request order,Integer plotsNumber) {
		super(id, status, order);
		this.plotsNumber = plotsNumber;
	}


	public Integer getPlotsNumber() {
		return plotsNumber;
	}

	public void setPlotsNumber(Integer plotsNumber) {
		this.plotsNumber = plotsNumber;
	}
	
	
	
	

}
