package com.springboot.cursomc.entitys.enums;

public enum PaymentStatus {

	PENDING(1, "Pending"),
	PAID(2, "Paid"), 
	CANCELLED(3, "Cancelled");

	private int cod;
	private String description;

	private PaymentStatus(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static PaymentStatus toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (PaymentStatus payment : PaymentStatus.values()) {
			if (cod.equals(payment.getCod())) {
				return payment;
			}

		}

		throw new IllegalArgumentException("Invalid Id " + cod);
	}

}
