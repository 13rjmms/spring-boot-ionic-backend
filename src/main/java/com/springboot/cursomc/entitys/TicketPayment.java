package com.springboot.cursomc.entitys;

import java.util.Date;

import javax.persistence.Entity;

import com.springboot.cursomc.entitys.enums.PaymentStatus;

@Entity
public class TicketPayment extends Payment {
	private static final long serialVersionUID = 1L;
	
	private Date paymentDate;
	private Date expirationDate;
	
	public TicketPayment() {
	}

	public TicketPayment(Integer id, PaymentStatus status, Request order, Date paymentDate, Date expirationDate) {
		super(id, status, order);
		this.expirationDate = expirationDate;
		this.paymentDate = paymentDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
	
	
	
	

}
